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

function SegmentController(segmentConfig) {
    // setting up instance variables
    this.config = segmentConfig;
    this.svgElem = $('#layout').find("#"+this.config.id);
    
    // first, we dont know the state of the segment
    setTrackElementColor(this.svgElem, window.settings.segment.undefinedStateColor);
    
    // no need for initializing sequence, everything need to done in dom updated
    // callback to be sure its active everytime

};

SegmentController.prototype.setSegmentEnabled = function () {
    setTrackElementColor(this.svgElem, window.settings.segment.activeColor);
    this.isSegmentEnabled = true;
    log("Segment #" + this.config.id + " enabled");
};

SegmentController.prototype.setSegmentDisabled = function () {
    setTrackElementColor(this.svgElem, window.settings.segment.inactiveColor);
    this.isSegmentEnabled = false;
    log("Segment #" + this.config.id + " disabled");
};

SegmentController.prototype.DOMUpdatedCallback = function () {
    this.svgElem = $('#layout').find("#"+this.config.id);
    
    // add event handler for element
    this.svgElem.bind('click', {_this: this}, function (event) {
        if (event.data._this.isSegmentEnabled) {
            event.data._this.setSegmentDisabled();
        } else {
            event.data._this.setSegmentEnabled();
        }
    });
    
    // add control class to have pointer cursor over element
    this.svgElem.addClass("control");
};
