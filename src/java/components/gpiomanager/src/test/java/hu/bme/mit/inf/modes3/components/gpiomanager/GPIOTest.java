package hu.bme.mit.inf.modes3.components.gpiomanager;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import com.google.gson.Gson;

@TestInstance(Lifecycle.PER_CLASS)
class GPIOTest {
	private class GpioProperties {
		public String name;
		public int port;
	}

	private TestGpioWriter tgw;
	private GpioProperties[] datas;

	@BeforeAll
	private void initiateEnv() throws FileNotFoundException {
		// Arrange
		String resourceName = "TestInput.json";
		GpioManager.loadGpioMappingFromFile(resourceName);
		GpioManager.setGpioReader(new TestGpioReader());
		tgw = new TestGpioWriter();
		GpioManager.setGpioWriter(tgw);

		Gson gson = new Gson();
		datas = gson.fromJson(
				new InputStreamReader(GpioManager.class.getClassLoader().getResourceAsStream(resourceName)),
				GpioProperties[].class);
	}

	@Test
	public void testThatGpioSetToHighLevel() throws IOException, GpioNotConfiguratedException {
		// act
		GpioManager.setGpio("P0", Gpio.Direction.IN);

		// assert
		assertAll("properties", () -> assertEquals("in", tgw.getInfos().get("direction")),
				() -> assertEquals(datas[0].port, Integer.parseInt(tgw.getInfos().get("export")))
//				,() -> assertEquals("both", tgw.getInfos().get("edge"))
		);
	}

	@Test
	public void testThatGpioSetToLowLevel() throws IOException, GpioNotConfiguratedException {
		// act
		GpioManager.setGpio("P1", Gpio.Direction.OUT);

		// assert
		assertAll("properties", () -> assertEquals("out", tgw.getInfos().get("direction")),
				() -> assertEquals(datas[1].port, Integer.parseInt(tgw.getInfos().get("export"))),
				() -> assertEquals("0", tgw.getInfos().get("value")));
	}

//	@Test
//	public void testThatResourceFileNotFound() throws FileNotFoundException {
//		 Arrange
//		 GpioManager.loadGpioMappingFromFile("NOTEXISTING.json");
//		 Throwable exception1 = assertThrows(FileNotFoundException.class,
//		 GpioManager.loadGpioMappingFromFile("NO"));
//
//		Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
//			throw new IllegalArgumentException("a message");
//		});
//		assertEquals("a message", exception.getMessage());
//	}

}
