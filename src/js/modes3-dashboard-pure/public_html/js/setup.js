/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

color = "#F00"

function test() {
    s = $('#layout').find("#s30").attr('style');

    var sPatt = /stroke:[^;]*/i;

    s = s.replace(sPatt, 'stroke:' + color);

    if (color === "#F00") {
        color = "#1e2141";
    } else {
        color = "#F00";
    }
    $('#layout').find('#s30').attr('style', s);
    setTimeout(test, 500);
}

setTimeout(test, 500);


