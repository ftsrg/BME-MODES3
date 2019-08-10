package hu.bme.mit.inf.modes3.messaging.mms.dispatcher

/**
 * Serialization/deserialization class that can convert between the raw representation (byte[]) and 
 * the Java object representation of a message.
 * 
 * @author baloghlaszlo
 */
interface IMessageDispatcher {
	/**
	 * Deserializes the message from raw representation to the Java object and forwards it to a corresponding
	 * listener.
	 * 
	 * @param rawMessage the message in raw representation 
	 */
	def void dispatchMessage(byte[] rawMessage);
	
	/**
	 * Serializes the message to its raw representation.
	 * 
	 * @param message to be serialized into raw representation
	 */
	def byte[] convertMessageToRaw(Object message) throws IllegalArgumentException;
}