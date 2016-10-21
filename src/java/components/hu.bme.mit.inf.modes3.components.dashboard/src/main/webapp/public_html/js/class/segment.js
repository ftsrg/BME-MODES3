/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Section Controller Class
 * 
 * Section Controller Class instances are mainly responsible for displaying 
 * one section's occupancy and enabled/disabled status on screen.
 * 
 */

function SegmentController(segmentConfig, stateController, controlKey) {
    // setting up instance variables
    this.config = segmentConfig;
    this.svgElem = $('#layout').find("#"+this.config.id);
    this.controlKey = controlKey;
    this.stateController = stateController;
    
    // first, we don't know the state of the segment
    setTrackElementColor(this.svgElem, window.settings.segment.undefinedStateColor);
    
    // no need for initializing sequence, everything need to done in dom updated
    // callback to be sure its active every time
};

SegmentController.prototype.setSegmentState = function(segmentState) {
	log("segment state value: "+segmentState);
	this.isSegmentEnabled = segmentState == "ENABLED";
	
	if( this.isSegmentEnabled ) {
		setTrackElementColor(this.svgElem, window.settings.segment.activeColor);
	    logEvent("Segment #" + this.config.id + " enabled");
	} else {
		setTrackElementColor(this.svgElem, window.settings.segment.inactiveColor);
	    logEvent("Segment #" + this.config.id + " disabled");
	}
}

SegmentController.prototype.pushSegmentState = function(segmentState) {
	log("Pushing new segment state for segment "+this.controlKey+", state: "+segmentState);
	this.stateController.pushSegmentState(this.controlKey, segmentState == "ENABLED"? 1 : 0);
}

SegmentController.prototype.setOccupied = function () {
    // TODO
}

SegmentController.prototype.setFree = function () {
    // TODO
}

SegmentController.prototype.DOMUpdatedCallback = function () {
    this.svgElem = $('#layout').find("#"+this.config.id);
    
    // add event handler for element
    this.svgElem.bind('click', {_this: this}, function (event) {
        if (event.data._this.isSegmentEnabled) {
            // send state control message over transport layer
        	event.data._this.pushSegmentState("DISABLED");
        } else {
            // send state control message over transport layer
        	event.data._this.pushSegmentState("ENABLED");
        }
    });
    
    // add control class to have pointer cursor over element
    this.svgElem.addClass("control");
};
