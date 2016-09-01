package hu.bme.mit.inf.modes3.components.util

import hu.bme.mit.inf.modes3.components.util.jopt.ArgumentDescriptor
import hu.bme.mit.inf.modes3.components.util.jopt.ArgumentRegistry
import java.io.ByteArrayOutputStream
import java.util.function.Function
import java.util.stream.Collectors
import java.util.stream.Stream
import org.junit.Before
import org.junit.Test
import org.junit.experimental.theories.DataPoints
import org.junit.experimental.theories.Theories
import org.junit.experimental.theories.Theory
import org.junit.runner.RunWith

import static org.junit.Assert.*

@RunWith(Theories)
class ArgumentRegistryTest {

	var ArgumentRegistry registry

	@DataPoints
	public static var supportedParameterTypes = #[Integer, String]

	@Before
	def void init() {
		registry = new ArgumentRegistry
	}

	@Test
	def void registerFlagArgument() {
		// Arrange
		val descriptor = new ArgumentDescriptor("name", "description")

		// Act
		registry.registerArgumentWithoutOptions(descriptor)

		// Assert
		assertTrue(true)
	}

	@Theory
	def void registerArgumentWithParameter(Class<?> parameterType) {
		// Theory -> see http://junit.sourceforge.net/doc/ReleaseNotes4.4.html Theories section
		// Arrange
		val descriptor = new ArgumentDescriptor("name", "description", parameterType)

		// Act
		registry.registerArgumentWithOptions(descriptor)

		// Assert
		assertTrue(true)
	}

	@Test
	def void printArgumentHelp() {
		// Arrange
		val argumentOne = new ArgumentDescriptor("f", "sample argument without parameter")
		val argumentTwo = new ArgumentDescriptor("s", "sample argument with string parameter", String)
		val outputStream = new ByteArrayOutputStream
		val expectedLines = #["Option  Description", "------  -----------", "-f      sample argument without parameter",
			"-s      sample argument with string parameter"]

		// Act
		registry.registerArgumentWithoutOptions(argumentOne)
		registry.registerArgumentWithOptions(argumentTwo)
		try {
			registry.printHelp(outputStream)
		} finally {
			outputStream?.close
		}

		// Assert
		val outputString = outputStream?.toString("UTF-8")
		// verify each expected line is printed
		assertTrue(expectedLines.forall[line|outputString.contains(line)])

		// split output by new lines and trim each line
		val outputStringSplitByLine = (outputString.split("\\r?\\n").stream as Stream<String>).map(line|line.trim).
			collect(Collectors.toList)
		// verify each printed line is expected
		assertTrue(outputStringSplitByLine.forall[line|expectedLines.contains(line)])
	}

	@Test
	def void oneCharacterLongArgumentName() {
		// Arrange
		val oneCharacterArg = new ArgumentDescriptor("s", "one character long argument without parameter")
		val outputStream = new ByteArrayOutputStream
		val expectedLine = "-s      one character long argument without parameter"

		// Act
		registry.registerArgumentWithoutOptions(oneCharacterArg)
		try {
			registry.printHelp(outputStream)
		} finally {
			outputStream?.close
		}

		// Assert
		val outputString = outputStream?.toString("UTF-8")
		assertTrue(outputString.contains(expectedLine))
	}

	@Test
	def void moreThanOneCharacterLongArgumentName() {
		// Arrange
		val twoCharactersArg = new ArgumentDescriptor("tw", "two characters long argument without parameter")
		val outputStream = new ByteArrayOutputStream
		val expectedLine = "--tw    two characters long argument without parameter"

		// Act
		registry.registerArgumentWithoutOptions(twoCharactersArg)
		try {
			registry.printHelp(outputStream)
		} finally {
			outputStream?.close
		}

		// Assert
		val outputString = outputStream?.toString("UTF-8")
		assertTrue(outputString.contains(expectedLine))
	}

}
