package hu.bme.mit.inf.modes3.components.occupancyquery

class TestS88CommunicationReader implements IS88CommunicationReader {
	override read() {
		newByteArrayOfSize(4) => [set(0, 0xAA as byte); set(1, 0xAA as byte); set(2, 0xAA as byte); set(3, 0xAA as byte);]
	}
}
