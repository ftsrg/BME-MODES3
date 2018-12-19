#! /usr/bin/env python3
from mvnc import mvncapi as mvnc
import sys
import numpy
import cv2
import time
import csv
import os
import sys
from sys import argv
from camStream.cstream import cStream
import socket
import mStream.modesmqttclient
import mStream.mjpegstream

# name of the opencv window
cv_window_name = "SSD Mobilenet"

cap = cStream(src = 0, usePiCamera = False, resolution = (640, 480), framerate = 10).start()
mclient = mStream.modesmqttclient.modesMqttClient()
mstream = mStream.mjpegstream.mjpegStreamer()

LowerBound = 0.8
UpperBound = 1.0
ShowLines = 0
maxImageSize = 65536 #same as buffer size on the server

os.system("mkdir tmp")
os.system("sudo mount -t tmpfs -o size=32m tmpfs tmp")
os.system("cp config tmp")

# labels AKA classes.  The class IDs returned
# are the indices into this list
labels = ('background',
          'aeroplane', 'bicycle', 'bird', 'boat',
          'bottle', 'bus', 'car', 'cat', 'chair',
          'cow', 'diningtable', 'dog', 'horse',
          'motorbike', 'person', 'plant',
          'sheep', 'sofa', 'train', 'tvmonitor')

# the ssd mobilenet image width and height
NETWORK_IMAGE_WIDTH = 300
NETWORK_IMAGE_HEIGHT = 300

# the minimal score for a box to be shown
min_score_percent = 40

noOfPeople = 0

def load():
    global LowerBound, UpperBound, ShowLines
    file = open("tmp/config", "r") 
    strData = file.readline()
    file.close() 

    dataArray = strData.split(";")

    LowerBound = float(dataArray[0])
    UpperBound = float(dataArray[1])
    ShowLines = int(dataArray[2])

# create a preprocessed image from the source image that complies to the
# network expectations and return it
def preprocess_image(source_image):
    resized_image = cv2.resize(source_image, (NETWORK_IMAGE_WIDTH, NETWORK_IMAGE_HEIGHT))
    
    # trasnform values from range 0-255 to range -1.0 - 1.0
    resized_image = resized_image - 127.5
    resized_image = resized_image * 0.007843
    return resized_image

# handles key presses by adjusting global thresholds etc.
# raw_key is the return value from cv2.waitkey
# returns False if program should end, or True if should continue
def handle_keys(raw_key):
    global min_score_percent
    ascii_code = raw_key & 0xFF
    if ((ascii_code == ord('q')) or (ascii_code == ord('Q'))):
        return False
    elif (ascii_code == ord('B')):
        min_score_percent += 5
        print('New minimum box percentage: ' + str(min_score_percent) + '%')
    elif (ascii_code == ord('b')):
        min_score_percent -= 5
        print('New minimum box percentage: ' + str(min_score_percent) + '%')

    return True

def sendData(object_info):
    global mclient, noOfPeople
    base_index = 0
    class_id = object_info[base_index + 1]
    bottom = object_info[base_index + 6]
    label = labels[int(class_id)]
    detectedJson = ("{"+
            "\"SensorID\":"+"\"0505\","+
            "\"Type\":"+"\"CameraData\","+
            "\"LabelText\":"+"\""+ labels[int(class_id)] +"\","+
            "\"BoxLeft\":"+"\""+ str(object_info[base_index + 3]) +"\","+
            "\"BoxTop\":"+"\""+ str(object_info[base_index + 4]) +"\","+
            "\"BoxRight\":"+"\""+ str(object_info[base_index + 5]) +"\","+
            "\"BoxBottom\":"+"\""+ str(object_info[base_index + 6]) +"\","+
            "\"LowerBound\":"+"\""+ str(LowerBound) +"\","+
            "\"UpperBound\":"+"\""+ str(UpperBound) +"\","+
            "\"MicroTimeStamp\":"+"\""+ str(int(time.time()*1000)) +"\""+
            "}\n")

    if((label != "train") & (bottom > LowerBound) & (bottom < UpperBound)):
        mclient.send((1, detectedJson))
    else:
        mclient.send((3, detectedJson))

    if(labels[int(class_id)] == "person"):
        noOfPeople += 1
    

        
# overlays the boxes and labels onto the display image.
# display_image is the image on which to overlay the boxes/labels
# object_info is a list of 7 values as returned from the network
#     These 7 values describe the object found and they are:
#         0: image_id (always 0 for myriad)
#         1: class_id (this is an index into labels)
#         2: score (this is the probability for the class)
#         3: box left location within image as number between 0.0 and 1.0
#         4: box top location within image as number between 0.0 and 1.0
#         5: box right location within image as number between 0.0 and 1.0
#         6: box bottom location within image as number between 0.0 and 1.0
# returns None
def overlay_on_image(display_image, object_info):
    global frames_per_second
    source_image_width = display_image.shape[1]
    source_image_height = display_image.shape[0]

    base_index = 0
    class_id = object_info[base_index + 1]
    percentage = int(object_info[base_index + 2] * 100)
    if (percentage <= min_score_percent):
        return

    label_text = labels[int(class_id)] + " (" + str(percentage) + "%)"
    box_left = int(object_info[base_index + 3] * source_image_width)
    box_top = int(object_info[base_index + 4] * source_image_height)
    box_right = int(object_info[base_index + 5] * source_image_width)
    box_bottom = int(object_info[base_index + 6] * source_image_height)

    box_color = (255, 128, 0)  # box color
    if((object_info[base_index + 6] > LowerBound) & (object_info[base_index + 6] < UpperBound)):
        box_color = (0, 0, 255)  # box color

    
    box_thickness = 2
    cv2.rectangle(display_image, (box_left, box_top), (box_right, box_bottom), box_color, box_thickness)

    scale_max = (100.0 - min_score_percent)
    scaled_prob = (percentage - min_score_percent)
    scale = scaled_prob / scale_max

    # draw the classification label string just above and to the left of the rectangle
    #label_background_color = (70, 120, 70)  # greyish green background for text
    label_background_color = (0, int(scale * 175), 75)
    label_text_color = (255, 255, 255)  # white text

    label_size = cv2.getTextSize(label_text, cv2.FONT_HERSHEY_SIMPLEX, 0.5, 1)[0]
    label_left = box_left
    label_top = box_top - label_size[1]
    if (label_top < 1):
        label_top = 1
    label_right = label_left + label_size[0]
    label_bottom = label_top + label_size[1]
    cv2.rectangle(display_image, (label_left - 1, label_top - 1), (label_right + 1, label_bottom + 1),
                  label_background_color, -1)

    # label text above the box
    cv2.putText(display_image, label_text, (label_left, label_bottom), cv2.FONT_HERSHEY_SIMPLEX, 0.5, label_text_color, 1)
    
# Run an inference on the passed image
# image_to_classify is the image on which an inference will be performed
#    upon successful return this image will be overlayed with boxes
#    and labels identifying the found objects within the image.
# ssd_mobilenet_graph is the Graph object from the NCAPI which will
#    be used to peform the inference.
def run_inference(image_to_classify, ssd_mobilenet_graph):

    # preprocess the image to meet nework expectations
    resized_image = preprocess_image(image_to_classify)

    # Send the image to the NCS as 16 bit floats
    ssd_mobilenet_graph.LoadTensor(resized_image.astype(numpy.float16), None)

    # Get the result from the NCS
    output, userobj = ssd_mobilenet_graph.GetResult()

    #   a.	First fp16 value holds the number of valid detections = num_valid.
    #   b.	The next 6 values are unused.
    #   c.	The next (7 * num_valid) values contain the valid detections data
    #       Each group of 7 values will describe an object/box These 7 values in order.
    #       The values are:
    #         0: image_id (always 0)
    #         1: class_id (this is an index into labels)
    #         2: score (this is the probability for the class)
    #         3: box left location within image as number between 0.0 and 1.0
    #         4: box top location within image as number between 0.0 and 1.0
    #         5: box right location within image as number between 0.0 and 1.0
    #         6: box bottom location within image as number between 0.0 and 1.0

    # number of boxes returned
    num_valid_boxes = int(output[0])

    for box_index in range(num_valid_boxes):
            base_index = 7+ box_index * 7
            if (not numpy.isfinite(output[base_index]) or
                    not numpy.isfinite(output[base_index + 1]) or
                    not numpy.isfinite(output[base_index + 2]) or
                    not numpy.isfinite(output[base_index + 3]) or
                    not numpy.isfinite(output[base_index + 4]) or
                    not numpy.isfinite(output[base_index + 5]) or
                    not numpy.isfinite(output[base_index + 6])):
                # boxes with non finite (inf, nan, etc) numbers must be ignored
                continue

            # overlay boxes and labels on to the image
            overlay_on_image(image_to_classify, output[base_index:base_index + 7])
            # send data to cura
            sendData(output[base_index:base_index + 7])

frames_per_second = 0

def displayStats(display_image):
    global frames_per_second, noOfPeople
    # display text to let user know how to quit
    cv2.rectangle(display_image,(0, 0), (160, 15), (128, 128, 128), -1)
    cv2.putText(display_image, "Number of people: " + str(noOfPeople), (10, 12), cv2.FONT_HERSHEY_SIMPLEX, 0.4, (255, 0, 0), 1)

    # display fps
    cv2.rectangle(display_image,(0, 15), (190, 30), (128, 128, 128), -1)
    cv2.putText(display_image, "frames per second: " + str(frames_per_second)[:5], (10, 27), cv2.FONT_HERSHEY_SIMPLEX, 0.4, (255, 0, 0), 1)

    if(ShowLines == 1):
        cv2.line(display_image,(0,int(480*LowerBound)),(640,int(480*LowerBound)),(255,0,0),3)
        cv2.line(display_image,(0,int(480*UpperBound)),(640,int(480*UpperBound)),(255,0,0),3)
# This function is called from the entry point to do
# all the work.
def main():
    global frames_per_second, noOfPeople

    # configure the NCS
    mvnc.SetGlobalOption(mvnc.GlobalOption.LOG_LEVEL, 2)

    # Get a list of ALL the sticks that are plugged in
    devices = mvnc.EnumerateDevices()
    if len(devices) == 0:
        print('No devices found')
        quit()

    # Pick the first stick to run the network
    device = mvnc.Device(devices[0])

    # Open the NCS
    device.OpenDevice()

    graph_filename = 'modell/graph'

    # Load graph file to memory buffer
    with open(graph_filename, mode='rb') as f:
        graph_data = f.read()

    # allocate the Graph instance from NCAPI by passing the memory buffer
    ssd_mobilenet_graph = device.AllocateGraph(graph_data)

    #cv2.namedWindow(cv_window_name, 0)
    #cv2.moveWindow(cv_window_name, 10, 10)
    #cv2.resizeWindow(cv_window_name, 640, 480)

    frame_count = 0
    start_time = time.time()

    try:
        while(True):
            #load()
            display_image = cap.read()
            noOfPeople = 0

            run_inference(display_image, ssd_mobilenet_graph)
            displayStats(display_image)

            mstream.send(display_image)
            #cv2.imshow(cv_window_name, display_image)

            raw_key = cv2.waitKey(1)
            if (raw_key != -1):
                if (handle_keys(raw_key) == False):
                    break

            frame_count += 1
            
            if(frame_count > 20):
                frames_per_second = frame_count / (time.time() - start_time)
                start_time = time.time()
                frame_count = 0   
    except (KeyboardInterrupt, SystemExit):
        # Clean up the graph and the device
        ssd_mobilenet_graph.DeallocateGraph()
        device.CloseDevice()
        onexit()
        raise
    # Clean up the graph and the device
    ssd_mobilenet_graph.DeallocateGraph()
    device.CloseDevice()
    onexit()


def onexit():
    os.system("cp tmp/config config")
    os.system("rm tmp/*")
    #cv2.destroyAllWindows()

# main entry point for program. we'll call main() to do what needs to be done.
if __name__ == "__main__":
    sys.exit(main())