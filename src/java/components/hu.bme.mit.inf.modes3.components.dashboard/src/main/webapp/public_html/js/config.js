/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var settings = {
	viewBox : [ 0, 0, 8858, 4960 ],
	segment : {
		activeColor : "#1e2141",
		inactiveColor : "#F44336",
		undefinedStateColor : "#CCCCCC"
	},
	turnout : {
		activeControlColor : "#1e2141",
		inactiveControlColor : "#CCCCCC",
		undefinedControlColor : "#CCCCCC",
		activeBranchOpacity : 1,
		inactiveBranchOpacity : 0
	},
	segments : [
		[ 1, {
			id : "s01",
			length : 442,
			connections : [ "s12", "s02" ],
		} ],
		[ 2, {
			id : "s02",
			length : 453,
			connections : [ "s01", "t04" ],
		} ],
		[ 4, {
			id : "s04",
			length : 548,
			connections : [ "t04-str", "s06" ],
		} ],
		[ 5, {
			id : "s05",
			length : 548,
			connections : [ "t04-div", "s07" ],
		} ],
		[ 6, {
			id : "s06",
			length : 595,
			connections : [ "s04", "s18" ],
		} ],
		[ 7, {
			id : "s07",
			length : 595,
			connections : [ "s05", "s19" ],
		} ],
		[ 8, {
			id : "s08",
			length : 543,
			connections : [ "t05", "s13" ],
		} ],
		[ 10, {
			id : "s10",
			length : 491,
			connections : [ "s17", "t05-div" ],
		} ],
		[ 11, {
			id : "s11",
			length : 686,
			connections : [ "t01-div", "t05-str" ],
		} ],
		[ 12, {
			id : "s12",
			length : 459,
			connections : [ "t01-str", "s01" ],
		} ],
		[ 13, {
			id : "s13",
			length : 590,
			connections : [ "s08", "s20" ],
		} ],
		[ 15, {
			id : "s15",
			length : 526,
			connections : [ "s24", "t01" ],
		} ],
		[ 17, {
			id : "s17",
			length : 481,
			connections : [ "t06", "s10" ],
		} ],
		[ 18, {
			id : "s18",
			length : 655,
			connections : [ "s06", "s31" ],
		} ],
		[ 19, {
			id : "s19",
			length : 522,
			connections : [ "s07", "t03b-str" ],
		} ],
		[ 20, {
			id : "s20",
			length : 292,
			connections : [ "s13", "t03a" ],
		} ],
		[ 22, {
			id : "s22",
			length : 788,
			connections : [ null, "t06-div" ],
		} ],
		[ 23, {
			id : "s23",
			length : 537,
			connections : [ "s27", "t06-str" ],
		} ],
		[ 24, {
			id : "s24",
			length : 584,
			connections : [ "s29", "s15" ],
		} ],
		[ 26, {
			id : "s26",
			length : 515,
			connections : [ "t03a-str", "s27" ],
		} ],
		[ 27, {
			id : "s27",
			length : 503,
			connections : [ "s26", "s23" ],
		} ],
		[ 29, {
			id : "s29",
			length : 547,
			connections : [ "t02", "s24" ],
		} ],
		[ 30, {
			id : "s30",
			length : 442,
			connections : [ "t03b", "t02-div" ],
		} ],
		[ 31, {
			id : "s31",
			length : 549,
			connections : [ "s18", "t02-str" ],
		} ]
	],
	turnouts : [
		[ 1, {
			id : "t01",
			senseID: [14],
			
			div : {
				id : "t01-div",
				length : 237,
				connections : [ "s15", "s11" ]
			},

			str : {
				id : "t01-str",
				length : 239,
				connections : [ "s15", "s12" ]
			}
		}],
		[ 2, {
			id : "t02",
			senseID: [28],
			
			div : {
				id : "t02-div",
				length : 220,
				connections : [ "s30", "s29" ]
			},

			str : {
				id : "t02-str",
				length : 284,
				connections : [ "s31", "s29" ]
			}
		}],
		[ 3, {
			id : "t03",
			senseID: [25, 32],
			
			div : {
				id : "t03-div",
				length : 237,
				connections : [ "s20", "t03b-div" ]
			},

			str : {
				id : "t03-str",
				length : 239,
				connections : [ "s20", "s26" ]
			}
		}],
//		[ 3, {
//			id : "t03a",
//
//			div : {
//				id : "t03a-div",
//				length : 237,
//				connections : [ "s20", "t03b-div" ]
//			},
//
//			str : {
//				id : "t03a-str",
//				length : 239,
//				connections : [ "s20", "s26" ]
//			}
//		}],
//		[ 4, {
//			id : "t03b",
//
//			div : {
//				id : "t03b-div",
//				length : 237,
//				connections : [ "t03a-div", "s30" ]
//			},
//
//			str : {
//				id : "t03b-str",
//				length : 239,
//				connections : [ "s19", "s30" ]
//			}
//		}],
		[ 4, {
			id : "t04",
			senseID: [3],

			div : {
				id : "t04-div",
				length : 220,
				connections : [ "s02", "s05" ]
			},

			str : {
				id : "t04-str",
				length : 284,
				connections : [ "s02", "s04" ]
			}
		}],
		[ 5, {
			id : "t05",
			senseID: [9],

			div : {
				id : "t05-div",
				length : 220,
				connections : [ "s10", "s08" ]
			},

			str : {
				id : "t05-str",
				length : 284,
				connections : [ "s11", "s08" ]
			}
		}],
		[ 6, {
			id : "t06",
			senseID: [21],

			div : {
				id : "t06-div",
				length : 237,
				connections : [ "s22", "s17" ]
			},

			str : {
				id : "t06-str",
				length : 239,
				connections : [ "s23", "s17" ]
			}
		}],
	],
	turnoutEnds : [
		"t01", "t01-div", "t01-str",
		"t02", "t02-div", "t02-str",
		"t03a", "t03a-div", "t03a-str",
		"t03b", "t03b-div", "t03b-str",
		"t04", "t04-div", "t04-str",
		"t05", "t05-div", "t05-str",
		"t06", "t06-div", "t06-str"
	],
	locomotives : [
	
	//ide sok vonat
		[ 9, {
			name : "Taurus MÁV 1047",
			address : 9,
			image : "taurus-mav-1047.jpg",
			preview: "taurus-mav-1047-preview.png",
			svgGroup : "taurus",
		}],
		
		[ 10, {
			name : "SNCF 68000",
			address : 10,
			image : "sncf-68000.jpg",
			preview: "sncf-68000-preview.jpg",
			svgGroup : 2,
		}],
		
		[ 11, {
	        name: "BR-204",
	        address: 11,
	        image: "br-204.jpg",
			preview: "br-204-preview-2.jpg",
	        svgGroup: 3
	    }],
		
		[ 12, {
			name : "NOHAB MÁV M61 #1",
			address : 12,
			image : "nohab.jpg",
			preview: "nohab-preview.jpg",
			svgGroup : "nohab",
		}],
		
		[ 13, {
			name : "Siemens Desiro",
			address : 13,
			image : "vagottdesiro.jpg",
			preview: "desiro-preview.jpg",
			svgGroup : "desiro2",
		}],
		
		[ 14, {
			name : "MÁV V43",
			address : 14,
			image : "szili.jpg",
			preview: "szili-preview.jpg",
			svgGroup : "szili",
		}],
		
		[ 15, {
			name : "NOHAB MÁV M61 #2",
			address : 15,
			image : "nohab.jpg",
			preview: "nohab-preview.jpg",
			svgGroup : "nohab",
		}],
		
		[ 16, {
			name : "NOHAB MÁV M61 #3",
			address : 16,
			image : "nohab.jpg",
			preview: "nohab-preview.jpg",
			svgGroup : "nohab",
		}],
		[ 17, {
			name : "NOHAB MÁV M61 #4",
			address : 17,
			image : "nohab.jpg",
			preview: "nohab-preview.jpg",
			svgGroup : "nohab",
		}],
		[ 18, {
			name : "NOHAB MÁV M61 #5",
			address : 18,
			image : "nohab.jpg",
			preview: "nohab-preview.jpg",
			svgGroup : "nohab",
		}],
		[ 19, {
			name : "NOHAB MÁV M61 #6",
			address : 19,
			image : "nohab.jpg",
			preview: "nohab-preview.jpg",
			svgGroup : "nohab",
		}],
		[ 20, {
			name : "NOHAB MÁV M61 #7",
			address : 20,
			image : "nohab.jpg",
			preview: "nohab-preview.jpg",
			svgGroup : "nohab",
		}]
	],
	locomotiveArrowStyle : 'color:#000000;clip-rule:nonzero;display:inline;overflow:visible;visibility:visible;opacity:1;isolation:auto;mix-blend-mode:normal;color-interpolation:sRGB;color-interpolation-filters:linearRGB;solid-color:#000000;solid-opacity:1;fill:#1e2141;fill-opacity:1;fill-rule:evenodd;stroke:#ffffff;stroke-width:21.25984192;stroke-linecap:butt;stroke-linejoin:miter;stroke-miterlimit:4;stroke-dasharray:none;stroke-dashoffset:0;stroke-opacity:1;color-rendering:auto;image-rendering:auto;shape-rendering:auto;text-rendering:auto;enable-background:accumulate',
	locomotiveCircleStyle : 'color:#000000;clip-rule:nonzero;display:inline;overflow:visible;visibility:visible;opacity:1;isolation:auto;mix-blend-mode:normal;color-interpolation:sRGB;color-interpolation-filters:linearRGB;solid-color:#000000;solid-opacity:1;fill:#1e2141;fill-opacity:1;fill-rule:nonzero;stroke:#ffffff;stroke-width:31.88976288;stroke-linecap:square;stroke-linejoin:miter;stroke-miterlimit:4;stroke-dasharray:none;stroke-dashoffset:0;stroke-opacity:1;color-rendering:auto;image-rendering:auto;shape-rendering:auto;text-rendering:auto;enable-background:accumulate',
	locomotiveTextStyle : "font-style:normal;font-variant:normal;font-weight:300;font-stretch:normal;font-size:150px;line-height:125%;font-family:Roboto;-inkscape-font-specification:'Roboto, Light';text-align:start;letter-spacing:0px;word-spacing:0px;writing-mode:lr-tb;text-anchor:start;display:inline;fill:#000000;fill-opacity:1;stroke:none;stroke-width:1px;stroke-linecap:butt;stroke-linejoin:miter;stroke-opacity:1",
	locomotiveTextPathStyle : "color:#000000;clip-rule:nonzero;display:inline;overflow:visible;visibility:visible;opacity:1;isolation:auto;mix-blend-mode:normal;color-interpolation:sRGB;color-interpolation-filters:linearRGB;solid-color:#000000;solid-opacity:1;fill:none;fill-opacity:1;fill-rule:evenodd;stroke:#1e2141;stroke-width:21.25984192;stroke-linecap:butt;stroke-linejoin:miter;stroke-miterlimit:4;stroke-dasharray:none;stroke-dashoffset:0;stroke-opacity:1;color-rendering:auto;image-rendering:auto;shape-rendering:auto;text-rendering:auto;enable-background:accumulate"
};