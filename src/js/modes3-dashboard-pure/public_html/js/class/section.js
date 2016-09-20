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

function SectionControllerClass(sectionSettings) {
    // setting up instance variables
    this.sectionID = sectionSettings.id;
    this.sectionDirection = sectionSettings.direction;
    this.svgElem = $('#layout').find("#s" + zeroPad(this.sectionID, 2));

    // initialy section will be undefined
    setTrackElementColor(this.svgElem, settings.undefinedStateTrackElementColor);

    // add event handler for element
    this.svgElem.bind('click', {_this: this}, function (event) {
        if (event.data._this.isSectionEnabled()) {
            event.data._this.setSectionDisabled();
        } else {
            event.data._this.setSectionEnabled();
        }
    });
    
    // add control class to have pointer cursor over element
    this.svgElem.addClass("control");

}

SectionControllerClass.prototype.setSectionEnabled = function () {
    setTrackElementColor(this.svgElem, settings.activeTrackElementColor);
    this.sectionEnabled = true;
    log("Section #" + this.sectionID + " enabled");
}

SectionControllerClass.prototype.setSectionDisabled = function () {
    setTrackElementColor(this.svgElem, settings.inactiveTrackElementColor);
    this.sectionEnabled = false;
    log("Section #" + this.sectionID + " disabled");
}

SectionControllerClass.prototype.isSectionEnabled = function () {
    return this.sectionEnabled;
}
