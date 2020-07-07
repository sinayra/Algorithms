#ifndef STACKEXCEPCTION_HPP
#define STACKEXCEPCTION_HPP
#include <string>
#include <exception>

using namespace std;

class StackException : public exception
{
    private:
    string msg;

    public:
    StackException(string);
    const char * what () const throw ();
};
#endif