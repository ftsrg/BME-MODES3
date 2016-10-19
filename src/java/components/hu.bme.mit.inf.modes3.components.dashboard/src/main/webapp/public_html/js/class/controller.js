/**
 * 
 */
var TRAIN_SPEED = "trainspeed";
var SEGMENT_OCCUPANCY = "segmentoccupancy";
var SEGMENT_STATE = "segmentstate";
var TURNOUT_STATE = "turnoutstate";

var STATE = "state";
var COMMAND = "command";


// controller weben control -> hálózat

function TrainSpeedController() {
	
	var tsws = new WSConnection(COMMAND, TRAIN_SPEED);
	
	tsws.connect();
	
	TrainSpeedController.prototype.pushTrainSpeed = function(trainId, speed, direction) {
		var trainSpeedData = createTrainSpeedData(trainId, speed, direction);
		tsws.publish(trainSpeedData);
	}
}

function SegmentStateController() {
	var scws = new WSConnection(COMMAND, SEGMENT_STATE);
	scws.connect();
	
	SegmentStateController.prototype.pushSegmentState = function(segmentId, state) {
		var segmentStateData = createSegmentStateData(segmentId, state);
		scws.publish(segmentStateData);
	}
	
}

function TurnoutStateController() {
	var tcws = new WSConnection(COMMAND, TURNOUT_STATE);
	tcws.connect();
	
	TurnoutController.prototype.pushTurnoutState = function(turnoutId, state) {
		var turnoutStateData = createTurnoutStateData(turnoutId, state);
		tsws.publish(turnoutStateData);
	}
}

// state update ha jön valami a hálózat felől

function SegmentUpdater(callback) {
	
	var suws = new WSConnection(STATE, SEGMENT_OCCUPANCY);
	
	suws.connect();
	
	suws.onMessageArrived = callback;
}

function TurnoutUpdater(callback) {
	
	var tuws = new WSConnection(STATE, TURNOUT_STATE);
	
	tuws.connect();
	
	tuws.onMessageArrived = callback;
}
