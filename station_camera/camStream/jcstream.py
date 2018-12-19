from imutils.video.webcamvideostream import WebcamVideoStream
import cv2

class wcStream(WebcamVideoStream):
    def __init__(self):
        # initialize the video camera stream and read the first frame
        # from the stream
        self.stream = cv2.VideoCapture("nvcamerasrc ! video/x-raw(memory:NVMM), width=(int)1280, height=(int)720,format=(string)I420, framerate=(fraction)30/1 ! nvvidconv flip-method=0 ! video/x-raw, format=(string)BGRx ! videoconvert ! video/x-raw, format=(string)BGR ! appsink")

        # initialize the variable used to indicate if the thread should
        # be stopped
        self.stopped = False
