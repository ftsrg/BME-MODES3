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
    this.isOccupied = false;
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

TurnoutController.prototype.setOccupancyState = function(segmentOccupancy, senseID) {
	this.isOccupied = segmentOccupancy == "OCCUPIED";
	this.senseID = senseID;
	
	// if turnout is occupied, we need to create an svg representation for the train
	if( this.isOccupied ) {
		this.svgElemGroup = $('<g />').attr('id', this.config.id+"_occupancy");
		 // adding position circle
		this.svgElemPosition = $('<circle />').attr({
			id: 'position',
		    style: window.settings.locomotiveCircleStyle,
		    cx: 0,
		    cy: 0,
		    r: 100.91698
		});
		this.svgElemGroup.append(this.svgElemPosition);

	    // adding svgElement to it parent
	    $('#layer4').append(this.svgElemGroup);
	} else {
		$(this.svgElemGroup).remove();
	}
    
	// calling svg update
    updateDOM();
};

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
    
    // if turnout is occupied, then we need to sign it with a circle
    if( this.isOccupied ) {
    	this.svgElemGroup = $('#layout').find("#"+this.config.id+"_occupancy");
    	this.svgElemPosition = this.svgElemGroup.find('circle');
    	
    	// get the ID of the segment
    	var branch = this.isInStraightPosition() ? "str" : "div";
    	
    	// if we dealing with t3, the identification a little bit more complex...
    	if( this.config.id == "t03" ) {
    		var part = this.senseID == 25 ? "t03a-str-3" : "t03b-str-0";
    		branch = this.isInStraightPosition()? part : "t03-div";
    	} else {
    		branch = this.config.id+"-"+branch;
    	}
        // and set the group on the segment
        var position = getCoordinatesOfSegment(branch, 0.5);
        
        console.log(branch, position);
        var x = position[0] - this.svgElemPosition.attr('cx');
        var y = position[1] - this.svgElemPosition.attr('cy');
        
        // translate group to this point
        this.svgElemGroup.attr('transform', 'translate(' + x + ',' + y + ')');
    }
    
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


