#ifndef BAG_HPP
#define BAG_HPP

#include <iostream>
#include <vector>
#include <string>
#include <iostream>
#include "Iterable.hpp"

using namespace std;

template <typename T>
class Bag : public Iterable
{
    private:
    Iterable<T> *it;
    
    public:
        void add(T);
        int size()
        Iterator<T> iterator();
};

#endif