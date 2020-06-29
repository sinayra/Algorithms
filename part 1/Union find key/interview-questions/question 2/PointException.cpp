#include <iostream>
#include <exception>
#include "PointException.hpp"

SetException::SetException(string msg_) : msg(msg_){}

const char * SetException::what () const throw (){
    return msg.c_str();
}