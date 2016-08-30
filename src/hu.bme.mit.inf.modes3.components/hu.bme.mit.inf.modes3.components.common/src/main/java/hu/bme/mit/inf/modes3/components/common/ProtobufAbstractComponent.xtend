package hu.bme.mit.inf.modes3.components.common

import hu.bme.mit.inf.modes3.messaging.mms.dispatcher.ProtobufMessageDispatcher
import org.eclipse.xtend.lib.annotations.Accessors

abstract class ProtobufAbstractComponent extends AbstractComponent {
	@Accessors(PROTECTED_GETTER, PROTECTED_SETTER) ProtobufMessageDispatcher dispatcher = new ProtobufMessageDispatcher
}