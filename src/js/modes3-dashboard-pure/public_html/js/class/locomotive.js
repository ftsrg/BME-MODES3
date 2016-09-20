/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function LocomotiveControllerClass(locomotiveSettings) {
    // setting up instance variables
    this.groupID = locomotiveSettings.svgGroup;
    this.name = locomotiveSettings.name;

    // creating SVG representation from scratch
    this.createSVGrepresentation(locomotiveSettings);

    // then create DOM in trains list
    this.createDOMrepresentation(locomotiveSettings);

    // then remove the forward and backward arrow
    setSvgElementOpacity(this.svgElemForward, 0);
    setSvgElementOpacity(this.svgElemBackward, 0);

//    this.setOnSegment(1);
//    this.animateOnSegment(1);
}

LocomotiveControllerClass.prototype.setSpeed = function (speed) {
    this.indicatorElem.text(speed);
}

LocomotiveControllerClass.prototype.setOnSegment = function (sectionID) {

    // first, get the path of the section
    segment = $('#layout').find('#'+sectionID);
    orig_path = segment.attr('d');

    // if path is found, then the first two coordinates will be the starting point of the segment
    var result = /m ([0-9.]{1,}),([0-9.]{1,})/i.exec(orig_path);

    // in result, there will be 3 item: the whole string which is applies to the 
    // expression, and the two other item will be the two coordinate respectively
    if (result.length > 1) {
        // translate position with the center point of the position element
        var x = result[1] - this.svgElemPosition.attr('cx');
        var y = result[2] - this.svgElemPosition.attr('cy');

        // translate group to this point
        this.svgElemGroup.attr('transform', 'translate(' + x + ',' + y + ')');
    }
}

LocomotiveControllerClass.prototype.animateOnSegment = function (sectionID) {
    // first remove any animateMotion element from group
    this.svgElemGroup.remove('animateMotion');
    
    setSvgElementOpacity(this.svgElemBackward, 1);
    setSvgElementOpacity(this.svgElemForward, 0);

    // get the path of the segment
    segment = $('#layout').find('#'+sectionID);
    orig_path = segment.attr('d');
    
    // get length of the segment
//    var segmentLen = segment.getTotalLength();

    var coordinate_pattr = /m ([0-9.]{1,}),([0-9.]{1,})/i;

    // if path is found, then the first two coordinates will be the starting point of the segment
    var result = /m ([0-9.]{1,}),([0-9.]{1,})/i.exec(orig_path);

    // in result, there will be 3 item: the whole string which is applies to the 
    // expression, and the two other item will be the two coordinate respectively
    if (result.length > 1) {
        // translate position with the center point of the position element
        var x = result[1] - this.svgElemPosition.attr('cx');
        var y = result[2] - this.svgElemPosition.attr('cy');

        path = orig_path.replace(coordinate_pattr, "m " + x + "," + y);

        this.svgElemGroup.removeAttr('transform');

        // create animateMotion object inside the group to animate group along the path
        var animObject = $('<animateMotion />').attr({
            dur: '3s',
            begin: '0s',
            fill: 'freeze',
            path: path,
            rotate: 'auto'
        });

        var animObject1 = $('<animateMotion />').attr({
            dur: '3s',
            begin: '0s',
            fill: 'freeze',
            path: orig_path,
            rotate: 'auto'
        });

        var animObject2 = $('<animateMotion />').attr({
            dur: '3s',
            begin: '0s',
            fill: 'freeze',
            path: orig_path,
            rotate: 'auto'
        });

        var animObject3 = $('<animateMotion />').attr({
            dur: '3s',
            begin: '0s',
            fill: 'freeze',
            path: path
        });

        var animObject4 = $('<animateMotion />').attr({
            dur: '3s',
            begin: '0s',
            fill: 'freeze',
            path: path
        });

        this.svgElemPosition.append(animObject);
        this.svgElemForward.append(animObject1);
        this.svgElemBackward.append(animObject2);
        this.svgElemName.append(animObject3);
        this.svgElemPath.append(animObject4);
        this.updateDOM();


        // then animate viewbox modification (if needed)
        switch (sectionID) {
            case "s26":
            case "s27":
                resizeLayout(9058);
                break;
                
            case "s31":
            case "s29":
            case "t02-str":
            case "t02-div":
                resizeLayout(9858);
                break;
                
            case "s30":
            case "s24":
                resizeLayout(9258);
                break;
                
            default:
                resizeLayout(8858);
                break;

        }
    }


}

LocomotiveControllerClass.prototype.createSVGrepresentation = function (locomotiveSettings) {

    // first, create group element
    this.svgElemGroup = $('<g />').attr('id', this.groupID);


    // then add forward path
    this.svgElemForward = $('<path />').attr({
        id: 'forward',
        style: settings.locomotiveArrowStyle,
        d: 'm 0,0 -59.605,0.1892 -285.263,100.88768 285.7614,100.9181 59.7037,0.1522 z',
        transform: 'translate(-50,-100.91698)'
    });
    this.svgElemGroup.append(this.svgElemForward);

    // adding backward path
    this.svgElemBackward = $('<path />').attr({
        id: 'backward',
        style: settings.locomotiveArrowStyle,
        d: 'm 0,0 59.605,0.1892 285.263,100.88768 -285.7614,100.9181 -59.7037,0.1522 z',
        transform: 'translate(50,-100.91698)'
    });
    this.svgElemGroup.append(this.svgElemBackward);

    // adding position circle
    this.svgElemPosition = $('<circle />').attr({
        id: 'position',
        style: settings.locomotiveCircleStyle,
        cx: 0,
        cy: 0,
        r: 100.91698
    });
    this.svgElemGroup.append(this.svgElemPosition);

    // add the text element
    this.svgElemName = $('<text />').attr({
        id: 'name',
        x: 100,
        y: -240,
        style: settings.locomotiveTextStyle
    }).text(locomotiveSettings.name);
    this.svgElemGroup.append(this.svgElemName);

    // and path element under text as well
    this.svgElemPath = $('<path />').attr({
        id: 'pathundertext',
        style: settings.locomotiveTextPathStyle,
        d: "m 0,0 -0.1046,-109.4159 121.2882,-93.673 1220.9691,0"
    }).text(locomotiveSettings.name);
    this.svgElemGroup.append(this.svgElemPath);

    // adding svgElement to it parent
    $('#layer4').append(this.svgElemGroup);
    this.updateDOM();
}

LocomotiveControllerClass.prototype.createDOMrepresentation = function (locomotiveSettings) {
    var container = $('<div />').addClass('train-container');
    var header = $('<h2 />').text(this.name);
    var image = $('<img />')
            .attr('src', 'images/locomotives/' + locomotiveSettings.image);
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
    image.wrap($('<div />').addClass('train-control-image'));
    input.wrap($('<div />').addClass('train-control-speed-input'));
    $('#train-control').append(container);


    // add event handler for range input
    input.bind('change', {_this: this}, function (event) {
        event.data._this.setSpeed($(this).val());
    });
    input.bind('mousemove', {_this: this}, function (event) {
        event.data._this.indicatorElem.text($(this).val());
    });
}

LocomotiveControllerClass.prototype.updateDOM = function () {
    $("#layout").DOMRefresh();

    // after doom refresh, we lost every object here, so query all of them again
    this.svgElemGroup = $('#' + this.groupID);
    this.svgElemForward = this.svgElemGroup.find('#forward');
    this.svgElemBackward = this.svgElemGroup.find('#backward');
    this.svgElemPosition = this.svgElemGroup.find('#position');
    this.svgElemName = this.svgElemGroup.find('#name');
    this.svgElemPath = this.svgElemGroup.find('#pathundertext');
}


