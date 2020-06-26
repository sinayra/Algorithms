#include <iostream>
#include <exception>
#include "PointException.hpp"

PointException::PointException(string msg_) : msg(msg_){}

const char * PointException::what () const throw (){
    return msg.c_str();
}