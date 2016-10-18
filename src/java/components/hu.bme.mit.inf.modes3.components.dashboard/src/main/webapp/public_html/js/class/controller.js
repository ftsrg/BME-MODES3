/**
 * 
 */

var TRAIN_SPEED_RESOURCE = "trainspeed"

function TrainSpeedController() {
	
	var ws = new WSConnection(TRAIN_SPEED_RESOURCE);
	
	ws.connect();
	
	TrainSpeedController.prototype.pushTrainSpeed = function(trainId, speed, direction) {
		var trainSpeedData = createTrainSpeedData(trainId, speed, direction);
		ws.publish(trainSpeedData);
	}
	
}

function SectionController() {
	// TODO: implement
}

function TurnoutController() {
	// TODO: implement
}
