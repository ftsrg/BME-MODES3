package hu.bme.mit.inf.safetylogic.event

import hu.bme.mit.inf.saferylogic.model.modelutil.ModelUtil
import hu.bme.mit.inf.safetylogic.model.railroadmodel.SectionModel
import java.util.ArrayList
import java.util.HashMap
import java.util.Map
import hu.bme.mit.inf.kvcontrol.mqtt.client.senders.TurnoutRequestSender

class TurnoutReader {
	val SectionModel sectionmodel
	val TurnoutRequestSender trs
	val turnoutIds = #[1, 2, 4, 3, 5, 6, 7]; // XXX add the turnouts list to the model
	val Map<Integer, Integer> englishTurnoutMap = new HashMap<Integer, Integer>
	val turnoutStates = new ArrayList<Boolean>

	new(SectionModel model, TurnoutRequestSender trs) {
		this.sectionmodel = model
		this.trs = trs

		englishTurnoutMap.put(7, 4); // XXX add this mapping to the model? 
		for (var int i = 0; i != 10; i++) {
			turnoutStates.add(true);
		}

	}

	def setTurnoutStatuses() {
		for (id : turnoutIds) {
			if (trs.isTurnoutStraight(id.toPhysicalID) != turnoutStates.get(id)) {
				println("Switch" + id + "changed")
				if (englishTurnoutMap.keySet.contains(id)) {
					var remappedId = englishTurnoutMap.get(id);
					ModelUtil.switchEnglishTurnout(ModelUtil.getTurnoutByID(sectionmodel, remappedId));
				} else {
					ModelUtil.switchTurnout(ModelUtil.getTurnoutByID(sectionmodel, id));
				}
				turnoutStates.set(id, trs.isTurnoutStraight(id.toPhysicalID));
			}
		}
	}

	static def toPhysicalID(Integer integer) { // XXX This should be in the model too
		switch integer {
			case 1: 0x81
			case 2: 0x82
			case 3: 0x83
			case 4: 0x86
			case 5: 0x84
			case 6: 0x85
			case 7: 0x87
		}

	}

}
