package hu.bme.mit.inf.modes3.components.gpiomanager;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.modules.junit4.PowerMockRunnerDelegate;

import com.google.gson.Gson;

/**
 * GpioManager integration tests: Checking GpioManager and Gpio functionalities with mocked GpioProvider and GpioWriter and GpioReader
 * 
 * @author ecsedigergo
 *
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(GpioProvider.class)
@PowerMockRunnerDelegate(Parameterized.class)
public class GpioManagerWithGpioTest {
	private class GpioProperties {
		public String name;
		public int port;
	}

	private static final String GPIOFOLDER = "/sys/class/gpio/";
	private String GPIOVALUEPATH;
	private String GPIODIRECTIONPATH;
	private String GPIOEDGEPATH;
	private GpioProperties[] datas;

	@Parameter(0)
	public int pGpio;

	@Parameter(1)
	public Gpio.Direction pDir;

	@Parameter(2)
	public Gpio.Level pLvl;

	// @formatter:off
	@Parameters(name = "{index}: Gpio:{0}, Direction:{1}, Level: {2}")
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] {
		// datas[i], direction		  ,level variation in out directions
			{ 0, 	Gpio.Direction.IN, 	null}, 
			{ 0, 	Gpio.Direction.OUT, Gpio.Level.LOW},
			{ 0, 	Gpio.Direction.OUT, Gpio.Level.HIGH},
			{ 1, 	Gpio.Direction.IN, 	null}, 
			{ 1, 	Gpio.Direction.OUT, Gpio.Level.LOW},
			{ 1, 	Gpio.Direction.OUT, Gpio.Level.HIGH}
		});
	}
	// @formatter:on
	@Mock
	private ICommandWriter writer = Mockito.mock(ICommandWriter.class);

	@Mock
	private ICommandReader reader = Mockito.mock(ICommandReader.class);

	private Gpio _gpio;
	
	@Before
	public void setUp() throws Exception {
		// Setup powermockito for static GpioProvider mocking
		PowerMockito.mockStatic(GpioProvider.class);
		// Load test datas into GpioManager
		String resourceName = "TestInput.json";
		GpioManager.loadGpioMappingFromFile(resourceName);

		// Load test data locally
		Gson gson = new Gson();
		datas = gson.fromJson(new InputStreamReader(GpioManager.class.getClassLoader().getResourceAsStream(resourceName)), GpioProperties[].class);

		// Setup parameters for each test
		_gpio = new Gpio(datas[pGpio].port, pDir, writer, reader);
		_gpio.initializeGpio();
		PowerMockito.when(GpioProvider.getGpioInstance(datas[pGpio].port, pDir)).thenReturn(_gpio);

		GPIOVALUEPATH = GPIOFOLDER + "gpio" + String.valueOf(datas[pGpio].port) + "/value";
		GPIODIRECTIONPATH = GPIOFOLDER + "gpio" + String.valueOf(datas[pGpio].port) + "/direction";
		GPIOEDGEPATH = GPIOFOLDER + "gpio" + String.valueOf(datas[pGpio].port) + "/edge";
	}

	@Test
	public void testSetGpioAndWriter() throws IOException, GpioNotConfiguratedException {
		// Arranged in the setUp

		// Act
		GpioManager.setGpio(datas[pGpio].name, pDir);
		// Assert that the right gpio ctor have been called on _gpio

		Mockito.verify(writer).executeCommand(String.valueOf(datas[pGpio].port), GPIOFOLDER + "export");
		Mockito.verify(writer).executeCommand(pDir.toString().toLowerCase(), GPIODIRECTIONPATH);
		if (pDir == Gpio.Direction.IN) {
			Mockito.verify(writer).executeCommand("both", GPIOEDGEPATH);
		} else {
			Mockito.verify(writer).executeCommand("0", GPIOVALUEPATH);
		}
	}

	@Test
	public void testThatLevelIsLowWhenDirectionIsOut() throws IOException, GpioNotConfiguratedException {
		// Arranged in the setUp
		// Act
		Gpio g = GpioManager.setGpio(datas[pGpio].name, pDir);
		Gpio.Level initializedLevel = g.getLevel();
		// Assert
		if (pDir == Gpio.Direction.OUT) {
			Assertions.assertEquals(Gpio.Level.LOW, initializedLevel);
		} else {
			Assertions.assertEquals(null, initializedLevel);
		}
	}

	@Test
	public void testGpioLevelSettings() throws IOException, GpioNotConfiguratedException {
		if (pLvl == null)
			return;
		// Arranged
		String expectedLvl = pLvl == Gpio.Level.HIGH ? "1" : "0";
		// Act
		Gpio g = GpioManager.setGpio(datas[pGpio].name, pDir);
		g.setLevel(pLvl);
		Assertions.assertEquals(pLvl, g.getLevel());

		// Assert
		ArgumentCaptor<String> valueCaptor = ArgumentCaptor.forClass(String.class);
		ArgumentCaptor<String> targetFileCaptor = ArgumentCaptor.forClass(String.class);
		Mockito.verify(writer, Mockito.times(4)).executeCommand(valueCaptor.capture(), targetFileCaptor.capture());

		List<String> expected = new ArrayList<String>();
		expected.add(expectedLvl);
		expected.add(GPIOVALUEPATH);

		List<String> actual = new ArrayList<String>();
		actual.add(valueCaptor.getAllValues().get(valueCaptor.getAllValues().size() - 1));
		actual.add(targetFileCaptor.getAllValues().get(targetFileCaptor.getAllValues().size() - 1));

		Assertions.assertEquals(expected, actual);
	}

	@Test
	public void cleanupGpio() throws IOException, GpioNotConfiguratedException {
		GpioManager.setGpio(datas[pGpio].name, pDir);
		Assert.assertTrue(GpioManager.hasGpio(datas[pGpio].name));
		GpioManager.cleanup();
		Mockito.verify(writer).executeCommand(String.valueOf(datas[pGpio].port), GPIOFOLDER + "unexport");
	}

}
