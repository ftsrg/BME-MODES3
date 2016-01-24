#include "InputFilter.hpp"

void InputFilter::process() {	
	static Mat raw;
	//std::cout << "Reading frame: " << vid.get(CV_CAP_PROP_POS_FRAMES) << std::endl;
	vid >> raw;
	
	setData<0>(raw);
}