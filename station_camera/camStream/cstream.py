# import the necessary packages
from imutils.video.videostream import VideoStream
from camStream.wcstream import wcStream

class cStream(VideoStream):
	def __init__(self, src=0, usePiCamera=False,  useJetsonCamera=False, resolution=(1920, 1080),
		framerate=32):
		# check to see if the picamera module should be used
		if usePiCamera:
			# only import the picamera packages unless we are
			# explicity told to do so -- this helps remove the
			# requirement of `picamera[array]` from desktops or
			# laptops that still want to use the `imutils` package
			from imutils.video.pivideostream import PiVideoStream

			# initialize the picamera stream and allow the camera
			# sensor to warmup
			self.stream = PiVideoStream(resolution=resolution,
				framerate=framerate)

		# otherwise, we are using OpenCV so initialize the webcam
		# stream
		
		elif useJetsonCamera:
			from camStream.jstream import jStream
			self.stream = jStream()

		else:
			self.stream = wcStream(src=src,resolution=resolution)
