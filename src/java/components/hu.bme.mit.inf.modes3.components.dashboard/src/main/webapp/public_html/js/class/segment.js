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
    this.isOccupied = false;
    
    // first, we don't know the state of the segment
    setTrackElementColor(this.svgElem, window.settings.segment.undefinedStateColor);
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
};

SegmentController.prototype.pushSegmentState = function(segmentState) {
	log("Pushing new segment state for segment "+this.controlKey+", state: "+segmentState);
	this.stateController.pushSegmentState(this.controlKey, segmentState == "ENABLED"? 1 : 0);
};

SegmentController.prototype.setOccupied = function () {
	this.isOccupied = true;
	
	// if segment is occupied, we need to create an svg representation for the train
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
    
	// calling svg update
    updateDOM();
};

SegmentController.prototype.setFree = function () {
	this.isOccupied = false;
	
	$(this.svgElemGroup).remove();

	// calling svg update
    updateDOM();
};

SegmentController.prototype.DOMUpdatedCallback = function () {
    this.svgElem = $('#layout').find("#"+this.config.id);
    
    // if segment is occupied, then we need to sign it with a circle
    if( this.isOccupied ) {
    	this.svgElemGroup = $('#layout').find("#"+this.config.id+"_occupancy");
    	this.svgElemPosition = this.svgElemGroup.find('circle');
    	
        
        // and set the group on the segment
        var position = getCoordinatesOfSegment(this.config.id, 0.5);
        var x = position[0] - this.svgElemPosition.attr('cx');
        var y = position[1] - this.svgElemPosition.attr('cy');
        
        // translate group to this point
        this.svgElemGroup.attr('transform', 'translate(' + x + ',' + y + ')');
    }
	
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
