package hu.bme.mit.inf.safetylogic.event

import hu.bme.mit.inf.saferylogic.model.modelutil.ModelUtil
import hu.bme.mit.inf.safetylogic.model.railroadmodel.SectionModel
import java.util.ArrayList
import java.util.HashMap
import java.util.Map
import hu.bme.mit.inf.kvcontrol.mqtt.client.senders.TurnoutRequestSender

class TurnoutReader {
	var SectionModel sectionmodel
	var TurnoutRequestSender trs

	new(SectionModel model, TurnoutRequestSender trs) {
		this.sectionmodel = model
		this.trs = trs
	}

	def setTurnoutStatuses() {
		var turnoutIds = #[1, 2, 4, 3, 5, 6, 7]; // XXX add the turnouts list to the model
		var Map<Integer, Integer> englishTurnoutMap = new HashMap<Integer, Integer>
		englishTurnoutMap.put(7, 4); // XXX add this mapping to the model? 
		val turnoutStates = new ArrayList<Boolean>
		for (var int i = 0; i != 10; i++) {
			turnoutStates.add(true);
		}
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

	def toPhysicalID(Integer integer) { // XXX This should be in the model too
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
