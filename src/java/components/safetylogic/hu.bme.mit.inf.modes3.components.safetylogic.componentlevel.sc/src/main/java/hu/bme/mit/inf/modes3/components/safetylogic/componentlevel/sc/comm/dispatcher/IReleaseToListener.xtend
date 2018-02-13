package hu.bme.mit.inf.modes3.components.safetylogic.componentlevel.sc.comm.dispatcher

import hu.bme.mit.inf.modes3.utils.conf.layout.whole.ConnectionDirection

interface IReleaseToListener {
	def void releaseTo(int targetID, ConnectionDirection direction)
}