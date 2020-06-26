#ifndef POINTEXCEPCTION_HPP
#define POINTEXCEPCTION_HPP
#include <exception>

using namespace std;

class PointException : public exception
{
    private:
    string msg;

    public:
    PointException(string);
    const char * what () const throw ();
};
#endif