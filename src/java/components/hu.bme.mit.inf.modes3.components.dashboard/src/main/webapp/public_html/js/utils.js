/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function zeroPad(num, places) {
    var zero = places - num.toString().length + 1;
    return Array(+(zero > 0 && zero)).join("0") + num;
}

function setTrackElementColor(elem, color) {
    s = elem.attr('style');
    var sPatt = /stroke:[^;]*/i;
    s = s.replace(sPatt, 'stroke:' + color);
    elem.attr('style', s);
}

function setTurnoutControlElementColor(elem, color) {
    s = elem.attr('style');
    var sPatt = /fill:[^;]*/i;
    s = s.replace(sPatt, 'fill:' + color);
    elem.attr('style', s);
}

function setSvgElementOpacity(elem, opacity) {
    s = elem.attr('style');
    var sPatt = /opacity:[^;]*/i;
    s = s.replace(sPatt, 'opacity:' + opacity);
    elem.attr('style', s);
}

function logEvent() {
//    for( var arg in arguments) {
//        log(arguments[arg]);
//    }
}

function log() {
    if (arguments.length === 1) {
        console.log(arguments[0]);
        return;
    }

    s = "";
    for (var i = 0; i < arguments.length; i++) {
        s += " " + arguments[i];
    }
    console.log(s);
}

$.fn.xml = function () {
    return (new XMLSerializer()).serializeToString(this[0]);
};

$.fn.DOMRefresh = function () {
    return $($(this.xml()).replaceAll(this));
};

function resizeLayout(width) {
    $('#layout').animate({width: '100%'}, {
        duration: 3000,
        step: function (now, fx) {
            if (settings.viewBox[2] < width) {
                settings.viewBox[2] = settings.viewBox[2] + 10;
                $('#layout').attr('viewBox', settings.viewBox[0] + ' ' + settings.viewBox[1] + ' ' + settings.viewBox[2] + ' ' + settings.viewBox[3]);
            } else if (settings.viewBox[2] > width) {
                settings.viewBox[2] = settings.viewBox[2] - 10;
                $('#layout').attr('viewBox', settings.viewBox[0] + ' ' + settings.viewBox[1] + ' ' + settings.viewBox[2] + ' ' + settings.viewBox[3]);
            }
        }
    });
}

function cloneObject(object) {
    var newObj = (object instanceof Array) ? [] : {};
    for (var i in object) {
        if (object[i] && typeof object[i] == "object") {
            newObj[i] = cloneObject(object[i]);
        } else
            newObj[i] = object[i]
    }
    return newObj;
}

function updateDOM() {
    if (arguments.length === 0) {
        $("#layout").DOMRefresh();
    } else {
        log(arguments[0]);
        $(arguments[0]).DOMRefresh();
    }

    // call callback for every locomotive object
    for (var l in window.locomotives) {
        window.locomotives[l].DOMUpdatedCallback();
    }

    // call callback for every segment object
    for (var s in window.segments) {
        window.segments[s].DOMUpdatedCallback();
    }

    // call callback for every segment object
    for (var t in window.turnouts) {
        window.turnouts[t].DOMUpdatedCallback();
    }
}

function getCoordinatesOfSegment(segmentID, t) {
    var segmentElement = $('#layout').find('#' + segmentID);
    var segmentPath = segmentElement.attr('d');
    log(segmentPath);

    // split path by M 
    var segmentPathParts = segmentPath.toLowerCase().split("m ");

    /**
     * Paths are constructed as follows:
     * Defining first the starting point: M x,y
     * Then defining bezier curve: C x1,y1 x2,y2, x,y
     * bezier curve starts on current pen position, ends in x,y
     * and the two control point's coordinates are x1,y1
     */
    var pattr = /([0-9\-\.]{1,}),([0-9\-\.]{1,}) c ([0-9\-\.]{1,}),([0-9\-\.]{1,}) ([0-9\-\.]{1,}),([0-9\-\.]{1,}) ([0-9\-\.]{1,}),([0-9\-\.]{1,})/i;

    // should be only 1 bezier curve!
    var results = null;

    // for every bezier curve, be get the coordinates
    for (var s in segmentPathParts) {

        // sometimes we get 1 or 2 whitespace character as a segmentpart, 
        // we should skip them
        if (segmentPathParts[s].length < 3) {
            continue;
        }

        // if first curve found, then immediatelly break loop
        results = pattr.exec(segmentPathParts[s]);
        break;
    }

    // getting control points from results
    var P_0 = [results[1], results[2]];
    var P_1 = [results[3], results[4]];
    var P_2 = [results[5], results[6]];
    var P_3 = [results[7], results[8]];

    /**
     * Bezier curves explicit formula
     * B(t) = (1-t)^3 * P_0 + 3*(1-t)^2*t*P_1 + 3*(1-t)*t^2*P_2 + t^3*P_3
     */

    function bezier(i, t) {
        return Math.pow(1 - t, 3) * P_0[i] + 3 * Math.pow(1 - t, 2) * t * P_1[i]
                + 3 * (1 - t) * Math.pow(t, 2) * P_2[i] + Math.pow(t, 3) * P_3[i];
    }

    return [bezier(0, t), bezier(1, t)];
}

function createTrainSpeedData(tId, s, d) {
	var jsonData = {};
	jsonData['trainID'] = tId;
	jsonData['referenceSpeed'] = s;
	jsonData['direction'] = d;
	return jsonData;
}

function createSegmentStateData(sId, sState) {
	var jsonData = {};
	jsonData['segmentID'] = sId;
	jsonData['state'] = sState;
	return jsonData;
}

function createTurnoutStateData(tId, tState) {
	var jsonData = {};
	jsonData['turnoutID'] = tId;
	jsonData['state'] = tState;
	return jsonData;
}
