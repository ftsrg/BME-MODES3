package hu.bme.mit.inf.modes3.components.util.jopt

import org.eclipse.xtend.lib.annotations.Data

/**
 * A descriptor class which stores the (command-line) argument's name,
 * description, and type (e.g. String.class, Integer.class).
 * 
 * @author benedekh
 */
@Data
class ArgumentDescriptorWithParameter<T> {

	// the name of the argument
	String name

	// a description for the argument
	String description

	// type of the argument (e.g. String.class, Integer.class)
	Class<T> type
}
