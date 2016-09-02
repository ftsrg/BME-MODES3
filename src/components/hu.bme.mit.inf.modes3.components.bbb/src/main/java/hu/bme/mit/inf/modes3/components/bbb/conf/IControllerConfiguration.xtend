package hu.bme.mit.inf.modes3.components.bbb.conf;

/**
 * Interface for common methods of the embedded controllers.
 * 
 * @author hegyibalint, benedekh
 */
public interface IControllerConfiguration {

	/**
	 * Tells whether the respective embedded controller manages the referred
	 * turnout.
	 * 
	 * @param turnoutId which shall be checked whether it is managed by the
	 * embedded controller
	 * @return true, if the respective embedded controller manages the turnout
	 */
	def boolean controllerManagesTurnout(int turnoutId);

	/**
	 * Tells whether the respective embedded controller manages the referred
	 * section.
	 * 
	 * @param sectionId which shall be checked whether it is managed by the
	 * embedded controller
	 * @return true, if the respective embedded controller manages the section
	 */
	def boolean controllerManagesSection(int sectionId);
}
