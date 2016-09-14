package hu.bme.mit.inf.modes3.components.util.jopt

import org.eclipse.xtend.lib.annotations.Accessors

/**
 * A descriptor class which stores the (command-line) argument's name,
 * description, and type (e.g. String.class, Integer.class).
 * 
 * @author benedekh
 */
public class ArgumentDescriptor<T> {

	// the name of the argument
	@Accessors(PUBLIC_GETTER, PRIVATE_SETTER) var String name

	// a description for the argument
	@Accessors(PUBLIC_GETTER, PRIVATE_SETTER) var String description

	// type of the argument (e.g. String.class, Integer.class)
	@Accessors(PUBLIC_GETTER, PRIVATE_SETTER) var Class<T> type

	/**
	 * @param name name of the argument
	 * @param description description for the argument
	 */
	new(String name, String description) {
		this.name = name
		this.description = description
	}

	/**
	 * @param name name of the argument
	 * @param description description for the argument
	 * @param type type of the argument
	 */
	new(String name, String description, Class<T> type) {
		this(name, description)
		this.type = type
	}
}
