/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var segments = new Map();

var turnouts = new Map();

var locomotives = new Map();

var segment_index = 0;

function updateSegmentStateCallback(segmentState) {
    window.segments[segmentState.segmentID].setSegmentState(segmentState.state);
}

function updateTurnoutStateCallback(turnoutState) {
	window.turnouts[turnoutState.turnoutID].setTurnoutState(turnoutState.state);
}

function updateSegmentOccupancyCallback(segmentOccupancy) {

	// if segment is not find in the segments hash, then it must be a turnout
	var segment = window.segments[segmentOccupancy.segmentID];
	if( segment === undefined ) {
		for(var id in window.turnouts) {
			if( $.inArray(segmentOccupancy.segmentID, window.turnouts[id].config.senseID) !== -1 ) {
				segment = window.turnouts[id];
				break;
			}
		}
	}
	
	// if segment still not found, then halt process
	if( segment === undefined ) {
		return;
	}
	
	// segment ID only related for one turnout, but we give to everybody
	segment.setOccupancyState(segmentOccupancy.state, segmentOccupancy.segmentID);
}

function updateTrainSpeedCallback(trainSpeed) {
	console.log(trainSpeed);
	var train = window.locomotives[trainSpeed.trainID];
	
	if( train !== undefined ) {
		var speed = trainSpeed.currentSpeed;
		if( trainSpeed.direction !== "FORWARD" ) {
			speed *= -1;
		}
		train.setSpeed(speed);
	}
}

$(document).ready(function () {

    // creating controllers to able to communicate through the transport layer
    var segmentStateController = new SegmentStateController();
    var turnoutStateController = new TurnoutStateController();
    
    // creating state updaters to able to get information from transport layer
    var segmentStateUpdater = new SegmentStateUpdater(updateSegmentStateCallback);
    var turnoutStateUpdater = new TurnoutStateUpdater(updateTurnoutStateCallback);
    var segmentOccupancyUpdater = new SegmentOccupancyUpdater(updateSegmentOccupancyCallback);
    var trainSpeedStateUpdater = new TrainSpeedStateUpdater(updateTrainSpeedCallback);
    
    // setup every segment objects
    new Map(window.settings.segments).forEach(function (value, key, map) {
        window.segments[key] = new SegmentController(value, segmentStateController, key);
    });
   
    // setup turnout objects
    new Map(window.settings.turnouts).forEach(function (value, key, map) {
        window.turnouts[key] = new TurnoutController(value, turnoutStateController, key);
    });

    
    // setup locomotive objects
    var trainController = new TrainSpeedController();
    new Map(window.settings.locomotives).forEach(function(value, key, map) {
    	window.locomotives[key] = new LocomotiveController(value, trainController);
    })

    updateDOM();
    
    // setup event handlers for control buttons
    $("#control-all-segment").bind('click', function() {
    	for(var i in window.segments) {
    		window.segments[i].pushSegmentState("ENABLED");
    	}
    });
    
    $("#control-all-turnout").bind('click', function() {
    	for(var i in window.turnouts) {
    		window.turnouts[i].pushTurnoutState("STRAIGHT");
    	}
    });
    
    $("#stop-all-train").bind('click', function() {
    	$('input[type="range"]').val(0);
    	$('input[type="range"]').trigger('change');
    });
    
//    $("#test").bind('click', function() {
//    	window.locomotives[9].setSpeed(10);
//    });
    $("#test").remove();
    
    // sending all state request one time
    var allStateWS = new WSConnection("allstate", "");
    allStateWS.request.onOpen = function(response) {
		console.log("Connection opened: " + response.request.uuid);
    	
		// send message immediately
		this.wsconnection.publish({});
    };
    allStateWS.connect();
    
});
