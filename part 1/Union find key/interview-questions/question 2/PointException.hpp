#ifndef POINTEXCEPCTION_HPP
#define POINTEXCEPCTION_HPP
#include <string>
#include <exception>

using namespace std;

class SetException : public exception
{
    private:
    string msg;

    public:
    SetException(string);
    const char * what () const throw ();
};
#endif