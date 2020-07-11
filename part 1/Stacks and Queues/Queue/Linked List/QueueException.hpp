#ifndef QUEUEEXCEPCTION_HPP
#define QUEUEEXCEPCTION_HPP
#include <string>
#include <exception>

using namespace std;

class QueueException : public exception
{
    private:
    string msg;

    public:
    QueueException(string);
    const char * what () const throw ();
};

QueueException::QueueException(string msg_) : msg(msg_){}

const char * QueueException::what () const throw (){
    return msg.c_str();
}
#endif