package hu.bme.mit.inf.modes3.components.gpiomanager;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.google.gson.Gson;

@RunWith(PowerMockRunner.class)
@PrepareForTest(GpioProvider.class)
public class GpioScenariosTest {
	private class GpioProperties {
		public String name;
		public int port;
	}

	private static final String GPIOFOLDER = "/sys/class/gpio/";
	private GpioProperties[] datas;

	@Mock
	private GpioWriter writer = Mockito.mock(GpioWriter.class);

	@Mock
	private GpioReader reader = Mockito.mock(GpioReader.class);

	private Gpio _gpio;

	@Before
	public void setUp() throws Exception {
		// Setup powermockito for static GpioProvider mocking
		PowerMockito.mockStatic(GpioProvider.class);
		// Load test datas into GpioManager
		String resourceName = "beaglebone.json";
		GpioManager.loadGpioMappingFromFile(resourceName);

		// Load test data locally
		Gson gson = new Gson();
		datas = gson.fromJson(new InputStreamReader(GpioManager.class.getClassLoader().getResourceAsStream(resourceName)), GpioProperties[].class);

		// Setup parameters for each test
		for (GpioProperties pGpio : datas) {
			_gpio = new Gpio(pGpio.port, Gpio.Direction.OUT, writer, reader);
			_gpio.initializeGpio();
			PowerMockito.when(GpioProvider.getGpioInstance(pGpio.port, Gpio.Direction.OUT)).thenReturn(_gpio);
		}
		
	}

	@Test
	public void checkSegmentActuator() throws Exception {
		// running test with P0-G0 and P1-G1
		ArrayList<Gpio> gpios = new ArrayList<>();
		gpios.add(GpioManager.setGpio("P6", Gpio.Direction.OUT));
		gpios.add(GpioManager.setGpio("P7", Gpio.Direction.OUT));
		gpios.add(GpioManager.setGpio("G6", Gpio.Direction.OUT));
		gpios.add(GpioManager.setGpio("G7", Gpio.Direction.OUT));

		// test will be the following: every 500s one gpio set to high, and then the set to low
		for (Gpio g : gpios) {
			g.setLevel(Gpio.Level.HIGH);
			Thread.sleep(500);
			Assertions.assertEquals(Gpio.Level.HIGH, g.getLevel());
		}

		for (Gpio g : gpios) {
			g.setLevel(Gpio.Level.LOW);
			Thread.sleep(500);
			Assertions.assertEquals(Gpio.Level.LOW, g.getLevel());
		}
	}
	
	@Test
	public void checkSegmentActuator2() throws Exception {
		// running test with P6-G6 and P7-G7
		ArrayList<Gpio> gpios = new ArrayList<>();
		gpios.add(GpioManager.setGpio("P6", Gpio.Direction.OUT));
		gpios.add(GpioManager.setGpio("G6", Gpio.Direction.OUT));

		int impulseWidth = 4000;
		for (Gpio g : gpios) {
			g.impulse(impulseWidth, true);
			impulseWidth -= 500;
		}
		
		Mockito.verify(writer, Mockito.times(1)).executeCommand("86", GPIOFOLDER + "export");
		
		Mockito.verify(writer, Mockito.times(1)).executeCommand("0", GPIOFOLDER + "gpio" + String.valueOf(86) + "/value");
		Mockito.verify(writer, Mockito.times(1)).executeCommand("0", GPIOFOLDER + "gpio" + String.valueOf(87) + "/value");
		
		Thread.sleep(5000);
		
		Mockito.verify(writer, Mockito.times(1)).executeCommand("0", GPIOFOLDER + "gpio" + String.valueOf(86) + "/value");
		Mockito.verify(writer, Mockito.times(1)).executeCommand("0", GPIOFOLDER + "gpio" + String.valueOf(87) + "/value");
	}
	
	@Test
	public void testInputChangeListener() throws IOException {
		
	}
}
