/**
 * 
 */

var TRAIN_SPEED_RESOURCE = "trainspeed"

function TrainSpeedController() {
	
	var ws = new WSConnection(TRAIN_SPEED_RESOURCE);
	
	ws.connect();
	
	TrainSpeedController.prototype.setTrainSpeed = function(trainId, speed) {
		var trainSpeedData = createTrainSpeedData(trainId, speed);
		ws.publish(trainSpeedData);
	}
	
}

function SectionController() {
	// TODO: implement
}

function TurnoutController() {
	// TODO: implement
}
