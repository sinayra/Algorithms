#ifndef MYSET_HPP
#define MYSET_HPP

#include <iostream>
#include <vector>
#include <stdexcept>
#include "MySetException.hpp"

using namespace std;

class MySet
{
private:
    vector<int> S;

    int getPredecessor(int);
public:
    MySet(int);
    void remove(int);
    int getSuccessor(int);
};
#endif