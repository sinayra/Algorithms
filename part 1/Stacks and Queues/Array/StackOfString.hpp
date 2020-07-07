#ifndef STACK_HPP
#define STACK_HPP

#include <iostream>
#include <vector>
#include <string>
#include <iostream>
#include "StackException.hpp"

using namespace std;

class StackOfString
{
private:
    vector<string> arr;
    int last;

public:
    [[deprecated("Replaced by StackOfString(), no need to pass capacity")]]
    StackOfString(int);

    StackOfString();
    void push(string);
    string pop();
    bool isEmpty();
    //void size();

    void displayStack();
};
#endif