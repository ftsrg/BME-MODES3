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
	log("segment state: ");
	log(segmentState);
    window.segments[segmentState.segmentID].refreshSegmentState(segmentState);
}

$(document).ready(function () {

    // creating controllers to able to communicate through the transport layer
    var segmentStateController = new SegmentStateController();
    var turnoutStateController = new TurnoutStateController();
    
    // creating state updaters to able to get information from transport layer
    var segmentStateUpdater = new SegmentStateUpdater(updateSegmentStateCallback);

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
    	window.locomotives[key] = new LocomotiveController(value, trainController)
    })

    updateDOM();

//    // setup event handler for control trains button
//    $('#train-control-button').bind('click', function () {
//        $("#train-control").toggleClass('active');
//        $("#train-control-button").toggleClass('active');
//    });
//
//    $("#test-range").bind('mousemove', function () {
//        window.locomotives[0].setOnSegment(window.segments[segment_index], $(this).val());
//    });
//
//    $("#test-number").bind('change', function () {
//        log($(this).val());
//        // set previous segment enabled
//        window.segments[segment_index].setEnabled();
//        
//        segment_index = $(this).val();
//
//        window.segments[segment_index].setDisabled();
//        window.locomotives[0].setOnSegment(window.segments[segment_index], 0);
//    });
//    
//    $("#test-number").trigger('change');

    //pullInformationFromNetwork();
});
