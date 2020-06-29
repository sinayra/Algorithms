#include <iostream>
#include <exception>
#include "MySetException.hpp"

MySetException::MySetException(string msg_) : msg(msg_){}

const char * MySetException::what () const throw (){
    return msg.c_str();
}