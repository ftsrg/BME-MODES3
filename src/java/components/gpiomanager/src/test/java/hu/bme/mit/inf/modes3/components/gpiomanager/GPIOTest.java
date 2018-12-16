package hu.bme.mit.inf.modes3.components.gpiomanager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
//import org.mockito.junit.jupiter.MockitoExtension;

/**
 * Gpio UnitTests: Checking that the functions will call with the right values to the GpioWriter and GpioReader
 * 
 * @author ecsedigergo
 *
 */

@DisplayName("Tests for GPIO API")
//@ExtendWith(MockitoExtension.class)
public class GpioTest {
	private static final String GPIOFOLDER = "/sys/class/gpio/";
	private static final int DEFAULTPIN = 1;
	private static final Gpio.Direction DEFAULTDIRECTION = Gpio.Direction.OUT;

	@Mock
	private ICommandWriter writer = Mockito.mock(ICommandWriter.class);

	@Mock
	private ICommandReader reader = Mockito.mock(ICommandReader.class);

	@Mock
	private Gpio.InputStateListener listener = Mockito.mock(Gpio.InputStateListener.class);

	private Gpio _gpio;
	
	@BeforeEach
	public void createGpio() throws IOException {
		_gpio = new Gpio(DEFAULTPIN, DEFAULTDIRECTION, writer, reader);
		// skip the init, does a lot of writing and not neccessary now
		// _gpio.initializeGpio();
	}

	@Test
	public void testReadingForFirst() throws IOException, InterruptedException {
		// Arrange
		Mockito.when(reader.getGpioValue(GPIOFOLDER + "gpio" + DEFAULTPIN + "/value")).thenReturn(Gpio.Level.LOW);
		Gpio localGpio = new Gpio(DEFAULTPIN, Gpio.Direction.IN, writer, reader);
		localGpio.initializeGpio();
		// Act
		Thread.sleep(80); // Because refresh frequency is 50msec and we check that before the 2.
		// Assert
		Mockito.verify(reader, Mockito.times(2)).getGpioValue(GPIOFOLDER + "gpio" + DEFAULTPIN + "/value");
	}

	// @formatter:off
	public static Stream<Arguments> readerLvlAndPathProvider() {
		return Stream.of(
				//			     direction,		start level 		,expectedPath
				Arguments.of(Gpio.Direction.IN, Gpio.Level.LOW, 	GPIOFOLDER + "gpio" + DEFAULTPIN + "/value"), 
				Arguments.of(Gpio.Direction.IN, Gpio.Level.HIGH, 	GPIOFOLDER + "gpio" + DEFAULTPIN + "/value")
		);
	}
	// @formatter:on

	@ParameterizedTest
	@MethodSource("readerLvlAndPathProvider")
	public void testInputStateChangedEventFired(Gpio.Direction dir, Gpio.Level startLvl, String expectedPath) throws IOException, InterruptedException {
		// Arrange
		Gpio.Level invertedLvl = startLvl == Gpio.Level.LOW ? Gpio.Level.HIGH : Gpio.Level.LOW;
		Mockito.when(reader.getGpioValue(expectedPath)).thenReturn(startLvl).thenReturn(startLvl).thenReturn(invertedLvl).thenReturn(invertedLvl);

		Gpio localGpio = new Gpio(DEFAULTPIN, dir, writer, reader);
		localGpio.initializeGpio();
		localGpio.addInputStateListener(listener);
		// Act
		Thread.sleep(4 * 50 - 25);
		// Assert
		Mockito.verify(reader, Mockito.times(4)).getGpioValue(expectedPath);
		Mockito.verify(listener, Mockito.times(1)).levelStateChanged(startLvl);
		Mockito.verify(listener, Mockito.times(1)).levelStateChanged(invertedLvl);
	}

	// @formatter:off
	public static Stream<Arguments> pinAndDirectionAndLevelProvider() {
		return Stream.of(
				//			pin,     direction,			level properties
				Arguments.of(1, Gpio.Direction.IN, new String[] { "both", "/edge" }), 
				Arguments.of(21, Gpio.Direction.IN, new String[] { "both", "/edge" }), 
				Arguments.of(100, Gpio.Direction.IN, new String[] { "both", "/edge" }),

				Arguments.of(9, Gpio.Direction.OUT, new String[] { "0", "/value" }), 
				Arguments.of(77, Gpio.Direction.OUT, new String[] { "0", "/value" }),
				Arguments.of(117, Gpio.Direction.OUT, new String[] { "0", "/value" })
		);
	}
	// @formatter:on

	@ParameterizedTest
	@MethodSource("pinAndDirectionAndLevelProvider")
	public void testGpioCtorWithInit(int pin, Gpio.Direction direction, String[] levelProps) throws IOException {
		// Act
		Gpio localGpio = new Gpio(pin, direction, writer, reader);
		localGpio.initializeGpio();
		// Assert
		Mockito.verify(writer).executeCommand(String.valueOf(pin), GPIOFOLDER + "export");
		Mockito.verify(writer).executeCommand(direction.toString().toLowerCase(), GPIOFOLDER + "gpio" + String.valueOf(pin) + "/direction");
		Mockito.verify(writer).executeCommand(levelProps[0], GPIOFOLDER + "gpio" + String.valueOf(pin) + levelProps[1]);
	}

	// @formatter:off
	public static Stream<Arguments> levelAndValueProvider() {
		String valuePath = GPIOFOLDER + "gpio" + String.valueOf(DEFAULTPIN) + "/value";
		return Stream.of(
				//Default direction is OUT, so we only take care of setting the levels
				//				Level, 			expectedValue,  expectedPath
				Arguments.of(Gpio.Level.HIGH,	"1", 			valuePath),
				Arguments.of(Gpio.Level.LOW, 	"0", 			valuePath)
		);
	}
	// @formatter:on

	@ParameterizedTest
	@MethodSource("levelAndValueProvider")
	public void testGpioLevelSetting(Gpio.Level level, String expectedValue, String expectedPath) throws IOException {
		// Act
		_gpio.setLevel(level);
		// Assert
		Mockito.verify(writer).executeCommand(expectedValue, expectedPath);
	}

	// @formatter:off
	public static Stream<Arguments> levelAndValueWithInvProvider() {
		String valuePath = GPIOFOLDER + "gpio" + String.valueOf(DEFAULTPIN) + "/value";
		return Stream.of(
				//Default direction is OUT, so we only take care of setting the levels
				//				Level, 			expectedValue,  invertedValue,	expectedPath
				Arguments.of(Gpio.Level.HIGH,	"1", 			"0",			valuePath),
				Arguments.of(Gpio.Level.LOW, 	"0", 			"1",			valuePath)
		);
	}
	// @formatter:on

	@ParameterizedTest
	@MethodSource("levelAndValueWithInvProvider")
	public void testGpioLevelInverting(Gpio.Level level, String expectedValue, String invertedValue, String expectedPath) throws IOException {
		// Arrange
		_gpio.setLevel(level);
		Mockito.verify(writer).executeCommand(expectedValue, expectedPath);
		// Act
		_gpio.invertLevel();
		// Assert
		Mockito.verify(writer).executeCommand(invertedValue, expectedPath);
		Mockito.verify(writer).executeCommand(expectedValue, expectedPath);
	}

	// @formatter:off
	public static Stream<Arguments> impulseProvider() {
		String outputPath = GPIOFOLDER + "gpio" + String.valueOf(DEFAULTPIN) + "/value";
		return Stream.of(
				//			ms,		level,		isblocked,  expectedValue, expectedPath
				Arguments.of(1,  Gpio.Level.HIGH, true,		"1",		outputPath),
				Arguments.of(1,  Gpio.Level.HIGH, false,	"1",		outputPath),
				Arguments.of(1,  Gpio.Level.LOW, true,		"0",		outputPath), 
				Arguments.of(1,  Gpio.Level.LOW, false, 	"0",		outputPath),
				Arguments.of(10, Gpio.Level.HIGH, true, 	"1",		outputPath),
				Arguments.of(10, Gpio.Level.HIGH, false, 	"1",		outputPath),
				Arguments.of(10, Gpio.Level.LOW, true, 		"0",		outputPath), 
				Arguments.of(10, Gpio.Level.LOW, false, 	"0",		outputPath)
			);
	}
	// @formatter:on

	@ParameterizedTest
	@MethodSource("impulseProvider")
	public void testImpulse(int impulseFreq, Gpio.Level level, boolean blocked, String expectedValue, String expectedPath) throws InterruptedException, IOException {
		// setupGpioInstance(pin, dir);

		_gpio.setLevel(level);
		_gpio.impulse(impulseFreq, blocked);

		Thread.sleep(50); // Wait for the full impulse cycle

		String invertedValue = expectedValue == "1" ? "0" : "1";
		// Assert
//		Expected values, but we what that in that exact order		
//		Mockito.verify(writer).executeCommand(expectedValue, expectedPath);
//		Mockito.verify(writer).executeCommand(invertedValue, expectedPath);
//		Mockito.verify(writer).executeCommand(expectedValue, expectedPath);

		// Assert
		ArgumentCaptor<String> valueCaptor = ArgumentCaptor.forClass(String.class);
		ArgumentCaptor<String> targetFileCaptor = ArgumentCaptor.forClass(String.class);
		Mockito.verify(writer, Mockito.times(3)).executeCommand(valueCaptor.capture(), targetFileCaptor.capture());

		List<String> expected = new ArrayList<String>();
		expected.add(expectedValue);
		expected.add(expectedPath);

		expected.add(invertedValue);
		expected.add(expectedPath);

		expected.add(expectedValue);
		expected.add(expectedPath);

		List<String> actual = new ArrayList<String>();
		for (int i = 0; i < valueCaptor.getAllValues().size(); i++) {
			actual.add(valueCaptor.getAllValues().get(i));
			actual.add(targetFileCaptor.getAllValues().get(i));
		}

		Assertions.assertEquals(expected, actual);
	}

	// @formatter:off
	public static Stream<Arguments> pinAndDirectionProvider() {
		return Stream.of(				
				Arguments.of(1, Gpio.Direction.IN), 
				Arguments.of(21, Gpio.Direction.IN), 
				Arguments.of(100, Gpio.Direction.IN),
	
				Arguments.of(9, Gpio.Direction.OUT), 
				Arguments.of(77, Gpio.Direction.OUT),
				Arguments.of(117, Gpio.Direction.OUT)
		);
	}
	// @formatter:on

	@ParameterizedTest
	@MethodSource("pinAndDirectionProvider")
	public void testGpioClean(int pin, Gpio.Direction direction) throws IOException, InterruptedException {
		Gpio localGpio = new Gpio(pin, direction, writer, reader);
		localGpio.cleanup();
		Mockito.verify(writer).executeCommand(String.valueOf(pin), GPIOFOLDER + "unexport");
	}
}