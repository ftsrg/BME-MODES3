package hu.bme.mit.inf.modes3.components.safetylogic.componentlevel.sc.comm.dispatcher

import hu.bme.mit.inf.modes3.utils.conf.layout.whole.ConnectionDirection

interface ICanGoToListener {
	def void canGoTo(int targetID, ConnectionDirection direction)
}
