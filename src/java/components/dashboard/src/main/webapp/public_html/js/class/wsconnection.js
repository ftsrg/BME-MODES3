/**
 * 
 */
function WSConnection(type, path) {
	this.socket = atmosphere;
	this.transport = 'websocket';

	this.request = {
		url : document.location.toString() + "ws/" + type + "/" + path,
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
	};

	WSConnection.prototype.onMessageArrived = function(msg) {};

	this.request.onMessage = function(response) {
		if (this.wsconnection.onMessageArrived && typeof this.wsconnection.onMessageArrived == "function") {
			var msg = JSON.parse(response.responseBody);
			this.wsconnection.onMessageArrived(msg);
		}
	}
	
	this.request.onClose = function(response){
	};
	
	this.request.onClientTimeout = function(response) {
        setTimeout(function (){
           this.connect();
        }, this.request.reconnectInterval);
    };
    
    WSConnection.prototype.publish = function(jsonMessage) {
		var strMessage = JSON.stringify(jsonMessage);
		this.clientSocket.push(strMessage);
	}

}