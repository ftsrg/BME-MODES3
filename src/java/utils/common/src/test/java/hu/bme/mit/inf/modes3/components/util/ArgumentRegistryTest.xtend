package hu.bme.mit.inf.modes3.components.util

import hu.bme.mit.inf.modes3.utils.common.jopt.ArgumentDescriptorWithParameter
import hu.bme.mit.inf.modes3.utils.common.jopt.ArgumentDescriptorWithoutParameter
import hu.bme.mit.inf.modes3.utils.common.jopt.ArgumentRegistry
import java.io.ByteArrayOutputStream
import java.util.Arrays
import java.util.HashSet
import joptsimple.OptionException
import org.junit.Before
import org.junit.Test
import org.junit.experimental.theories.DataPoints
import org.junit.experimental.theories.Theories
import org.junit.experimental.theories.Theory
import org.junit.runner.RunWith
import org.slf4j.helpers.NOPLoggerFactory

import static org.junit.Assert.*

/**
 * Test class of {@link ArgumentRegistry}.
 * 
 * @author benedekh
 */
@RunWith(Theories)
class ArgumentRegistryTest {

	var ArgumentRegistry registry

	@DataPoints
	public static var supportedParameterTypes = #[Integer, String]

	/**
	 * Recreate the {@link ArgumentRegistry} before each test.
	 */
	@Before def void init() {
		registry = new ArgumentRegistry(new NOPLoggerFactory)
	}

	/**
	 * Register an argument without options. 
	 */
	@Test def void registerFlagArgument() {
		// Arrange
		val descriptor = new ArgumentDescriptorWithoutParameter("name", "description")

		// Act
		registry.registerArgumentWithoutOptions(descriptor)

		// Assert
		assertTrue(true)
	}

	/**
	 * Register an argument with an option.
	 */
	@Theory def void registerArgumentWithParameter(Class<?> parameterType) {
		// Theory -> see http://junit.sourceforge.net/doc/ReleaseNotes4.4.html Theories section
		// Arrange
		val descriptor = new ArgumentDescriptorWithParameter("name", "description", parameterType)

		// Act
		registry.registerArgumentWithOptions(descriptor)

		// Assert
		assertTrue(true)
	}

	/**
	 *  Print the help of the argument registry.
	 */
	@Test def void printArgumentHelp() {
		// Arrange
		val argumentOne = new ArgumentDescriptorWithoutParameter("f", "sample argument without parameter")
		val argumentTwo = new ArgumentDescriptorWithParameter("s", "sample argument with string parameter", String)
		val outputStream = new ByteArrayOutputStream
		val expectedLines = #["Option  Description", "------  -----------", "-f      sample argument without parameter", "-s      sample argument with string parameter"]

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
		val outputStringSplitByLine = outputString.split("\\r?\\n").map[it.trim]
		// verify each printed line is expected
		assertTrue(outputStringSplitByLine.forall[expectedLines.contains(it)])
	}

	/**
	 * Register an argument with a one-character-long shorthand.
	 */
	@Test def void oneCharacterLongArgumentName() {
		// Arrange
		val oneCharacterArg = new ArgumentDescriptorWithoutParameter("s", "one character long argument without parameter")
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

	/**
	 * Register an argument with a two-character-long shorthand.
	 */
	@Test def void moreThanOneCharacterLongArgumentName() {
		// Arrange
		val twoCharactersArg = new ArgumentDescriptorWithoutParameter("tw", "two characters long argument without parameter")
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

	/**
	 * Parses the String[] array that contains the arguments which were set by the user.
	 */
	@Test def void parseArgumentsTest() {
		// Arrange
		val firstArgument = new ArgumentDescriptorWithParameter("f", "first argument with one parameter", String)
		val secondArgument = new ArgumentDescriptorWithoutParameter("se", "second argument without parameter")
		val argumentsSetByCommandLine = #["-f", "firstParam", "--se"]

		// Act
		registry.registerArgumentWithOptions(firstArgument)
		registry.registerArgumentWithoutOptions(secondArgument)
		registry.parseArguments(argumentsSetByCommandLine)

		// Assert
		assertTrue(true)
	}

	/**
	 * Invoke the argument registry with an unregistered argument.
	 */
	@Test(expected=OptionException) 
	def void parseArgumentsWithUnexpectedArgumentTest() {
		// Arrange
		// contains an unexpected argument, because no argument is registered in the registry
		val argumentsSetByCommandLine = #["-u"]

		// Act
		registry.parseArguments(argumentsSetByCommandLine)
	}

	/**
	 * Invoke the argument registry without setting a mandatory parameter.
	 */
	@Test(expected=OptionException) 
	def void parseArgumentsArgumentMissingParameter() {
		// Arrange
		val argument = new ArgumentDescriptorWithParameter("a", "argument with parameter", String)
		val argumentsSetByCommandLine = #["-a"]

		// Act
		registry.registerArgumentWithOptions(argument)
		registry.parseArguments(argumentsSetByCommandLine)
	}

	/**
	 * Verify that all the mandatory parameters are set by the user.
	 */
	@Test def void requiredArgumentsAreSetByUser() {
		// Arrange
		val firstArgument = new ArgumentDescriptorWithParameter("f", "first argument with one parameter", String)
		val secondArgument = new ArgumentDescriptorWithoutParameter("se", "second argument without parameter")
		val mandatoryArguments = new HashSet<String>(Arrays.asList("f", "se"))
		val argumentsSetByCommandLine = #["-f", "firstParam", "--se"]

		// Act
		registry.registerArgumentWithOptions(firstArgument)
		registry.registerArgumentWithoutOptions(secondArgument)
		registry.parseArguments(argumentsSetByCommandLine)
		val requiredArgumentsAreSetByTheUser = registry.hasMandatoryArguments(mandatoryArguments)

		// Assert
		assertTrue(requiredArgumentsAreSetByTheUser)
	}

	/**
	 * Invoke the argument registry without setting a mandatory parameter.
	 */
	@Test def void noMandatoryArgumentIsSetByUser() {
		// Arrange
		val firstArgument = new ArgumentDescriptorWithParameter("m", "mandatory argument with one parameter", String)
		val mandatoryArgument = new HashSet<String>(Arrays.asList("m"))
		val argumentsSetByCommandLine = #[]

		// Act
		registry.registerArgumentWithOptions(firstArgument)
		registry.parseArguments(argumentsSetByCommandLine)
		val requiredArgumentsAreSetByTheUser = registry.hasMandatoryArguments(mandatoryArgument)

		// Assert
		assertFalse(requiredArgumentsAreSetByTheUser)
	}

	/**
	 * Invoke the argument registry without setting a mandatory parameter.
	 */
	@Test def void mandatoryArgumentIsNotSetByUser() {
		// Arrange
		val firstArgument = new ArgumentDescriptorWithParameter("f", "first argument with one parameter", String)
		val secondArgument = new ArgumentDescriptorWithoutParameter("se", "second argument without parameter")
		val mandatoryArguments = new HashSet<String>(Arrays.asList("f", "se"))
		val argumentsSetByCommandLine = #["-f", "firstParam"]

		// Act
		registry.registerArgumentWithOptions(firstArgument)
		registry.registerArgumentWithoutOptions(secondArgument)
		registry.parseArguments(argumentsSetByCommandLine)
		val requiredArgumentsAreSetByTheUser = registry.hasMandatoryArguments(mandatoryArguments)

		// Assert
		assertFalse(requiredArgumentsAreSetByTheUser)
	}

	/**
	 * Get the value of a String parameter.
	 */
	@Test def void getStringArgumentParameterValue() {
		// Arrange
		val argumentName = "a"
		val argument = new ArgumentDescriptorWithParameter(argumentName, "argument with string parameter", String)
		val expectedParameterValue = "helloworld"
		val argumentSetByCommandLine = #["-" + argumentName, expectedParameterValue]

		// Act
		registry.registerArgumentWithOptions(argument)
		registry.parseArguments(argumentSetByCommandLine)
		val parameterValue = registry.getParameterStringValue(argumentName)

		// Assert
		assertEquals(expectedParameterValue, parameterValue)
	}

	/**
	 * Get the value of an Integer parameter.
	 */
	@Test def void getIntegerArgumentParameterValue() {
		// Arrange
		val argumentName = "a"
		val argument = new ArgumentDescriptorWithParameter(argumentName, "argument with integer parameter", Integer)
		val expectedParameterValue = "42"
		val argumentSetByCommandLine = #["-" + argumentName, expectedParameterValue]

		// Act
		registry.registerArgumentWithOptions(argument)
		registry.parseArguments(argumentSetByCommandLine)
		val parameterValue = registry.getParameterIntegerValue(argumentName)

		// Assert
		assertEquals(Integer.valueOf(expectedParameterValue), parameterValue)
	}

	/**
	 * Try to get an Integer parameter as String.
	 */
	@Test(expected=IllegalArgumentException)
	def void getIntegerParameterAsString() {
		// Arrange
		val argumentName = "a"
		val argument = new ArgumentDescriptorWithParameter(argumentName, "argument with integer parameter", Integer)
		val expectedParameterValue = "42"
		val argumentSetByCommandLine = #["-" + argumentName, expectedParameterValue]

		// Act
		registry.registerArgumentWithOptions(argument)
		registry.parseArguments(argumentSetByCommandLine)
		registry.getParameterStringValue(argumentName)
	}
	
	/**
	 * Try to get a String parameter as Integer.
	 */
	@Test(expected=IllegalArgumentException)
	def void getStringParameterAsInteger() {
		// Arrange
		val argumentName = "a"
		val argument = new ArgumentDescriptorWithParameter(argumentName, "argument with string parameter", String)
		val expectedParameterValue = "helloworld"
		val argumentSetByCommandLine = #["-" + argumentName, expectedParameterValue]

		// Act
		registry.registerArgumentWithOptions(argument)
		registry.parseArguments(argumentSetByCommandLine)
		registry.getParameterIntegerValue(argumentName)
	}

}
