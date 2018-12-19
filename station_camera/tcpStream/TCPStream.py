#!/usr/bin/python3
import queue
import threading
import time
import socket

class tcpStream (threading.Thread):
   
    def __init__(self, ip = "127.0.0.1", port = 5005, fifoSize = 16):
        threading.Thread.__init__(self)
        self.ip = ip
        self.port = port
        self.fifo = queue.PriorityQueue(fifoSize)
        self.socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
        self.exit = False
        self.daemon = True
        self.start()

    def run(self):        
        while(not self.exit):
            try:
                priority, data = self.fifo.get()      
                try:
                    self.socket.send(data)
                except:
                    try:
                        self.socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
                        self.socket.connect((self.ip, self.port))
                        self.socket.send(data)
                    except:
                        pass
            except:
                pass

    def send(self, data):
        try:
            self.fifo.put_nowait(data)
        except:
            print("fifo full")
            try:
                self.fifo.get_nowait()
            except:
                pass
            self.send(data)

    def stop(self):
        self.exit = True
        self.socket.close()