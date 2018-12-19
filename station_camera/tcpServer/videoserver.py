#! /usr/bin/env python3
import socket
import cv2
import numpy
import time

TCP_IP = '0.0.0.0'
TCP_PORT = 5005
BUFFER_SIZE = 65536

s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
s.bind((TCP_IP, TCP_PORT))
s.listen(1)

conn, addr = s.accept()
while(True):
    stringData = conn.recv(BUFFER_SIZE)
    data = numpy.fromstring(stringData,dtype='uint8')
    decimg = cv2.imdecode(data,1)

    try:
        cv2.imshow("Server",decimg)
    except:
        pass

    if cv2.waitKey(1) & 0xFF == ord('q'):
        break
    
    time.sleep(0.15)

conn.close()
cv2.destroyAllWindows()
