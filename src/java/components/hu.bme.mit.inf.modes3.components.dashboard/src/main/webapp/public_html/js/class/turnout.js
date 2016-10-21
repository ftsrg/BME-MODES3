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

function TurnoutController(turnoutConfig, stateController, controlKey) {
    // setting up instance variables
    this.config = turnoutConfig;
    this.stateController = stateController;
    this.controlKey = controlKey;
    this.svgElemDiv = $('#layout').find("#" + this.config.id + "-div");
    this.svgElemStr = $('#layout').find("#" + this.config.id + "-str");
    this.svgElemDivControl = $('#layout').find("#" + this.config.id + "-div-control");
    this.svgElemStrControl = $('#layout').find("#" + this.config.id + "-str-control");

    // all turnout will be undefined for the first time
    setSvgElementOpacity(this.svgElemDiv, window.settings.turnout.inactiveBranchOpacity);
    setSvgElementOpacity(this.svgElemStr, window.settings.turnout.inactiveBranchOpacity);
    setTurnoutControlElementColor(this.svgElemStrControl, window.settings.turnout.undefinedControlColor);
    setTurnoutControlElementColor(this.svgElemDivControl, window.settings.turnout.undefinedControlColor);
};

TurnoutController.prototype.setTurnoutState = function(turnoutState) {
	log("turnout state value: "+turnoutState);
	this.position = turnoutState;
	
	if( this.isInStraightPosition() ) {
		// first, the divergent track element and the controller will be grey
	    setSvgElementOpacity(this.svgElemDiv, window.settings.turnout.inactiveBranchOpacity);log()
	    setTurnoutControlElementColor(this.svgElemDivControl, window.settings.turnout.activeControlColor);
	    this.svgElemDivControl.addClass("control");

	    // then recolor straight track element and controller as well
	    setSvgElementOpacity(this.svgElemStr, window.settings.turnout.activeBranchOpacity);
	    setTurnoutControlElementColor(this.svgElemStrControl, window.settings.turnout.inactiveControlColor);
	    this.svgElemStrControl.removeClass("control");
	    logEvent("Turnout #" + this.config.id + " is in straight state");
	}
	
	if( this.isInDivergentPosition() ) {
		// first, the straight track element and the controller will be grey
	    setSvgElementOpacity(this.svgElemStr, window.settings.turnout.inactiveBranchOpacity);
	    setTurnoutControlElementColor(this.svgElemStrControl, window.settings.turnout.activeControlColor);
	    this.svgElemStrControl.addClass("control");

	    // then recolor divergent track element and controller as well
	    setSvgElementOpacity(this.svgElemDiv, window.settings.turnout.activeBranchOpacity);
	    setTurnoutControlElementColor(this.svgElemDivControl, window.settings.turnout.inactiveControlColor);
	    this.svgElemDivControl.removeClass("control");

	    // set variable to store position
	    logEvent("Turnout #" + this.config.id + " is in divergent state");
	}
	
	
}

TurnoutController.prototype.isInStraightPosition = function () {
    return this.position === "STRAIGHT";
};

TurnoutController.prototype.isInDivergentPosition = function () {
    return this.position === "DIVERGENT";
};

TurnoutController.prototype.pushTurnoutState = function(turnoutState) {
	log("Pushing new segment state for segment "+this.controlKey+", state: "+turnoutState);
	this.stateController.pushTurnoutState(this.controlKey, turnoutState == "DIVERGENT"? 1 : 0);
}

TurnoutController.prototype.DOMUpdatedCallback = function() {
    this.svgElemDiv = $('#layout').find("#" + this.config.id + "-div");
    this.svgElemStr = $('#layout').find("#" + this.config.id + "-str");
    this.svgElemDivControl = $('#layout').find("#" + this.config.id + "-div-control");
    this.svgElemStrControl = $('#layout').find("#" + this.config.id + "-str-control");
    
    // add event handlers for controls 
    this.svgElemDivControl.bind('click', {_this: this}, function (event) {
        // send control message over transport layer
    	event.data._this.pushTurnoutState("DIVERGENT");
    });
    this.svgElemStrControl.bind('click', {_this: this}, function (event) {
        // send control message over transport layer
    	event.data._this.pushTurnoutState("STRAIGHT");
    });
};


