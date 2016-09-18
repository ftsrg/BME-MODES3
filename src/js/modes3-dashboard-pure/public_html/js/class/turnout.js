/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 * Turnout Controller Class
 * 
 * Turnout Controller Class instances are mainly responsible for displaying 
 * one turnout's state
 * 
 */

function TurnoutControllerClass(turnoutID) {
    // setting up instance variables
    this.turnoutID = turnoutID;
    this.svgElemDiv = $('#layout').find("#t0"+turnoutID+"-div");
    this.svgElemStr = $('#layout').find("#t0"+turnoutID+"-str");
    this.svgElemDivControl  = $('#layout').find("#t0"+turnoutID+"-div-control");
    this.svgElemStrControl  = $('#layout').find("#t0"+turnoutID+"-str-control");
    
    // all turnout will be undefined for the first time
    setSvgElementOpacity(this.svgElemDiv, settings.inactiveTurnoutBranchOpacity);
    setSvgElementOpacity(this.svgElemStr, settings.inactiveTurnoutBranchOpacity);
    setTurnoutControlElementColor(this.svgElemStrControl, settings.inactiveTurnoutBranchColor);
    setTurnoutControlElementColor(this.svgElemDivControl, settings.inactiveTurnoutBranchColor);
    
    // add event handlers for controls 
    this.svgElemDivControl.bind('click', {_this: this}, function(event) {
        event.data._this.setInDivergentPosition();
    });
    this.svgElemStrControl.bind('click', {_this: this}, function(event) {
        event.data._this.setInStraightPosition();
    });
    
}

TurnoutControllerClass.prototype.setInStraightPosition = function() {
    // if turnout is already in straight state, then return
    if( this.isInStraightPosition() ) {
        return;
    }
    
    // first, the divergent track element and the controller will be grey
    setSvgElementOpacity(this.svgElemDiv, settings.inactiveTurnoutBranchOpacity);
    setTurnoutControlElementColor(this.svgElemDivControl, settings.activeTurnoutBranchColor);
    this.svgElemDivControl.addClass("control");
    
    // then recolor straight track element and controller as well
    setSvgElementOpacity(this.svgElemStr, settings.activeTurnoutBranchOpacity);
    setTurnoutControlElementColor(this.svgElemStrControl, settings.inactiveTurnoutBranchColor);
    this.svgElemStrControl.removeClass("control");
    
    // set variable to store position
    this.position = "str";
    log("Turnout #"+this.turnoutID+" is in straight state");
}

TurnoutControllerClass.prototype.setInDivergentPosition = function() { 
    // if turnout is already in straight state, then return
    if( this.isInDivergentPosition() ) {
        return;
    }
    // first, the straight track element and the controller will be grey
    setSvgElementOpacity(this.svgElemStr, settings.inactiveTurnoutBranchOpacity);
    setTurnoutControlElementColor(this.svgElemStrControl, settings.activeTurnoutBranchColor);
    this.svgElemStrControl.addClass("control");
    
    // then recolor divergent track element and controller as well
    setSvgElementOpacity(this.svgElemDiv, settings.activeTurnoutBranchOpacity);
    setTurnoutControlElementColor(this.svgElemDivControl, settings.inactiveTurnoutBranchColor);
    this.svgElemDivControl.removeClass("control");
    
    // set variable to store position
    this.position = "div";
    log("Turnout #"+this.turnoutID+" is in divergent state");
}

TurnoutControllerClass.prototype.isInStraightPosition = function() {
    return this.position === "str";
}

TurnoutControllerClass.prototype.isInDivergentPosition = function() {
    return this.position === "div";
}


