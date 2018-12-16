package hu.bme.mit.inf.modes3.components.gpiomanager;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.modules.junit4.PowerMockRunnerDelegate;

import com.google.gson.Gson;

/**
 * GpioManager Unit tests: Checking the right calls from GpioManager to GpioProvider static class with PowerMockito - JUnit4
 * 
 * @author ecsedigergo
 *
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(GpioProvider.class)
@PowerMockRunnerDelegate(Parameterized.class)
public class GpioManagerTest {
	private class GpioProperties {
		public String name;
		public int port;
	}

	private GpioProperties[] datas;

	@Parameter(0) 
	public int pGpio;

	@Parameter(1)
	public Gpio.Direction pDir;

	// @formatter:off
	@Parameters(name = "{index}: Gpio: {0}, Direction: {1}")
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] {
		// datas[i], direction
			{ 0, 	Gpio.Direction.IN}, 
			{ 0, 	Gpio.Direction.OUT},
			{ 1, 	Gpio.Direction.IN}, 
			{ 1, 	Gpio.Direction.OUT}
		});
	}
	// @formatter:on
	@Mock
	private Gpio mGpio = Mockito.mock(Gpio.class);
	
	@Before
	public void initEnv() throws IOException {
		// Setup powermockito for static GpioProvider mocking
		PowerMockito.mockStatic(GpioProvider.class);
		// Load test datas into GpioManager
		String resourceName = "TestInput.json";
		GpioManager.loadGpioMappingFromFile(resourceName);

		// Load test data locally
		Gson gson = new Gson();
		datas = gson.fromJson(new InputStreamReader(GpioManager.class.getClassLoader().getResourceAsStream(resourceName)), GpioProperties[].class);

		PowerMockito.when(GpioProvider.getGpioInstance(datas[pGpio].port, pDir)).thenReturn(mGpio);
	}

	@Test
	public void testSetGpioCallingToProvider() throws Exception {
		// Arrange
		// Act
		GpioManager.setGpio(datas[pGpio].name, pDir);
		// Assert
		PowerMockito.verifyStatic(GpioProvider.class, Mockito.times(1));
		GpioProvider.getGpioInstance(datas[pGpio].port, pDir);
	}
	
	@Test
	public void testThatGpioIsNoPinFound() throws IOException, GpioNotConfiguratedException {
		// Act and Assert
		Assertions.assertThrows(GpioNotConfiguratedException.class, () -> {GpioManager.setGpio("99", pDir);});
	}

	@Test
	public void testSetGpioInternally() throws IOException, GpioNotConfiguratedException {
		// Arrange
		// Act
		Gpio g = GpioManager.setGpio(datas[pGpio].name, pDir);
		// Assert that it have put the right gpio
		Assert.assertSame(mGpio, g);
		// Assert that it is added internally in the GpioManager
		Assert.assertTrue(GpioManager.hasGpio(datas[pGpio].name));
	}

	@Test
	public void testGetGpioAfterSet() throws Exception {
		// Arrange
		// Act
		GpioManager.setGpio(datas[pGpio].name, pDir);
		Gpio g = GpioManager.getGpio(datas[pGpio].name, pDir);
		// Assert
		Assert.assertSame(mGpio, g);
	}
	
//	Cannot test Cleanup as a Unit, because cannot Mock gpio.cleanup for not calling writer.executemethod
//	Can be tested in GpioManager_Integration tests
//	@Test
//	public void cleanupGpio() throws IOException, GpioNotConfiguratedException {
//		// Arrange
//		PowerMockito.when(GpioProvider.getGpioInstance(datas[pGpio].port, pDir)).thenReturn(mGpio);
//		// TODO: Why not working, It still does writing...?
//		Mockito.doNothing().when(mGpio).cleanup();
//		GpioManager.setGpio(datas[0].name, pDir);
//		// Act
//		GpioManager.cleanup();
//		//Assert
//		Mockito.verify(mGpio, Mockito.times(datas.length)).cleanup();
//		//Mockito.verify(writer).executeCommand(String.valueOf(datas[0].port), "/sys/class/gpio/unexport");
//	}
}