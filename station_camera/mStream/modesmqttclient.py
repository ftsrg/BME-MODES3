#!/usr/bin/python3
import queue
import threading
import time
import paho.mqtt.client as mqtt

class modesMqttClient (threading.Thread):
    
    def __init__(self, clientName = "camera", hostName = "192.168.1.230", topicOut = "raw/cameradata", topicIn = "command/camera", fifoSize = 16):
        threading.Thread.__init__(self)

        def onMessage(client, userdata, message):
            data = str(message.payload.decode("utf-8"))
            tmpconfig = open("tmp/config","w") 
            tmpconfig.write(data)
            tmpconfig.close()

        self.hostName = hostName
        self.client = mqtt.Client(clientName)
        #self.client.username_pw_set(username = "nukleari", password = "fcdcc8ec9d5d4648bf7c15a5d387ca24")
        try:
            self.client.connect(self.hostName)
        except (KeyboardInterrupt, SystemExit):
            raise
        except:
            pass
        self.topicOut = topicOut        
        self.fifo = queue.PriorityQueue(fifoSize)

        self.inputFifo = queue.Queue(fifoSize)
        self.client.subscribe(topicIn)
        self.client.on_message=onMessage
        self.client.loop_start()
        
        self.exit = False
        self.daemon = True
        self.start()

    def run(self):        
        while(not self.exit):
            try:
                priority, data = self.fifo.get()      
                try:
                    self.client.publish(self.topicOut, data)
                except (KeyboardInterrupt, SystemExit):
                    raise
                except:
                    try:
                        self.client.connect(self.hostName)
                        self.client.publish(self.topicOut, data)
                    except (KeyboardInterrupt, SystemExit):
                        raise
                    except:
                        pass
            except (KeyboardInterrupt, SystemExit):
                raise
            except:
                pass

    def send(self, data):
        try:
            self.fifo.put_nowait(data)
        except (KeyboardInterrupt, SystemExit):
            raise
        except:
            try:
                self.fifo.get_nowait()
            except (KeyboardInterrupt, SystemExit):
                raise
            except:
                pass
            self.send(data)

    def receive(self, data):
        try:
            data = self.inputFifo.get_nowait()
        except (KeyboardInterrupt, SystemExit):
            raise
        except:
            pass

    def onMessage(self, data):
        try:
            self.inputFifo.put_nowait(data)
        except (KeyboardInterrupt, SystemExit):
            raise
        except:
            try:
                self.inputFifo.get_nowait()
            except (KeyboardInterrupt, SystemExit):
                raise
            except:
                pass
            self.onMessage(data)

    def stop(self):
        self.exit = True
        self.client.loop_stop()