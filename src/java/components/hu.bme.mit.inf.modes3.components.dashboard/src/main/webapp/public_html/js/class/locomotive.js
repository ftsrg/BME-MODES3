/**
 * 
 * @param {LocomotiveController} locomotive
 * @returns {undefined}
 */
function LocomotiveController(locomotiveConfig, controller) {
    // setting up instance variables
    this.config = locomotiveConfig;
    this.speed = 0;
    this.currentSegment = null;
    this.isAnimationInProgress = false;
    this.controller = controller;
    
    // creating SVG representation from scratch
    //this.createSVGrepresentation();

    // then create DOM in trains list
    this.createDOMrepresentation();

    // then remove the forward and backward arrow
    //setSvgElementOpacity(this.svgElemForward, 0);
    //setSvgElementOpacity(this.svgElemBackward, 0);
}

LocomotiveController.prototype.setSpeed = function (speed) {
    this.speed = speed;

    // changing direction arrows regarding the speed
    if (this.speed < 0) {
        log("Pushing train speed: "+speed);
        this.controller.pushTrainSpeed(this.config.address, Math.abs(speed), 1);

    } else {
    	log("Pushing train speed: "+speed);
        this.controller.pushTrainSpeed(this.config.address, speed, 0);
    }
};

LocomotiveController.prototype.setOnSegment = function (segment, percentage) {
    // getting position from percentage
    var position = getCoordinatesOfSegment(segment.config.id, percentage/100.0);
    var x = position[0] - this.svgElemPosition.attr('cx');
    var y = position[1] - this.svgElemPosition.attr('cy');

    // translate group to this point
    this.svgElemGroup.attr('transform', 'translate(' + x + ',' + y + ')');

    // saving segment id for later usage
    this.currentSegment = segment;
    
};

LocomotiveController.prototype.animateOnSegment = function (segment) {
    // first, set on the segment
    this.setOnSegment(segment, (this.speed < 0));

    // get time based on the current speed and the length of the segment
    this.duration = segment.config.length / Math.abs(this.speed);

    // get the path of the segment
    var segmentElement = $('#layout').find('#' + segment.config.id);
    var segmentPath = segmentElement.attr('d');

    // split path by M 
    var segmentPathParts = segmentPath.toLowerCase().split("m ");
    log("SEGMENT PATHS:", segmentPathParts.length);

    // for every bezier curve, be get the coordinates
    for (var s in segmentPathParts) {
        log(segmentPathParts[s]);
        var pattr = /([0-9\-\.]{1,}),([0-9\-\.]{1,}) c ([0-9\-\.]{1,}),([0-9\-\.]{1,}) ([0-9\-\.]{1,}),([0-9\-\.]{1,}) ([0-9\-\.]{1,}),([0-9\-\.]{1,})/i;
    }
//    log(segmentPathParts[1]);


    this.svgElemPosition.animate(
            {
                width: '100%'
            },
            {
                duration: this.duration * 1000,
                step: function (now, fx) {
//                    log("NOW:");
//                    log(now);
//                    log("FX:");
//                    log(fx);
                }
            });

//    log(segmentPath);
//    
//    return;
//    
//    // saving segment id for later usage
//    this.currentSegment = segment;
//
//    // get the path of the segment
//    var segmentElement = $('#layout').find('#' + segment.config.id);
//    var segmentPath = segmentElement.attr('d');
//
//    // need to calculate keypoints for the animation
//    var keyPointsArr = this.getKeyPoints();
//
//    // get time based on the current speed and the length of the segment
//    this.duration = segment.config.length / Math.abs(this.speed);
//
//    // otherwise we create the whole animation from scratch
//    this.isAnimationInProgress = true;
//
//    // first remove any animateMotion element and transform attr from group
//    this.svgElemGroup.find('animateMotion').remove();
//    this.svgElemGroup.removeAttr('transform');
//
//    // create animateMotion object inside the group to animate each object
//    // simultanously 
//    var animObjectStub = $(document.createElementNS("http://www.w3.org/2000/svg", "animateMotion"));
//    animObjectStub.attr({
//        dur: this.duration + "s",
//        begin: '0s',
//        fill: 'freeze',
//        path: segmentPath,
//        keyPoints: keyPointsArr.join(";"),
//        keyTimes: "0;0;1",
//        calcMode: "linear"
//    });
//    
////    animObjectStub.clone().appendTo(this.svgElemPosition);
//
//    this.svgElemPosition.append(animObjectStub.clone().attr('rotate', 'auto'));
//    this.svgElemForward.append(animObjectStub.clone().attr('rotate', 'auto'));
//    this.svgElemBackward.append(animObjectStub.clone().attr('rotate', 'auto'));
//    this.svgElemName.append(animObjectStub.clone());
//    this.svgElemPath.append(animObjectStub.clone());
////    $("#layout").attr('animation', 'true');
//    updateDOM($(this.svgElemGroup).parent().parent());

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
    return null;

    // current segment and speed predestinate which segment will be next
    var nextSegment = this.currentSegment.config.connections[this.speed < 0 ? 0 : 1];
    this.isAnimationInProgress = false;

    // find segment in segments array
    for (var s in window.segments) {
        if (window.segments[s].config.id === nextSegment) {
            return window.segments[s];
        }
    }

    if ($.inArray(nextSegment, window.settings.turnoutEnds) > -1) {
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
        min: -50,
        max: +50,
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
//    this.svgElemGroup = $('#' + this.config.svgGroup);
//    this.svgElemForward = this.svgElemGroup.find('#forward');
//    this.svgElemBackward = this.svgElemGroup.find('#backward');
//    this.svgElemPosition = this.svgElemGroup.find('#position');
//    this.svgElemName = this.svgElemGroup.find('#name');
//    this.svgElemPath = this.svgElemGroup.find('#pathundertext');
};


