#!/usr/bin/python3
import queue
import threading
import time
import numpy
import cv2
import os

class mjpegStreamer (threading.Thread):
   
    def __init__(self, fifoSize = 1):
        threading.Thread.__init__(self)
        self.fifo = queue.Queue(fifoSize)
        
        self.exit = False
        self.daemon = True
        self.start()

    def run(self):        
        while(not self.exit):
            try:
                data = self.fifo.get() 
                cv2.imwrite("tmp/tmp.jpg", data)
                os.system("cat tmp/tmp.jpg")
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
            

    def stop(self):
        self.exit = True