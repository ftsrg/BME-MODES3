#pragma once
#include <exception>
class InitFailedException :
	public std::exception
{
public:
	InitFailedException();
	virtual ~InitFailedException();
};

