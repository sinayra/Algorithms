#ifndef BAG_HPP
#define BAG_HPP

#include <iostream>
#include <vector>
#include <string>
#include <iostream>

using namespace std;

template <typename T>
class Bag 
{
   
    public:
        void add(T);
        int size();
};

#endif