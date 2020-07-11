#ifndef NODE_HPP
#define NODE_HPP

#include <iostream>
#include <vector>
#include <string>
#include <iostream>
#include "StackException.hpp"

using namespace std;

template <typename T>
class Node
{
public:
    T item;
    Node *next;
};

#endif