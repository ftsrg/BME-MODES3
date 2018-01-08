package hu.bme.mit.inf.modes3.utils.common.jopt

import org.eclipse.xtend.lib.annotations.Data

/**
 * A descriptor class which stores the (command-line) argument's name,
 * description, and type.
 * 
 * @author benedekh
 */
 @Data
public class ArgumentDescriptorWithoutParameter {

	// the name of the argument
	String name

	// a description for the argument
	String description
}
