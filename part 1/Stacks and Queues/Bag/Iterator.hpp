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
    virtual bool hasNext() = 0;
    virtual T next() = 0;
    virtual void remove() = 0;
};

#endif