package hu.bme.mit.inf.modes3.components.util.jopt

import java.io.IOException
import java.io.OutputStream
import java.util.HashMap
import java.util.HashSet
import java.util.Map
import java.util.Set
import joptsimple.ArgumentAcceptingOptionSpec
import joptsimple.OptionException
import joptsimple.OptionParser
import joptsimple.OptionSet
import org.eclipse.xtend.lib.annotations.Accessors
import org.slf4j.ILoggerFactory
import org.slf4j.Logger

/**
 * A registry which stores the different command-line arguments, that can have
 * parameters {@link ArgumentAcceptingOptionSpec} or not.
 * 
 * Beware, that after registering the arguments, the String[] args array should
 * be parsed by
 * {@link hu.bme.mit.inf.mqtt.common.parameters.ArgumentRegistrar#parseArguments(String[])}.
 * 
 * A registered argument's value can be get by the
 * {@link hu.bme.mit.inf.mqtt.common.parameters.ArgumentRegistrar#getParameterStringValue(String)}
 * and
 * {@link hu.bme.mit.inf.mqtt.common.parameters.ArgumentRegistrar#getParameterIntegerValue(String)}
 * methods.
 * 
 * The presence of mandatory arguments can be checked by
 * {@link hu.bme.mit.inf.mqtt.common.parameters.ArgumentRegistrar#hasMandatoryArguments(Set<String>)}.
 * 
 * @author benedekh
 */
public class ArgumentRegistry {

	@Accessors(PROTECTED_GETTER, PRIVATE_SETTER) val Logger logger

	// stores the registered arguments with optons (key: name, value: argumentObj)
	@Accessors(PROTECTED_GETTER, PROTECTED_SETTER) val Map<String, ArgumentAcceptingOptionSpec<?>> registrar = new HashMap

	// stored registered arguments without options
	@Accessors(PROTECTED_GETTER, PROTECTED_SETTER) val Set<String> registrarNoOptions = new HashSet

	// the arguments are registered here
	@Accessors(PROTECTED_GETTER, PROTECTED_SETTER) val OptionParser parser = new OptionParser

	// parsed arguments
	@Accessors(PROTECTED_GETTER, PROTECTED_SETTER) var OptionSet parsed

	new(ILoggerFactory factory) {
		this.logger = factory.getLogger(this.class.name)
	}

	/**
	 * Registers a new argument with options, that means the argument accepts
	 * parameters.
	 * 
	 * @param descriptor the descriptor of the argument to be registered
	 */
	def void registerArgumentWithOptions(ArgumentDescriptorWithParameter<?> descriptor) {
		val name = descriptor.name
		val ArgumentAcceptingOptionSpec<?> argument = parser.accepts(name, descriptor.description).withRequiredArg.ofType(descriptor.type)
		registrar.put(name, argument)
	}

	/**
	 * Registers a new argument without options, that means the argument does
	 * not accept any parameters.
	 * 
	 * @param descriptor the descriptor of the argument to be registered
	 */
	def void registerArgumentWithoutOptions(ArgumentDescriptorWithoutParameter descriptor) {
		parser.accepts(descriptor.name, descriptor.getDescription)
		registrarNoOptions.add(descriptor.name)
	}

	/**
	 * Prints the argument's names, descriptions, and their accepting parameters
	 * on the target stream.
	 * 
	 * @param target on which the descriptions of the arguments will be printed
	 */
	def void printHelp(OutputStream target) {
		try {
			parser.printHelpOn(target)
		} catch(IOException ex) {
			logger.error(ex.message, ex)
		}
	}

	/**
	 * Parses the array of arguments.
	 * 
	 * @param args which contains the arguments
	 */
	def void parseArguments(String[] args) {
		parsed = parser.parse(args)
	}

	/**
	 * Check whether the parsed argument set contains the required arguments.
	 * 
	 * @param arguments that must be present in the parsed argument set
	 * @return true, if all the arguments are present, false otherwise
	 */
	def hasMandatoryArguments(Set<String> arguments) {
		arguments.forall[x|parsed.has(x)]
	}

	/**
	 * Tells the argument's (referred by its name) parameter value as a String,
	 * if the argument's parameter is a String. Otherwise throws an Exception,
	 * or if the argument is not present, then returns null.
	 * 
	 * @param name the argument's name whose parameter shall be returned
	 * @return the argument's parameter as a string if present, or null if not
	 * present
	 * @throws IOException if the argument's parameter cannot be converted to a
	 * String
	 */
	def getParameterStringValue(String name) throws IOException {
		val ArgumentAcceptingOptionSpec<?> argument = registrar.get(name)

		if(parsed.has(argument)) {
			try {
				val ArgumentAcceptingOptionSpec<String> castedArgument = getAs(argument)
				return parsed.valueOf(castedArgument).trim
			} catch(OptionException ex) {
				throw new ClassCastException(ex.message)
			} catch(ClassCastException ex) {
				throw new IllegalArgumentException("Please use a string for the " + name + " argument's parameter value.")
			}
		}
	}

	/**
	 * Tells the argument's (referred by its name) parameter value as an
	 * Integer, if the argument's parameter is an Integer. Otherwise throws an
	 * Exception, or if the argument is not present, then returns null.
	 * 
	 * @param name the argument's name whose parameter shall be returned
	 * @return the argument's parameter as an integer if present, or null if not
	 * present
	 * @throws IOException if the argument's parameter cannot be converted to an
	 * Integer
	 */
	def getParameterIntegerValue(String name) throws IOException {
		val ArgumentAcceptingOptionSpec<?> argument = registrar.get(name)

		if(parsed.has(argument)) {
			try {
				val ArgumentAcceptingOptionSpec<Integer> castedArgument = getAs(argument)
				return parsed.valueOf(castedArgument)
			} catch(OptionException ex) {
				throw new ClassCastException(ex.message)
			} catch(ClassCastException ex) {
				throw new IllegalArgumentException("Please use an integer for the " + name + " argument's parameter value.")
			}
		}
	}

	/**
	 * Converts the referred object to a T type object.
	 * 
	 * @param <T> the target type
	 * @param argument the object to be converted
	 * @return the referred object converted to a T type object.
	 */
	private def <T> ArgumentAcceptingOptionSpec<T> getAs(ArgumentAcceptingOptionSpec<?> argument) throws ClassCastException {
		(argument as Object) as ArgumentAcceptingOptionSpec<T>
	}
}
