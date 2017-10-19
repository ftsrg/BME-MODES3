package hu.bme.mit.inf.modes3.utils.common.jopt

import org.eclipse.xtend.lib.annotations.Data

/**
 * A descriptor class which stores the (command-line) argument's name,
 * description, and type (e.g. String.class, Integer.class).
 * 
 * @author benedekh
 */
@Data
class ArgumentDescriptorWithParameter<T> {

	new(String name, String description, Class<T> type) {
		this.name = name
		this.description = description
		this.type = type
	}

	// the name of the argument
	String name

	// a description for the argument
	String description

	// type of the argument (e.g. String.class, Integer.class)
	Class<T> type
	
}
