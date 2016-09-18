/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var segments = [];

var turnouts = [];

var locomotives = [];

$(document).ready(function () {
    
    // setup segment objects
    for( var s in settings.segments ) {
        segments[new SectionControllerClass(settings.segments[s])];
    }
    
    // setup turnout objects
    for( var t in settings.turnouts ) {
        turnouts[new TurnoutControllerClass(settings.turnouts[t])];
    }
    
    // setup locomotive objects
    for( var l in settings.locomotives ) {
        locomotives[new LocomotiveControllerClass(settings.locomotives[l])];
    }
    
    // setup event handler for control trains button
    $('#train-control-button').bind('click', function() {
        $("#train-control").toggleClass('active');
        $("#train-control-button").toggleClass('active');
    });

});
