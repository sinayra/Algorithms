#ifndef STACK_HPP
#define STACK_HPP

#include <iostream>
#include <vector>
#include <string>
#include <iostream>
#include "StackException.hpp"

using namespace std;

class Node
{
public:
    string item;
    Node *next;
};

class StackOfString
{
private:
    Node *first;

public:
    StackOfString();
    void push(string);
    string pop();
    bool isEmpty();
    //void size();

    void displayStack();
};
#endif