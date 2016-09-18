/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function LocomotiveControllerClass(locomotiveSettings) {
    // setting up instance variables
    this.groupID = locomotiveSettings.svgGroup;
    this.name = locomotiveSettings.name;
    
//    this.svgElemGroup = $('#layout').find('#l'+zeroPad(this.groupID, 2));
//
//    this.svgElemForwardArrow = this.svgElemGroup.find('#forwards');
//    this.svgElemBackwardArrow = this.svgElemGroup.find('#backwards');
//    this.svgElemTitle = this.svgElemGroup.find('#name');
//    this.svgElemDot = this.svgElemGroup.find('#position');
//    
//    // first, setup the name of the locomotive and the arrows
//    this.svgElemTitle.text(name);
    
    // then create DOM in trains list
    var container = $('<div />').addClass('train-container');
    var header = $('<h2 />').text(this.name);
    var image = $('<img />')
            .attr('src', 'images/locomotives/'+locomotiveSettings.image);
    var input = $('<input />').attr({
        type: 'range',
        min: -128,
        max: +128,
        value: 0
    });
    this.indicatorElem = $('<div />').addClass('train-control-speed-indicator').text('0');
    var controls = $('<div />').addClass('train-control-speed')
            .append(input).append(this.indicatorElem);
    container.append(header).append(image).append(controls);
    image.wrap( $('<div />').addClass('train-control-image') );
    input.wrap( $('<div />').addClass('train-control-speed-input'));
    $('#train-control').append(container);
   

    // add event handler for range input
    input.bind('change', {_this: this}, function(event) {
       event.data._this.setSpeed($(this).val()); 
    });
    input.bind('mousemove', {_this: this}, function(event) {
       event.data._this.indicatorElem.text($(this).val()); 
    });
    
    // then remove the forward and backward arrow
//    setSvgElementOpacity(this.svgElemForwardArrow, 0);
//    setSvgElementOpacity(this.svgElemBackwardArrow, 0);
    
}

LocomotiveControllerClass.prototype.setSpeed = function(speed) {
    this.indicatorElem.text(speed);
}

LocomotiveControllerClass.prototype.setOnSection = function(sectionID) {
    
    // first, get the path of the section
    section = $('#layout').find('#s'+zeroPad(sectionID, 2));
    path = section.attr('d');
    log(path);
    
    
    // transform="translate(1078.943,1435.4286)"
//    this.svgElemGroup.attr('transform', 'translate(1078.943,1435.4286)');
    this.svgElemGroup.attr('transform', 'translate(1373.4324,1237.1495)');
////    // create animateMotion element and add to the group
//    animObj = $('<animateMotion />').attr('path', path).attr('dur', '3s').attr('repeatCount', 'indefinite');
//    log(animObj.prop('outerHTML'));
//    this.svgElemGroup.append(animObj);
//    
//    
//    $("#layout").DOMRefresh();
    
}


