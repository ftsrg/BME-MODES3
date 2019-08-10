package hu.bme.mit.inf.modes3.messaging.messages.yakindu

/**
 * The message types used by the Yakindu protocol between the state machines.
 * 
 * @author benedekh
 */
enum YakinduMessageType {
	CAN_GO_TO,
	CANNOT_GO_TO,
	RELEASE_TO,
	RESERVE_TO
}
