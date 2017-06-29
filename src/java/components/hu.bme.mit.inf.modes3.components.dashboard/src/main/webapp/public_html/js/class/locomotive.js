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

    // then create DOM in trains list
    this.createDOMrepresentation();
}

LocomotiveController.prototype.pushSpeed = function (speed) {
	if (speed < 0) {
        log("Pushing train speed: "+speed);
        this.controller.pushTrainSpeed(this.config.address, Math.abs(speed), 1);

    } else {
    	log("Pushing train speed: "+speed);
    	this.controller.pushTrainSpeed(this.config.address, speed, 0);
    }
};

LocomotiveController.prototype.setSpeed = function (speed) {
    this.speed = speed;
	this.rangeInput.val(speed);
	this.indicatorElem.text(speed);
};

LocomotiveController.prototype.createDOMrepresentation = function () {
    var container = $('<div />').addClass('train-container').attr("id", "train-"+this.config.address);
	//var header = $('<h2 />').text(this.config.name);
    var header = $('<h2 />').text(this.config.name);
	  var removebtn = $('<button />').addClass('remove-train').text('X');
    var image = $('<img />')
            .attr('src', 'images/locomotives/' + this.config.image);
    this.rangeInput = $('<input />').attr({
        type: 'range',
        min: -50,
        max: +50,
        value: 0
    });
    this.indicatorElem = $('<div />').addClass('train-control-speed-indicator').text('0');
    var controls = $('<div />').addClass('train-control-speed')
            .append(this.rangeInput).append(this.indicatorElem);
    container.append(header).append(removebtn).append(image).append(controls);
    image.wrap($('<div />').addClass('train-control-image'));
    this.rangeInput.wrap($('<div />').addClass('train-control-speed-input'));
    $('#train-control').append(container);

    // add event handler for range input
    this.rangeInput.bind('change', {_this: this}, function (event) {
    	var speed = $(this).val();
        event.data._this.setSpeed(speed);
        event.data._this.pushSpeed(speed);

    });
    this.rangeInput.bind('mousemove', {_this: this}, function (event) {
        event.data._this.setSpeed($(this).val());
    });
};

LocomotiveController.prototype.DOMUpdatedCallback = function () {

};
