package hu.bme.mit.inf.safetylogic.event

/**
 * A callback if a listener has to be notified. 
 * 
 * @author baloghlaszlo
 */
interface INotifiable {
	/**
	 * The listener should update itself. 
	 */
	def void onUpdate();
}