package hu.bme.mit.inf.mqtt.common.parameters;

import static hu.bme.mit.inf.mqtt.common.util.logging.LogManager.logException;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import joptsimple.ArgumentAcceptingOptionSpec;
import joptsimple.OptionException;
import joptsimple.OptionParser;
import joptsimple.OptionSet;

/**
 * A registrar which stores the different command-line arguments, that can have
 * parameters {@link joptsimple.ArgumentAcceptingOptionSpec} or not.
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
public class ArgumentRegistrar {

    // stores the registered arguments with optons (key: name, value: argumentObj)
    protected Map<String, ArgumentAcceptingOptionSpec<?>> registrar = new HashMap<>();

    // stored registered arguments without options
    protected Set<String> registrarNoOptions = new HashSet<>();

    // the arguments are registered here
    protected OptionParser parser = new OptionParser();

    // parsed arguments
    protected OptionSet parsed;

    /**
     * Registers a new argument with options, that means the argument accepts
     * parameters.
     *
     * @param descriptor the descriptor of the argument to be registered
     */
    public void registerArgumentWithOptions(ArgumentDescriptor descriptor) {
        String name = descriptor.getName();

        ArgumentAcceptingOptionSpec<?> argument
                = parser.accepts(name,
                        descriptor.getDescription())
                .withRequiredArg().ofType(descriptor.getType());

        registrar.put(name, argument);
    }

    /**
     * Registers a new argument without options, that means the argument does
     * not accept any parameters.
     *
     * @param descriptor the descriptor of the argument to be registered
     */
    public void registerArgumentWithoutOptions(ArgumentDescriptor descriptor) {
        parser.accepts(descriptor.getName(), descriptor.getDescription());
        registrarNoOptions.add(descriptor.getName());
    }

    /**
     * Prints the argument's names, descriptions, and their accepting parameters
     * on the target stream.
     *
     * @param target on which the descriptions of the arguments will be printed
     */
    public void printHelp(OutputStream target) {
        try {
            parser.printHelpOn(target);
        } catch (IOException ex) {
            logException(getClass().getName(), ex);
        }
    }

    /**
     * Parses the array of arguments.
     *
     * @param args which contains the arguments
     */
    public void parseArguments(String[] args) {
        parsed = parser.parse(args);
    }

    /**
     * Check whether the parsed argument set contains the required arguments.
     *
     * @param arguments that must be present in the parsed argument set
     * @return true, if all the arguments are present, false otherwise
     */
    public boolean hasMandatoryArguments(Set<String> arguments) {
        for (String argument : arguments) {
            if (!parsed.has(argument)) {
                return false;
            }
        }
        return true;
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
    public String getParameterStringValue(String name) throws IOException {
        ArgumentAcceptingOptionSpec<?> argument = registrar.get(
                name);

        if (parsed.has(argument)) {
            try {
                ArgumentAcceptingOptionSpec<String> castedArgument = getAs(
                        argument);
                return parsed.valueOf(castedArgument);
            } catch (OptionException | ClassCastException ex) {
                throw new IOException(
                        "Please use a string for the " + name + " parameter.");
            }
        }
        return null;
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
    public Integer getParameterIntegerValue(String name) throws IOException {
        ArgumentAcceptingOptionSpec<?> argument = registrar.get(
                name);

        if (parsed.has(argument)) {
            try {
                ArgumentAcceptingOptionSpec<Integer> castedArgument = getAs(
                        argument);
                return parsed.valueOf(castedArgument);
            } catch (OptionException | ClassCastException ex) {
                throw new IOException(
                        "Please use an integer for the " + name + " parameter.");
            }
        }
        return null;
    }

    /**
     * Converts the referred object to a T type object.
     *
     * @param <T> the target type
     * @param argument the object to be converted
     * @return the referred object converted to a T type object.
     * @throws ClassCastException if the conversion cannot be done
     */
    private <T> ArgumentAcceptingOptionSpec<T> getAs(
            ArgumentAcceptingOptionSpec<?> argument) throws ClassCastException {
        return (ArgumentAcceptingOptionSpec<T>) (Object) argument;
    }
}
