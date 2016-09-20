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

function log() {
    s = "";
    for (var i = 0; i < arguments.length; i++) {
        s += "" + arguments[i];
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
            }
            else if (settings.viewBox[2] > width) {
                settings.viewBox[2] = settings.viewBox[2] - 10;
                $('#layout').attr('viewBox', settings.viewBox[0] + ' ' + settings.viewBox[1] + ' ' + settings.viewBox[2] + ' ' + settings.viewBox[3]);
            }
        }
    });
}
