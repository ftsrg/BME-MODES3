package hu.bme.mit.inf.modes3.messaging.communication.yakindu.interfaces

/**
 * Sends the state machine specific Yakindu messages.
 * 
 * @author benedekh
 */
interface IYakinduMessageSender extends ICanGoToListener, ICannotGoToListener, IReleaseToListener, IReserveToListener {
}
