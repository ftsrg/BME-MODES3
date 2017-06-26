/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var segments = new Map();

var turnouts = new Map();

var locomotives = new Map();

var segment_index = 0;

var cookie_locomotives = 'locomotives';

var locomotiveList = getLocomotiveList();

function setCookie(cname, cvalue, exdays) {
    var d = new Date();
    d.setTime(d.getTime() + (exdays * 24 * 60 * 60 * 1000));
    var expires = "expires=" + d.toUTCString();
    document.cookie = cname + "=" + cvalue + ";" + expires + ";path=/";
}

function getCookie(cname) {
    var name = cname + "=";
    var ca = document.cookie.split(';');
    for (var i = 0; i < ca.length; i++) {
        var c = ca[i];
        while (c.charAt(0) === ' ') {
            c = c.substring(1);
        }
        if (c.indexOf(name) === 0) {
            return c.substring(name.length, c.length);
        }
    }
    return "";
}

function getLocomotiveList() {
    var ids = getCookie(cookie_locomotives);
    if (ids !== "") {
        return eval("["+ids+"]");
    } else {
        ids = [];
        setCookie(cookie_locomotives, "[]", 365);
        return ids;
    }
}


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
		console.log(trainSpeed.currentSpeed);
		var speed = trainSpeed.currentSpeed;
		console.log(speed);
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
    	if( locomotiveList.indexOf(key) !== -1 ) {
    		window.locomotives[key] = new LocomotiveController(value, trainController);
    	}
    })

    updateDOM();
    
    // setup event handlers for control buttons
    $("#control-all-segment-en").bind('click', function() {
    	for(var i in window.segments) {
    		window.segments[i].pushSegmentState("ENABLED");
    	}
    });    
    $("#control-all-segment-dis").bind('click', function() {         
        for(var i in window.segments) {                          
                window.segments[i].pushSegmentState("DISABLED");
	}
    });    

    $("#control-all-turnout-str").bind('click', function() {
        for(var i in window.turnouts) {
                window.turnouts[i].pushTurnoutState("STRAIGHT");
        }
    });                                                         
    
    $("#control-all-turnout-div").bind('click', function() {
    	for(var i in window.turnouts) {
    		window.turnouts[i].pushTurnoutState("STRAIGHT");
    	}
    });
    
    $("#add-train").bind('click', function() {
    	
    	// TODO add all train from config file
    	
    	// 1. clear train list container (#train-list)
    	$("#train-list").empty();
    	
    	// 2. add all train with DOM
    	for(var i=0; i<10; ++i) {
    		var div = $('<div />').addClass('train-list-item');
    		var header = $('<h3/>').text(i);
    		var input = $("<input />").attr('type', 'hidden').attr('name', 'train-id').val(i);
    		div.append(header);
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
    	//setCookie(cookie_locomotives, locomotiveList.toString(), 365);
    	
    	// get locomotive with new ID from setup array and insert it into the list next to them
    	var locoObject = new Map(window.settings.locomotives).get(newId);
    	window.locomotives[newId] = new LocomotiveController(locoObject, trainController);
    	
    	$("#train-"+newId).hide(0).delay(400).fadeIn(400);	
    	
    	// remove selected item from list items
    	$('.train-list-item').removeClass('selected');
    });
    
    
    $("#stop-all-train").bind('click', function() {
    	$('input[type="range"]').val(0);
    	$('input[type="range"]').trigger('change');
    });
    
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
