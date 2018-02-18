package hu.bme.mit.inf.modes3.test

import hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.RailRoadModel
import hu.bme.mit.inf.modes3.messaging.communication.common.AbstractCommunicationComponent
import hu.bme.mit.inf.modes3.messaging.messages.enums.SegmentOccupancy
import hu.bme.mit.inf.modes3.messaging.mms.MessagingService
import java.util.HashMap
import org.eclipse.emf.common.notify.Notification
import org.eclipse.emf.ecore.util.EContentAdapter
import org.slf4j.ILoggerFactory

class SegmentOccupancyReaderMock extends AbstractCommunicationComponent {

	val RailRoadModel model
	val isOccupied = new HashMap<Integer, Boolean>

	new(MessagingService messagingService, RailRoadModel model, ILoggerFactory factory) {
		super(messagingService, factory)
		this.model = model
		model.sections.forEach[isOccupied.put(it.id, false)]
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
		synchronized (model) {
			val occupiedSections = model.trains.map[it.currentlyOn.id]
			val changedSections = model.sections.filter[occupiedSections.contains(it.id) != isOccupied.get(it.id)]
			changedSections.filter[isOccupied.get(id) == false /* Free -> Occupied change*/ ].forEach [
				val currentyOccupied = !isOccupied.get(id)
				isOccupied.put(id, currentyOccupied)
				locator.trackElementStateSender.sendSegmentOccupation(id,
					if(currentyOccupied) SegmentOccupancy.OCCUPIED else SegmentOccupancy.FREE)
			]

			changedSections.filter[isOccupied.get(id) == true /* Occupied -> free change */ ].forEach [
				val currentyOccupied = !isOccupied.get(id)
				isOccupied.put(id, currentyOccupied)
				locator.trackElementStateSender.sendSegmentOccupation(id,
					if(currentyOccupied) SegmentOccupancy.OCCUPIED else SegmentOccupancy.FREE)
			]
		}

	}

}
