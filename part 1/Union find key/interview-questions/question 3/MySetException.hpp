#ifndef MYSETEXCEPTION_HPP
#define MYSETEXCEPTION_HPP
#include <string>
#include <exception>

using namespace std;

class MySetException : public exception
{
    private:
    string msg;

    public:
    MySetException(string);
    const char * what () const throw ();
};
#endif