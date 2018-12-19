#! /usr/bin/env python3
import socket
   
TCP_IP = '0.0.0.0'
TCP_PORT = 5006
BUFFER_SIZE = 256

s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
s.bind((TCP_IP, TCP_PORT))
s.listen(1)

conn, addr = s.accept()
while(True):
    data = conn.recv(BUFFER_SIZE)
    if not data: break
    print("received data:", data)
conn.close()