package hu.bme.mit.inf.modes3.components.common

import hu.bme.mit.inf.modes3.messaging.mms.dispatcher.ProtobufMessageDispatcher
import org.eclipse.xtend.lib.annotations.Accessors

abstract class ProtobufAbstractComponent extends AbstractComponent {
	@Accessors(PROTECTED_GETTER, PACKAGE_SETTER) ProtobufMessageDispatcher dispatcher = new ProtobufMessageDispatcher
	
	override init() {
		super.init()
		
		dispatcher ?: new ProtobufMessageDispatcher
	}
	
}