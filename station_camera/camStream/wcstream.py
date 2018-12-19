from imutils.video.webcamvideostream import WebcamVideoStream
import cv2

class wcStream(WebcamVideoStream):
    def __init__(self, src=0, resolution = (1920, 1080)):
        # initialize the video camera stream and read the first frame
        # from the stream
        self.stream = cv2.VideoCapture(src)
        self.stream.set(3,resolution[0])
        self.stream.set(4,resolution[0])
        (self.grabbed, self.frame) = self.stream.read()

        # initialize the variable used to indicate if the thread should
        # be stopped
        self.stopped = False
