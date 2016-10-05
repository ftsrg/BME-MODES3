/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var segments = [];

var turnouts = [];

var locomotives = [];

var segment_index = 0;

function pullInformationFromNetwork() {
    // for now, its a dummy function
    for (var s in window.segments) {
        window.segments[s].setEnabled();
    }

    for (var t in window.turnouts) {
        window.turnouts[t].setInStraightPosition();
    }
}

$(document).ready(function () {

    // setup segment objects
    for (var s in window.settings.segments) {
        window.segments.push(new SegmentController(window.settings.segments[s]));
    }

    // setup turnout objects
    for (var t in window.settings.turnouts) {
        window.turnouts.push(new TurnoutController(window.settings.turnouts[t]));
    }

    // setup locomotive objects
    for (var l in window.settings.locomotives) {
        window.locomotives.push(new LocomotiveController(window.settings.locomotives[l]));
    }

    updateDOM();

    // setup event handler for control trains button
    $('#train-control-button').bind('click', function () {
        $("#train-control").toggleClass('active');
        $("#train-control-button").toggleClass('active');
    });

    $("#test-range").bind('mousemove', function () {
        window.locomotives[0].setOnSegment(window.segments[segment_index], $(this).val());
    });

    $("#test-number").bind('change', function () {
        log($(this).val());
        // set previous segment enabled
        window.segments[segment_index].setEnabled();
        
        segment_index = $(this).val();

        window.segments[segment_index].setDisabled();
        window.locomotives[0].setOnSegment(window.segments[segment_index], 0);
    });
    
    $("#test-number").trigger('change');
    
    

    pullInformationFromNetwork();
});
