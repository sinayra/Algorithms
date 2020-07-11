#ifndef ITERATOR_HPP
#define ITERATOR_HPP

#include <iostream>
#include <vector>
#include <string>
#include <iostream>

using namespace std;

template <typename T>
class Iterator
{
public:
    virtual T begin() = 0;
    virtual T end() = 0;
};

#endif