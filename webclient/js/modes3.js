$(document).ready(function() {
	boardOffset = {x: -8, y: -8}
	trainColor = [
		'#FF0000',
		'#00FF00',
		'#0000FF'
	]

    $('#settingsModal').on('show.bs.modal', function(event) {
        if (typeof localStorage['settings'] !== 'undefined') {
            var settings = JSON.parse(localStorage['settings'])
            for (key in settings) {
                if (typeof settings[key] === "string") {
                    $(`#settingsForm input[name="${key}"]`).val(settings[key])
                } else {
					$(`#settingsForm input[name="${key}"]`).attr('checked', settings[key])
				}
            }
        }
    });

    $('#settingsSave').click(function() {
        var settings = new Object
        var formInput = $('#settingsForm input')
        $.each(formInput, function(i, field) {
            if (field.type == "checkbox")
                var data = field.checked
            else
                var data = field.value

            settings[field.name] = data
        })
        localStorage['settings'] = JSON.stringify(settings)
    });

    $('#connectionStatus').click(function() {
        MQTT_Connect()
    });
})

// -----------------------------------------------------------------------------
// MQTT functions
// -----------------------------------------------------------------------------


function MQTT_Connect() {
	var settings = JSON.parse(localStorage['settings'])
    if (typeof mqttClient === 'undefined') {
        mqttClient = new Paho.MQTT.Client(settings['server'], 9001, "clientId")
        mqttClient.onConnectionLost = MQTT_Disconnected
        mqttClient.onMessageArrived = MQTT_Message
    }
    if (mqttClient.connected === true) {
        mqttClient.disconnect()
    } else {
        MQTT_Connecting()
        mqttClient.connect({
            onSuccess: MQTT_Connected_asController,
            onFailure: MQTT_AuthFailure,
            userName: settings['username'],
            password: settings['password']
        });
    }
}

function MQTT_Connecting() {
    $('#connectionStatus').attr('class', 'mrp-connecting')
    $('#connectionStatusText').text('Connecting')
}

function MQTT_Connected_asController() {
    mqttClient.connected = true
    mqttClient.subscribe("modes3/cv")
    //mqttClient.subscribe("/mrp/control")

    $('#connectionStatus').attr('class', 'mrp-connected__controller')
    $('#connectionStatusText').text('Connected as Controller')

    MoDeS3_Board_Initialize()
}

function MQTT_Connected_asGuest() {
    mqttClient.connected = true
    mqttClient.subscribe("modes3/cv")

    $('#connectionStatus').attr('class', 'mrp-connected')
    $('#connectionStatusText').text('Connected')

    MoDeS3_Board_Initialize()
}

function MQTT_AuthFailure(event) {
    mqttClient.connect({
        onSuccess: MQTT_Connected_asGuest,
        onFailure: MQTT_Disconnected
    });
}

function MQTT_Disconnected(event) {
	if (event.errorCode != 0) {
		//MoDeS3_Log_Error('Connection failure to MQTT broker!')
	}
    mqttClient.connected = false
    $('#connectionStatus').attr('class', 'mrp-disconnected')
    $('#connectionStatusText').text('Disconnected')
}

function MQTT_Message(message) {
	console.log('Message arrived');
	var object = JSON.parse(message.payloadString);
	switch (message.destinationName) {
		case 'modes3/cv':
			MoDeS3_HandleCV(object)
			break;
		default:
	}
}

// -----------------------------------------------------------------------------
// MoDeS3 functions
// -----------------------------------------------------------------------------

function MoDeS3_Board_Initialize() {
	var sections = $('#mrp-board-svg #sections path').attr('class', 'mrp-section--active')
	var turnouts = $('#mrp-board-svg #turnouts polygon').attr('class', 'mrp-turnout--active')

	MoDeS3_HandleCV('kek')
}

function MoDeS3_Log_Error(message) {
	$('#mrp-log-container').append(
		`<div class="alert alert-danger fade in"><strong>Error!</strong> ${message}</div>`
	)
}

function MoDeS3_HandleCV(message) {
	var trainGroup = Snap('#mrp-board-svg #trains')

	for(i in message.trains) {
		var train = message.trains[i]
		var trainCircle = $(`#trains #${train.id}`)
		if (trainCircle.length == 0) {
			var trainCircle = trainGroup.circle(train.x - boardOffset.x, train.y - boardOffset.y, 3);
			trainCircle.attr({
				id: train.id,
				class: 'modes3-train',
			    fill: trainColor[train.id],
			    stroke: '#000000',
			    strokeWidth: 1
			});
		} else {
			trainCircle.attr({
				cx: train.x - boardOffset.x,
				cy: train.y - boardOffset.y
			})
		}
	}
}
