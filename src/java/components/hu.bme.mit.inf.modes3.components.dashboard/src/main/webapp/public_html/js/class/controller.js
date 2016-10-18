/**
 * 
 */
var TRAIN_SPEED_RESOURCE = "trainspeed"
var SEGMENT_OCCUPANCY_RESOURCE = "segmentoccupancy"
	
function TrainSpeedController() {
	
	var ws = new WSConnection(TRAIN_SPEED_RESOURCE);
	
	ws.connect();
	
	TrainSpeedController.prototype.pushTrainSpeed = function(trainId, speed, direction) {
		var trainSpeedData = createTrainSpeedData(trainId, speed, direction);
		ws.publish(trainSpeedData);
	}
	
}

function SegmentOccupancyController(callback) {
	
	var ws = new WSConnection(SEGMENT_OCCUPANCY_RESOURCE);
	
	ws.connect();
	
	ws.onMessageArrived = callback;
}

function TurnoutController() {
	// TODO: implement
}
