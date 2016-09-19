package hu.bme.mit.inf.modes3.test

import hu.bme.mit.inf.modes3.components.common.AbstractRailRoadCommunicationComponent
import hu.bme.mit.inf.modes3.messaging.communication.enums.SegmentOccupancy
import hu.bme.mit.inf.modes3.messaging.communication.factory.CommunicationStack
import hu.bme.mit.inf.safetylogic.model.RailRoadModel.RailRoadModel
import java.util.HashMap
import org.eclipse.emf.common.notify.Notification
import org.eclipse.emf.ecore.util.EContentAdapter
import org.slf4j.ILoggerFactory

class SegmentOccupancyReaderMock extends AbstractRailRoadCommunicationComponent {

	val RailRoadModel model
	val isOccupied = new HashMap<Integer, Boolean>

	new(CommunicationStack stack, RailRoadModel model, ILoggerFactory factory) {
		super(stack, factory)
		this.model = model
		model.sections.forEach[isOccupied.put(id, false)]
	}

	override run() {
		model.eAdapters.add(new EContentAdapter() {

			override notifyChanged(Notification msg) {
				super.notifyChanged(msg)
				update()
			}

		})
		model.eSetDeliver(true)
	}

	def update() {
		synchronized(model) {
			val occupiedSections = model.trains.map[it.currentlyOn.id]
			val changedSections = model.sections.filter[occupiedSections.contains(id) == isOccupied.get(id)]
			changedSections.forEach [
				val currentyOccupied = !isOccupied.get(id)
				isOccupied.put(id, currentyOccupied)
				locator.trackElementStateSender.sendSegmentOccupation(id, if(currentyOccupied) SegmentOccupancy.OCCUPIED else SegmentOccupancy.FREE)
			]
		}

	}

}
