package hu.bme.mit.inf.modes3.safetylogic.sc.network

import hu.bme.mit.inf.modes3.messaging.mms.MessagingService
import hu.bme.mit.inf.modes3.messaging.mms.messages.YakinduReleaseTo
import hu.bme.mit.inf.modes3.safetylogic.sc.util.ConnectionDirection
import hu.bme.mit.inf.modes3.safetylogic.sc.util.ConnectionDirectionTransformator
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito

class YakinduNetworkMessageSenderTests {
	
	var YakinduNetworkMessageSender sender
	
	@Mock
	var MessagingService msMock
	
	@Test
	def void test(){
		// Arrange
		msMock = Mockito.mock(MessagingService)
		sender = new YakinduNetworkMessageSender(msMock)
		val targetID = 12
		val targetDirection = ConnectionDirection.BOTTOM
		val sentMessage = (YakinduReleaseTo.newBuilder => [
			it.targetID = targetID
			it.direction = ConnectionDirectionTransformator.toProtobufDirection(targetDirection)
		]).build
		
		// Act
		sender.releaseTo(targetID, targetDirection)
		
		// Assert
		Mockito.verify(msMock, Mockito.times(1)).sendMessage(sentMessage)
	}
}