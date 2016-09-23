/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var segments = [];

var turnouts = [];

var locomotives = [];

function pullInformationFromNetwork() {
    // for now, its a dummy function
    for (var s in window.segments) {
        window.segments[s].setSegmentEnabled();
    }

    for (var t in window.turnouts) {
        window.turnouts[t].setInStraightPosition();
    }
    

    // first, animate locomotive on segment s01 and then release on itself
    window.locomotives[1].setOnSegment(window.segments[18], false);
    window.locomotives[0].setOnSegment(window.segments[0], false);
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

    pullInformationFromNetwork();
});
