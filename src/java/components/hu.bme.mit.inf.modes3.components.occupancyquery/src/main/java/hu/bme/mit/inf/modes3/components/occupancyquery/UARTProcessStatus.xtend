package hu.bme.mit.inf.modes3.components.occupancyquery

enum UARTProcessStatus {
	BEFORE_HEADER_END, LAST_BYTE_OF_HEADER_HAS_TO_COME, DETECTING_OCCUPANCIES
}