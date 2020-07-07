#include <iostream>
#include <exception>
#include "StackException.hpp"

StackException::StackException(string msg_) : msg(msg_){}

const char * StackException::what () const throw (){
    return msg.c_str();
}