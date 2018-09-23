package hu.bme.mit.inf.modes3.components.gpiomanager;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.jupiter.api.Test;

class GPIOTest {

	@Test
	public void testThatGpioSetToHighLevel() throws IOException, GpioNotConfiguratedException {
		// Arrange
		GpioManager.loadGpioMappingFromFile("TestInput.json");
		GpioManager.setGpioReader(new TestGpioReader());
		TestGpioWriter tgw = new TestGpioWriter();
		GpioManager.setGpioWriter(tgw);
		// act
		GpioManager.setGpio("P0", Gpio.Direction.IN);
		// assert
		assertAll("properties", () -> assertEquals("in", tgw.getInfos().get("direction")),
				() -> assertEquals("86", tgw.getInfos().get("export")),
				() -> assertEquals("both", tgw.getInfos().get("edge")));
	}

	@Test
	public void testThatGpioSetToLowLevel() throws IOException, GpioNotConfiguratedException {
		// Arrange
		GpioManager.loadGpioMappingFromFile("TestInput.json");
		GpioManager.setGpioReader(new TestGpioReader());
		TestGpioWriter tgw = new TestGpioWriter();
		GpioManager.setGpioWriter(tgw);
		// act
		GpioManager.setGpio("P1", Gpio.Direction.OUT);
		// assert
		assertAll("properties", () -> assertEquals("out", tgw.getInfos().get("direction")),
				() -> assertEquals("87", tgw.getInfos().get("export")),
				() -> assertEquals("0", tgw.getInfos().get("value")));
	}
	
	@Test
	public void testThatResourceFileNotFound() throws FileNotFoundException {
		// Arrange
		// GpioManager.loadGpioMappingFromFile("NOTEXISTING.json");
		//Throwable exception1 = assertThrows(FileNotFoundException.class, GpioManager.loadGpioMappingFromFile("NO"));

//		Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
//			throw new IllegalArgumentException("a message");
//		});
//		assertEquals("a message", exception.getMessage());
	}

}
