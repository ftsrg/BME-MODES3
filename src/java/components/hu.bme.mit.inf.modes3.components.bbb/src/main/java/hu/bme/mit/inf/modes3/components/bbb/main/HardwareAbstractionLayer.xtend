package hu.bme.mit.inf.modes3.components.bbb.main

import io.silverspoon.bulldog.core.Signal

interface HardwareAbstractionLayer {
	def void setPinLevel(String pin, Signal level)
	def Signal getPinLevel(String pin)
	
}