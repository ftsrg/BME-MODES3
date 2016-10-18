/**
 * 
 */
function WSConnection(path) {
	this.socket = atmosphere;
	this.transport = 'websocket';

	this.request = {
		url : document.location.toString() + "ws/" + path,
		contentType : "application/json",
		logLevel : 'debug',
		transport : this.transport,
		trackMessageLength : true,
		reconnectInterval : 5000,
		wsconnection : this
	};

	WSConnection.prototype.connect = function() {
		this.clientSocket = this.socket.subscribe(this.request);
	}

	this.request.onOpen = function(response) {
		console.log("Connection opened: " + response.request.uuid);
	};

	WSConnection.prototype.onMessageArrived = function(msg) {};

	this.request.onMessage = function(response) {
		if (this.wsconnection.onMessageArrived && typeof this.wsconnection.onMessageArrived == "function") {
			var msg = JSON.parse(response.responseBody);
			this.wsconnection.onMessageArrived(msg);
		}
	}
	
	this.request.onClose = function(response) {
	    console.log("Connection closed: " + response.responseBody);
	};
	
	this.request.onClientTimeout = function(response) {
        setTimeout(function (){
           this.connect();
        }, this.request.reconnectInterval);
    };
    
    WSConnection.prototype.publish = function(jsonMessage) {
		var strMessage = JSON.stringify(jsonMessage);
		console.log("Publishing message: " + strMessage);
		this.clientSocket.push(strMessage);
	}

}