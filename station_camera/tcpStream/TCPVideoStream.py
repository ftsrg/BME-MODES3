#!/usr/bin/python3
import queue
import threading
import time
import socket
import numpy
import cv2

class tcpVideoStream (threading.Thread):
   
    def __init__(self, ip = "127.0.0.1", port = 5005, fifoSize = 1):
        threading.Thread.__init__(self)
        self.fifo = queue.PriorityQueue(fifoSize)
        self.ip = ip
        self.port = port
        self.socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
        self.exit = False
        self.daemon = True
        self.start()

    def run(self):        
        while(not self.exit):
            try:
                priority, data = self.fifo.get() 
                self.sendVideo(data)
            except:
                pass

    def send(self, data):
        try:
            self.fifo.put_nowait((1, data))
        except:
            print("fifo full")
            try:
                self.fifo.get_nowait()
            except:
                pass
            self.send(data)
            
    def sendVideo(self, frame, quality = 80):
        maxImageSize = 65536 #same as buffer size on the server
        encode_param = [int(cv2.IMWRITE_JPEG_QUALITY), quality]
        result, imgencode = cv2.imencode('.jpg', frame, encode_param)
        data = numpy.array(imgencode)
        stringData = data.tostring()
        
        if(len(stringData) < maxImageSize):
            try:
                self.socket.send(stringData)
            except:
                try:
                    self.socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
                    self.socket.connect((self.ip, self.port))
                    self.socket.send(data)
                except:
                    pass
        else:
            if(quality > 10):
                self.sendVideo(frame, quality - 10)
            else:
                print("Couldn't send current frame, try bigger maxImageSize.")

    def stop(self):
        self.exit = True