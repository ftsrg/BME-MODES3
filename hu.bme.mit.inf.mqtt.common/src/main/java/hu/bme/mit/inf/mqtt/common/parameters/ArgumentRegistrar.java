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

    public void registerArgumentWithOptions(ArgumentDescriptor descriptor) {
        String name = descriptor.getName();

        ArgumentAcceptingOptionSpec<?> argument
                = parser.accepts(name,
                        descriptor.getDescription())
                .withRequiredArg().ofType(descriptor.getType());

        registrar.put(name, argument);
    }

    public void registerArgumentWithoutOptions(ArgumentDescriptor descriptor) {
        parser.accepts(descriptor.getName(), descriptor.getDescription());
        registrarNoOptions.add(descriptor.getName());
    }

    public void printHelp(OutputStream target) {
        try {
            parser.printHelpOn(target);
        } catch (IOException ex) {
            logException(getClass().getName(), ex);
        }
    }

    public void parseArguments(String[] args) {
        parsed = parser.parse(args);
    }

    public boolean hasMandatoryArguments(Set<String> arguments) {
        for (String argument : arguments) {
            if (!parsed.has(argument)) {
                return false;
            }
        }
        return true;
    }

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

    private <T> ArgumentAcceptingOptionSpec<T> getAs(
            ArgumentAcceptingOptionSpec<?> argument) throws ClassCastException {
        return (ArgumentAcceptingOptionSpec<T>) (Object) argument;
    }
}
