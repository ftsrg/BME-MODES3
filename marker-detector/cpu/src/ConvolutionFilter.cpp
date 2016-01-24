#include "ConvolutionFilter.hpp"
#include "Utils.hpp"

void ConvolutionFilter::process() {
	static Mat raw;
	cv::swap(inputFilter.getData<0>(), raw);
	inputFilter.clearToProcess();
	setData<1>(raw);
	
	static Mat contour;
	contour = convolve(raw, circleSpectrum, CONV_THRES);
	setData<0>(contour);
}

ConvolutionFilter::ConvolutionFilter(InputFilter& inputFilter) : inputFilter(inputFilter) {
	circleSpectrum = createCirclePattern(Size(2048, 1024), T_MARKER_OUTER, T_MARKER_MID, T_MARKER_INNER);
}