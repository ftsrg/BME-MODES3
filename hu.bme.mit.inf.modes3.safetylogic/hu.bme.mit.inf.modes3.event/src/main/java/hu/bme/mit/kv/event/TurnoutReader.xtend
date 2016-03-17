package hu.bme.mit.kv.event

import java.lang.Runnable
import hu.bme.mit.kv.model.railroadmodel.SectionModel
import hu.bme.mit.kv.model.modelutil.ModelUtil
import java.util.ArrayList
import java.util.Map
import java.util.HashMap

class TurnoutReader implements Runnable {

	var Object lock;
	var SectionModel sectionmodel;

	new(SectionModel model, Object l) {
		sectionmodel = model
		lock = l;
	}

	override run() {
		var turnoutIds = #[1, 2, 4, 3, 5, 6, 7]; // XXX add the turnouts list to the model
		
		var Map<Integer, Integer> englishTurnoutMap = new HashMap<Integer,Integer>
		englishTurnoutMap.put(7,4); //XXX add this mapping to the model? 

		val turnoutStates = new ArrayList<Boolean>
		for (var int i = 0; i != 10; i++) {
			turnoutStates.add(true);
		}
		while (true) {
			synchronized (lock) {
				for (id : turnoutIds) {
//					var isTrue = sender.isTurnoutStraight(id.toPhysicalID);
					var isTrue = true
					if (isTrue != turnoutStates.get(id)) {

						println("Switch" + id + "changed")
						if(englishTurnoutMap.keySet.contains(id)){
							var remappedId = englishTurnoutMap.get(id);
							ModelUtil.switchEnglishTurnout(ModelUtil.getTurnoutByID(sectionmodel, remappedId));

						}else{
							ModelUtil.switchTurnout(ModelUtil.getTurnoutByID(sectionmodel, id));
							
						}
						
						turnoutStates.set(id, isTrue);
					}
				}
			}
			Thread.sleep(500)
		}
	}

	def toPhysicalID(Integer integer) { //XXX This should be in the model too
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