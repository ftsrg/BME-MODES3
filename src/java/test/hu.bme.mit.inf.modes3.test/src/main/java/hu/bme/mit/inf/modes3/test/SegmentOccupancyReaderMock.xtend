package hu.bme.mit.inf.modes3.test

import hu.bme.mit.inf.modes3.components.common.AbstractCommunicationComponent
import hu.bme.mit.inf.modes3.messaging.communication.factory.CommunicationStack
import hu.bme.mit.inf.modes3.messaging.communication.factory.TrackCommunicationServiceLocator
import hu.bme.mit.inf.safetylogic.model.RailRoadModel.RailRoadModel
import java.util.HashMap
import org.eclipse.emf.common.notify.Notification
import org.eclipse.emf.common.notify.impl.AdapterImpl
import hu.bme.mit.inf.modes3.messaging.communication.enums.SegmentOccupancy

class SegmentOccupancyReaderMock extends AbstractCommunicationComponent {
	
	val RailRoadModel model
	val TrackCommunicationServiceLocator locator
	val isOccupied = new HashMap<Integer, Boolean> 
	
	new(CommunicationStack stack, RailRoadModel model){
		super(stack)
		this.model = model
		locator = new TrackCommunicationServiceLocator(stack)
		model.sections.forEach[isOccupied.put(id, false)]
	}
	
	override run() {
		model.eAdapters.add(new AdapterImpl(){
			
			override notifyChanged(Notification msg) {
				super.notifyChanged(msg)
				update()
			}
			
		})
	}
	
	def update(){
		println('updated')
		val occupiedSections =  model.trains.map[it.currentlyOn.id]
		val changedSections = model.sections.filter[occupiedSections.contains(id) == isOccupied.get(id)]
		changedSections.forEach[
			val currentyOccupied = !isOccupied.get(id)
			isOccupied.put(id, currentyOccupied)
			locator.trackElementStateSender.sendSegmentOccupation(id, if(currentyOccupied) SegmentOccupancy.OCCUPIED else SegmentOccupancy.FREE)
		]
	}
	
	
	
}