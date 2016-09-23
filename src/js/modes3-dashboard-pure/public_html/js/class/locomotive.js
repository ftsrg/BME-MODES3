/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function LocomotiveController(locomotiveConfig) {
    // setting up instance variables
    this.config = locomotiveConfig;
    this.speed = 0;
    this.currentSegment = null;
    this.isAnimationInProgress = false;

    // creating SVG representation from scratch
    this.createSVGrepresentation();

    // then create DOM in trains list
    this.createDOMrepresentation();

    // then remove the forward and backward arrow
    setSvgElementOpacity(this.svgElemForward, 0);
    setSvgElementOpacity(this.svgElemBackward, 0);
}
;

LocomotiveController.prototype.setSpeed = function (speed) {
    this.indicatorElem.text(speed);
    this.speed = speed;

    // changing direction arrows regarding the speed
    if (this.speed < 0) {
        setSvgElementOpacity(this.svgElemForward, 0);
        setSvgElementOpacity(this.svgElemBackward, 1);

        // if segment setted correctly, then we could animate as well
        if (this.currentSegment !== null) {
            this.animateOnSegment(this.currentSegment);
        }

    } else {
        // locomotive will be go forward
        setSvgElementOpacity(this.svgElemForward, 1);
        setSvgElementOpacity(this.svgElemBackward, 0);

        // if segment setted correctly, then we could animate as well
        if (this.currentSegment !== null) {
            this.animateOnSegment(this.currentSegment);
        }
    }

    // for now, we set a timeout for getNextSegment
    setTimeout(dummy_setLocomotiveOnNextSegment, this.duration * 1000);

};

LocomotiveController.prototype.setOnSegment = function (segment, reverse) {

    // first, get the path of the section
    var segmentElement = $('#layout').find('#' + segment.config.id);

    // if path is found, then the first two coordinates will be the starting point,
    // and the last two coordinates will be the ending point of the segment
    var startPoint = /m ([\-0-9.]{1,}),([\-0-9.]{1,})/i.exec(segmentElement.attr('d'));
    var endPoint = /([\-0-9.]{1,}),([\-0-9.]{1,})$/i.exec(segmentElement.attr('d'));

    // in result, there will be 3 item: the whole string which is applies to the 
    // expression, and the two other item will be the two coordinate respectively
    if (reverse === false && startPoint.length > 1) {
        // translate position with the center point of the position element
        var x = startPoint[1] - this.svgElemPosition.attr('cx');
        var y = startPoint[2] - this.svgElemPosition.attr('cy');

        // translate group to this point
        this.svgElemGroup.attr('transform', 'translate(' + x + ',' + y + ')');

        // saving segment id for later usage
        this.currentSegment = segment;
    }

    if (reverse === true && endPoint.length > 1) {
        // translate position with the center point of the position element
        var x = endPoint[1] - this.svgElemPosition.attr('cx');
        var y = endPoint[2] - this.svgElemPosition.attr('cy');

        // translate group to this point
        this.svgElemGroup.attr('transform', 'translate(' + x + ',' + y + ')');

        // saving segment id for later usage
        this.currentSegment = segment;
    }
};

LocomotiveController.prototype.animateOnSegment = function (segment) {
    // saving segment id for later usage
    this.currentSegment = segment;

    // get the path of the segment
    var segmentElement = $('#layout').find('#' + segment.config.id);
    var segmentPath = segmentElement.attr('d');

    // keypoints predefined to 0 0 1 which will mean that the whole animation
    // if there is no animation is progress yet will start at 0
    var keyPointsArr = [0, 0, 1];

    // if there is a previously inserted animation, then we need to calculate
    // keypoints too
    if (this.isAnimationInProgress) {
        // we need to calculate the keypoints based on ellapsed time
        var elapsed = new Date().getTime() - this.timestamp;
        var startFrom = elapsed / (this.duration * 1000);
        keyPointsArr[1] = startFrom;
    }

    // if speed is negative, then the animation needs to move backwards
    if (this.speed < 0) {
        keyPointsArr[0] = 1;
        keyPointsArr[1] = 1 - keyPointsArr[1];
        keyPointsArr[2] = 0;
    }

    // get time based on the current speed and the length of the segment
    this.duration = segment.config.length / Math.abs(this.speed);

    // otherwise we create the whole animation from scratch
    this.isAnimationInProgress = true;

    // first remove any animateMotion element from group
    this.svgElemGroup.find('animateMotion').remove();

    var coordinate_pattr = /m ([0-9.]{1,}),([0-9.]{1,})/i;

    // if path is found, then the first two coordinates will be the starting point of the segment
    var result = coordinate_pattr.exec(segmentPath);

    // in result, there will be 3 item: the whole string which is applies to the 
    // expression, and the two other item will be the two coordinate respectively
    if (result.length <= 1) {
        return;
    }

    this.svgElemGroup.removeAttr('transform');

    // create animateMotion object inside the group to animate each object
    // simultanously 
    var animObject = $('<animateMotion />').attr({
        dur: this.duration + "s",
        begin: '0s',
        fill: 'freeze',
        path: segmentPath,
        keyPoints: keyPointsArr.join(";"),
        keyTimes: "0; 0; 1",
        calcMode: "linear"
    });

    this.svgElemPosition.append(animObject.clone().attr('rotate', 'auto'));
    this.svgElemForward.append(animObject.clone().attr('rotate', 'auto'));
    this.svgElemBackward.append(animObject.clone().attr('rotate', 'auto'));
    this.svgElemName.append(animObject.clone());
    this.svgElemPath.append(animObject.clone());
    updateDOM();

    // in this point, we save the current timestamp for later usage
    this.timestamp = new Date().getTime();

    // then animate viewbox modification (if needed)
    switch (segment.config.id) {
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
            resizeLayout(9658);
            break;

        case "s24":
            resizeLayout(9258);
            break;

        default:
            resizeLayout(8858);
            break;

    }
};

LocomotiveController.prototype.getNextSegment = function () {
    // current segment and speed predestinate which segment will be next
    var nextSegment = this.currentSegment.config.connections[this.speed < 0 ? 0 : 1];
    this.isAnimationInProgress = false;

    // find segment in segments array
    for (var s in window.segments) {
        if (window.segments[s].config.id === nextSegment) {
            return window.segments[s];
        }
    }
    
    if( $.inArray(nextSegment, window.settings.turnoutEnds) > -1 ) {
        var turnoutEnd = nextSegment.split("-")[0];

        // find turnout in turnouts array
        for (var t in window.turnouts) {
            var turnout = window.turnouts[t];
            if (turnout.config.id === turnoutEnd) {
                
                var nSegment = null;
                
                // if we found the right turnout, then based on it's state,
                // we steer the locomotive on the right path
                if (turnout.isInStraightPosition()) {
                    nSegment = cloneObject(turnout.config.str);
                    
                } else {
                    nSegment = cloneObject(turnout.config.div);
                }
                
                return {config: nSegment};
            }
        }
    }

    return null;
}

LocomotiveController.prototype.createSVGrepresentation = function () {

    // first, create group element
    this.svgElemGroup = $('<g />').attr('id', this.config.svgGroup);


    // then add forward path
    this.svgElemForward = $('<path />').attr({
        id: 'backward',
        style: window.settings.locomotiveArrowStyle,
        d: 'm 0,0 -59.605,0.1892 -285.263,100.88768 285.7614,100.9181 59.7037,0.1522 z',
        transform: 'translate(-50,-100.91698)'
    });
    this.svgElemGroup.append(this.svgElemForward);

    // adding backward path
    this.svgElemBackward = $('<path />').attr({
        id: 'forward',
        style: window.settings.locomotiveArrowStyle,
        d: 'm 0,0 59.605,0.1892 285.263,100.88768 -285.7614,100.9181 -59.7037,0.1522 z',
        transform: 'translate(50,-100.91698)'
    });
    this.svgElemGroup.append(this.svgElemBackward);

    // adding position circle
    this.svgElemPosition = $('<circle />').attr({
        id: 'position',
        style: window.settings.locomotiveCircleStyle,
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
        style: window.settings.locomotiveTextStyle
    }).text(this.config.name);
    this.svgElemGroup.append(this.svgElemName);

    // and path element under text as well
    this.svgElemPath = $('<path />').attr({
        id: 'pathundertext',
        style: window.settings.locomotiveTextPathStyle,
        d: "m 0,0 -0.1046,-109.4159 121.2882,-93.673 1220.9691,0"
    }).text(this.config.name);
    this.svgElemGroup.append(this.svgElemPath);

    // adding svgElement to it parent
    $('#layer4').append(this.svgElemGroup);
};

LocomotiveController.prototype.createDOMrepresentation = function () {
    var container = $('<div />').addClass('train-container');
    var header = $('<h2 />').text(this.config.name);
    var image = $('<img />')
            .attr('src', 'images/locomotives/' + this.config.image);
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
};

LocomotiveController.prototype.DOMUpdatedCallback = function () {
    // after doom refresh, we lost every object here, so query all of them again
    this.svgElemGroup = $('#' + this.config.svgGroup);
    this.svgElemForward = this.svgElemGroup.find('#forward');
    this.svgElemBackward = this.svgElemGroup.find('#backward');
    this.svgElemPosition = this.svgElemGroup.find('#position');
    this.svgElemName = this.svgElemGroup.find('#name');
    this.svgElemPath = this.svgElemGroup.find('#pathundertext');

    // add event handler for element
    this.svgElemPosition.bind('click', {_this: this}, function (event) {
        clearTimeout(window.timeout);
    });
};


