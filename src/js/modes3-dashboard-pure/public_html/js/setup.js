/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var segments = [];

var turnouts = [];

var locomotives = [];

var loco_path = ["s22", "t06-div", "s17", "s10", "t05-div", "s08", "s13", "s20", "t03a-div", "t03b-div", "s30",  "t02-div", "s29", "s24", "s15", "t01-str", "s12", "s01", "s02", "t04-str", "s04", "s06", "s18", "s31", "t02-str", "s29"];

var segment_next = 0;

function test() {
    
    window.locomotives[0].setOnSegment(loco_path[segment_next]);
    window.locomotives[0].animateOnSegment(loco_path[segment_next]);
    segment_next = (segment_next + 1 ) % loco_path.length;
    
    setTimeout(test, 3000);
}

$(document).ready(function () {
    
    // setup segment objects
    for( var s in settings.segments ) {
        window.segments.push(new SectionControllerClass(settings.segments[s]));
    }
    
    // setup turnout objects
    for( var t in settings.turnouts ) {
        window.turnouts.push(new TurnoutControllerClass(settings.turnouts[t]));
    }
    
    // setup locomotive objects
    for( var l in settings.locomotives ) {
        window.locomotives.push(new LocomotiveControllerClass(settings.locomotives[l]));
    }
    
    // setup event handler for control trains button
    $('#train-control-button').bind('click', function() {
        $("#train-control").toggleClass('active');
        $("#train-control-button").toggleClass('active');
    });
    
    // start taurus on click
    window.locomotives[0].setOnSegment(loco_path[segment_next]);
    $('#taurus').bind('click', test);

});
