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
	
	String name
	String description
	Class<T> type
	
	/**
	 * @param name the name of the argument 
	 * @param description a description for the argument 
	 * @param type type of the argument (e.g. String.class, Integer.class)  
	 */
	new(String name, String description, Class<T> type) {
		this.name = name
		this.description = description
		this.type = type
	}
	
}
