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
	// occupancy is temporarily disabled
    return;
	

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
	var train = window.locomotives[trainSpeed.trainID];
	
	if( train !== undefined ) {
		var speed = trainSpeed.currentSpeed;
		if( trainSpeed.direction !== "FORWARD" ) {
			speed *= -1;
		}
		train.setSpeed(speed);
	}
}

function getOrCreateTrainByName(trainName) {
	if( window.locomotives[trainName] == undefined ) {
		
		// search for configuration, if it found, push it into the registry
		var config = new Map(window.settings.locomotives).forEach(function(value, key, map) {
			if(key == trainName) {
				window.locomotives[trainName] = new LocomotiveController(value, trainController);
				// must update DOM twice to enable background too
				updateDOM();
				updateDOM();
			}
		});
	}
	
	return window.locomotives[trainName];
}

function updateTrainPositionCallback(trainPosition) {
	
	// if we getting zero values and notracking information, halt anything
	if( trainPosition.realposition.x == 0 
			&& trainPosition.realposition.y == 0 
			&& !trainPosition.tracked[0] ) {
		return;
	}
	
	var train = getOrCreateTrainByName(trainPosition.name);
	train.positionInformationReceived(trainPosition);
}

function sensorStateReceivedCallback(sensorState) {
	var train = getOrCreateTrainByName(sensorState.locomotiveName);
	train.showSensorSpeed(sensorState.speed);
}

// this must be moved to the global scope to use in position updater callback
var trainController = new TrainSpeedController();

$(document).ready(function () {

    // creating controllers to able to communicate through the transport layer
    var segmentStateController = new SegmentStateController();
    var turnoutStateController = new TurnoutStateController();
    
    // creating state updaters to able to get information from transport layer
    var segmentStateUpdater = new SegmentStateUpdater(updateSegmentStateCallback);
    var turnoutStateUpdater = new TurnoutStateUpdater(updateTurnoutStateCallback);
    
    var segmentOccupancyUpdater = new SegmentOccupancyUpdater(updateSegmentOccupancyCallback);
    var trainSpeedStateUpdater = new TrainSpeedStateUpdater(updateTrainSpeedCallback);
    var trainPositionUpdater = new TrainPositionUpdater(updateTrainPositionCallback);
    
    var sensorStateReceiver = new SensorStateReceiver(sensorStateReceivedCallback);
    
    // setup every segment objects
    new Map(window.settings.segments).forEach(function (value, key, map) {
        window.segments[key] = new SegmentController(value, segmentStateController, key);
    });
   
    // setup turnout objects
    new Map(window.settings.turnouts).forEach(function (value, key, map) {
        window.turnouts[key] = new TurnoutController(value, turnoutStateController, key);
    });

    updateDOM();


    // setup event handlers for control buttons
    $("#control-all-segments-en").bind('click', function() {
        for(var i in window.segments) {
            window.segments[i].pushSegmentState("ENABLED");
        }
    });    
    $("#control-all-segments-dis").bind('click', function() {         
        for(var i in window.segments) {
                window.segments[i].pushSegmentState("DISABLED");
    }
    });    

    $("#control-all-turnouts-str").bind('click', function() {
        for(var i in window.turnouts) {
                window.turnouts[i].pushTurnoutState("STRAIGHT");
        }
    });
    
    $("#control-all-turnouts-div").bind('click', function() {
        for(var i in window.turnouts) {
            window.turnouts[i].pushTurnoutState("DIVERGENT");
        }
    });

    $("#add-train").bind('click', function() {
    	
    	// 1. clear train list container (#train-list)
    	$("#train-list").empty();
    	
    	// 2. add all train with DOM
    	for(var i=9; i<20; ++i) {
			var locoObject = new Map(window.settings.locomotives).get(i);
			
			var urlstr= "background-image: url('/images/locomotives/";
			var prev = locoObject.preview;
			var res = urlstr.concat(prev);
			var urlres = res.concat("')");
			
    		var div = $('<div />').addClass('train-list-item');
    		var header = $('<h3/>').text(locoObject.name);
    		var imageholder = $('<div />').addClass('train-image-holder').attr('style', urlres);
			var input = $("<input />").attr('type', 'hidden').attr('name', 'train-id').val(i);
    		
			div.append(header);
			div.append(imageholder);
    		div.append(input);
    		
    		if( locomotiveList.indexOf(i) !== -1 ) {
    			div.addClass('added');
    		}
    		
    		$("#train-list").append(div);
    		
    		$('.train-list-item:not(.added)').bind('click', function() {
    	    	$('.train-list-item.selected').removeClass('selected');
    	    	$(this).addClass('selected');
    	    });
    	    
    	}
    	
    	$("#dialog-container").css('display', 'block').animate({
    		left: 0
    	}, 50, function() {
    		$('#add-train-dialog').addClass('show');
    	});
    });
    
    $('.dialog-cancel').bind('click', function() {
    	$('.dialog').removeClass('show');
    	$("#dialog-container").delay(250).hide(10);
    });
    
    $('#add-train-button').bind('click', function() {
    	// animate dialog button
    	$('#add-train-dialog').removeClass('show').addClass('accepted');
    	$("#dialog-container").delay(250).hide(10, function() {
    		$('#add-train-dialog').removeClass('accepted');
    	});
    	
    	// get selected train
    	var newId = parseInt($('#add-train-dialog .train-list-item.selected > input').val());
    	
    	locomotiveList.push(newId);
    	setCookie(cookie_locomotives, locomotiveList.toString(), 365);
    	
    	// get locomotive with new ID from setup array and insert it into the list next to them
    	var locoObject = new Map(window.settings.locomotives).get(newId);
    	window.locomotives[newId] = new LocomotiveController(locoObject, trainController);
    	
    	$("#train-"+newId).hide(0).delay(400).fadeIn(400);	
    	
    	// remove selected item from list items
    	$('.train-list-item').removeClass('selected');
    });
    
    
    $("#stop-all-trains").bind('click', function() {
    	$('input[type="range"]').val(0);
    	$('input[type="range"]').trigger('change');
    });
    
    
    // implement tabs
    var tabs = ["layout-tab", "devices-tab", "stream-tab"];
    for(var i in tabs) {
    	$('#'+tabs[i]+"-header").bind('click', {tab: tabs[i]}, function (event) {
    		
    		for(var k in tabs) {
    			$('#'+tabs[k]).removeClass('active');
    			$('#'+tabs[k]+"-header").removeClass('active');
    		}
    		
			$('#'+event.data.tab).addClass('active');
			$('#'+event.data.tab+"-header").addClass('active');
    	});
    }
    
    // sending all state request one time
    var allStateWS = new WSConnection("allstate", "");
    allStateWS.request.onOpen = function(response) {
		// send message immediately
		this.wsconnection.publish({});
    };
    allStateWS.connect();
    
});
