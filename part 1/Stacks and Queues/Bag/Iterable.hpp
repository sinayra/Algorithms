#ifndef ITERABLE_HPP
#define ITERABLE_HPP

#include <iostream>
#include <vector>
#include <string>
#include <iostream>
#include "Iterator.hpp"

using namespace std;

template <typename T>
class Iterable
{
    virtual Iterator<T> iterator() = 0;
};

#endif