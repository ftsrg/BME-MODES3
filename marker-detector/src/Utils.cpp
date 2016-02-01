#include "Utils.hpp"

void drawMarkerToMat(Mat& marker, int x, int y, int outer, int ring, int inner) {
	circle(marker, Point(x, y), outer, Scalar(1.0), -1);
	circle(marker, Point(x, y), ring, Scalar(-1.0), -1);
	circle(marker, Point(x, y), inner, Scalar(1.0), -1);
}

#ifdef ENABLE_GPU
GpuMat createCirclePattern(Size vidsize, int outer, int ring, int inner) {
	Mat circle = Mat::zeros(Size_<int>(vidsize), CV_32F);
	drawMarkerToMat(circle, 0, 0, outer, ring, inner);
	drawMarkerToMat(circle, 0, vidsize.height, outer, ring, inner);
	drawMarkerToMat(circle, vidsize.width, 0, outer, ring, inner);
	drawMarkerToMat(circle, vidsize.width, vidsize.height, outer, ring, inner);
	
	cv::GaussianBlur(circle, circle, Size(3, 3), 2);
	
	GpuMat circleSpectrum;
	circleSpectrum.upload(circle);
	
	cuda::dft(circle, circleSpectrum, circle.size());
	return circleSpectrum;
}

Mat convolve(Mat raw, GpuMat circleSpectrum, float thresold) {
	static Mat gray;
	cv::cvtColor(raw, gray, CV_BGR2GRAY);
	
	Rect2i srcRoi(Point(0, 28), Size(1920, 1024));
	Rect2i dstRoi(Point(64, 0), Size(1920, 1024));
	
	static HostMem grayPaddedMem(1024, 2048, CV_32F);
	static Mat grayPadded = ([&]() {
		Mat material = grayPaddedMem.createMatHeader();
		material.setTo(Scalar(0));
		return material;
	})();
	
	gray(srcRoi).convertTo(grayPadded(dstRoi), CV_32F, 1/255.0);
	
	static cuda::Stream stream;
	
	static GpuMat spectrum = createContinuous(Size(1025, 1024), CV_32FC2);
	spectrum.upload(grayPadded, stream);
	
	cuda::dft(spectrum, spectrum, grayPadded.size(), 0, stream);
	cuda::mulSpectrums(spectrum, circleSpectrum, spectrum, 0, stream);
	
	static GpuMat convoluted = createContinuous(Size(2048, 1024), CV_32FC2);
	cuda::dft(spectrum, convoluted, grayPadded.size(), DFT_INVERSE | DFT_REAL_OUTPUT, stream);
	
	cuda::normalize(convoluted, convoluted, 0, 1, NORM_MINMAX, CV_32F, noArray(), stream);
	cuda::threshold(convoluted, convoluted, thresold, 1, CV_THRESH_BINARY, stream);
	
	static GpuMat spectrumByte;
	convoluted.convertTo(spectrumByte, CV_8U, 255);
	
	static Mat contour = Mat::zeros(1080, 1920, CV_8U);
	spectrumByte(dstRoi).download(contour(srcRoi), stream);
	
	stream.waitForCompletion();
	return contour;
}
#else
Mat createCirclePattern(Size vidsize, int outer, int ring, int inner) {
	Mat circle = Mat::zeros(Size_<int>(vidsize), CV_32F);
	drawMarkerToMat(circle, 0, 0, outer, ring, inner);
	drawMarkerToMat(circle, 0, vidsize.height, outer, ring, inner);
	drawMarkerToMat(circle, vidsize.width, 0, outer, ring, inner);
	drawMarkerToMat(circle, vidsize.width, vidsize.height, outer, ring, inner);
	
	cv::GaussianBlur(circle, circle, Size(3, 3), 2);
	
	Mat circleSpectrum;
	cv:dft(circle, circleSpectrum);
	return circleSpectrum;
}

Mat convolve(Mat raw, Mat circleSpectrum, float thresold) {
	static Mat gray;
	cv::cvtColor(raw, gray, CV_BGR2GRAY);
	
	Rect2i srcRoi(Point(0, 28), Size(1920, 1024));
	Rect2i dstRoi(Point(64, 0), Size(1920, 1024));
	
	static Mat grayPadded(1024, 2048, CV_32F);
	grayPadded = Mat::zeros(grayPadded.size(), CV_32F);
	gray(srcRoi).convertTo(grayPadded(dstRoi), CV_32F, 1/255.0);
	
	static Mat spectrum;
	cv::dft(grayPadded, spectrum, 0);
	cv::mulSpectrums(spectrum, circleSpectrum, spectrum, 0);
	
	static Mat convoluted(Size(2048, 1024), CV_32FC2);
	cv::dft(spectrum, convoluted, DFT_INVERSE | DFT_REAL_OUTPUT);
	
	cv::normalize(convoluted, convoluted, 0, 1, NORM_MINMAX, CV_32F, noArray());
	cv::threshold(convoluted, convoluted, thresold, 1, CV_THRESH_BINARY);
	
	static Mat spectrumByte;
	convoluted.convertTo(spectrumByte, CV_8U, 255);
	
	static Mat contour(1080, 1920, CV_8U);
	spectrumByte(dstRoi).copyTo(contour(srcRoi));
	
	return contour;
}
#endif

bool findMarker(Point2f a, Point2f b, double min, double max) {
	double distance = cv::norm(a - b);
	if (min < distance && distance < max) {
		return true;
	}
	
	return false;
}

int identifyMarker(Point2f markerCenter, Mat img) {
	Rect2i roi((markerCenter - Point2f(8, 8)), cv::Size2i(16, 16));
	
	Scalar mean = cv::mean(img(roi));
	cv::rectangle(img, roi, Scalar(0, 0, 255));
	
	Mat_<Point3f> meanMat(1, 1);
	meanMat.at<Point3f>(0, 0) = Point3f(mean[0], mean[1], mean[2]);
	Mat_<Point3f> hsvMat;
	cv::cvtColor(meanMat, hsvMat, CV_BGR2HSV);
	
	Point3f hsv = hsvMat.at<Point3f>(0, 0);
	
	float hue = hsv.x;
	//std::cout << "Hue: " << hue << std::endl;
	
	float sat = hsv.y;
	//std::cout << "Sat: " << sat << std::endl;
	
	float val = hsv.z;
	//std::cout << val << std::endl << std::endl;
	
	if (val > 100) {
		if (RED1_LOW < hue && hue < RED1_HIGH)
			return MARKER_R;
		else if (RED2_LOW < hue && hue < RED2_HIGH)
			return MARKER_R;
		else if (GREEN_LOW < hue && hue < GREEN_HIGH)
			return MARKER_G;
	}
	
	if (BLUE_LOW < hue && hue < BLUE_HIGH)
		return MARKER_B;
	
	
	return MARKER_UNKNOWN;
}

std::vector<Point2f> calculateMassCenters(Mat contour) {
	std::vector<std::vector<Point>> contours;
	std::vector<Vec4i> hierarchy;
	findContours(contour, contours, hierarchy, CV_RETR_EXTERNAL, CV_CHAIN_APPROX_SIMPLE, Point(0, 0) );
	
	std::vector<Moments> mu(contours.size() );
	for( int i = 0; i < contours.size(); i++ )
	{ mu[i] = moments( contours[i], false ); }
	
	std::vector<Point2f> mc( contours.size() );
	for( int i = 0; i < contours.size(); i++ )
	{
		Point2f com = Point2f( mu[i].m10/mu[i].m00 , mu[i].m01/mu[i].m00 );
		if (!(isnan(com.x) && isnan(com.y))) {
			mc[i] = com;
		}
	}
	
	std::random_shuffle(mc.begin(), mc.end());
	return mc;
}

void drawTrainMarker(Mat& raw, Train& train, Point2f start, Point2f end, Point2f center) {
	const int ARROWS = 15;
	
	const float HEIGHT = 0.3;
	const float A_HEIGHT = 0.2;
	
	const float H_DIST = 0.85;
	const float L_DIST = 0.60;
	
	const float A_DIST = 0.95;
	const float A_BACK = 0.1;
	const float A_PLUS = 0.2;
	
	cv::line(raw, start, end, Scalar(255, 0, 0));
	
	Point2f v0 = end - start;
	Point2f v1 = {v0.y, -v0.x};
	
	if (train.lastSpeed > 0.001) {
		Point2f speedVector = train.positions[train.positions.size() - 1].coordinate - train.positions[0].coordinate;
		float dotProduct = v0.dot(speedVector);
		
		if (dotProduct < 0) {
			v0 = -v0;
		}
	}
	
	auto convert = [&](float a, float b) {
		return center + (v0 * a) + (b * v1);
	};
	/*
	 auto draw = [](Point2f point) {
		glVertex2f(point.x, point.y);
	 };
	 */
	auto drawLine = [&](Point2f start, Point2f end, Scalar color, float thickness) {
		line(raw,
			 start,
			 end,
			 color, thickness / 2, CV_AA);
	};
	auto drawLines = [&](std::vector<std::pair<Point2f, Point2f>> pairs, Scalar color, float thickness) {
		for(auto& pair : pairs) {
			drawLine(pair.first, pair.second, Scalar(0, 0, 0), thickness + 4);
		}
		for(auto& pair : pairs) {
			drawLine(pair.first, pair.second, color, thickness);
		}
	};
	
	Scalar color;
	switch (train.id) {
		case MARKER_R:
			color = Scalar(0, 0, 255);
			break;
		case MARKER_G:
			color = Scalar(0, 255, 0);
			break;
		case MARKER_B:
			color = Scalar(255, 0, 0);
			break;
		default:
			color = Scalar(0, 0, 0);
	}
	
	drawLines({
		{convert(H_DIST, -HEIGHT),  convert(H_DIST, HEIGHT)},
		{convert(-H_DIST, -HEIGHT), convert(-H_DIST, +HEIGHT)},
		{convert(-H_DIST, -HEIGHT), convert(-L_DIST, -HEIGHT)},
		{convert(-H_DIST, +HEIGHT), convert(-L_DIST, +HEIGHT)},
		{convert(+H_DIST, -HEIGHT), convert(+L_DIST, -HEIGHT)},
		{convert(+H_DIST, +HEIGHT), convert(+L_DIST, +HEIGHT)}
	}, color, 6);
	
	
	/*
	 if (train.lastSpeed > 0) {
		for (int i = 0; i * 2 < train.lastSpeed; ++i) {
	 Scalar color(
	 0,
	 255 - 255 / ARROWS * train.lastSpeed,
	 255 / ARROWS * train.lastSpeed
	 );
	 
	 drawLines({
	 {convert(A_DIST + A_PLUS * (i+1) - A_BACK, +A_HEIGHT), convert(A_DIST + A_PLUS * (i+1), 0)},
	 {convert(A_DIST + A_PLUS * (i+1) - A_BACK, -A_HEIGHT), convert(A_DIST + A_PLUS * (i+1), 0)}
	 }, color, 6);
		}
	 }
	 */
}