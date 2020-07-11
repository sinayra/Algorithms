#ifndef STACK_HPP
#define STACK_HPP

#include <iostream>
#include <vector>
#include <string>
#include <iostream>
#include "StackException.hpp"

using namespace std;

template <typename T> 
class Stack
{
private:
    class Node
    {
    public:
        T item;
        Node *next;
    };

    Node *first;

public:
    Stack();
    void push(T);
    T pop();
    bool isEmpty();
    //void size();

    void displayStack();
};

template <typename T> 
Stack<T>::Stack()
{
    first = nullptr;
}

template <typename T> 
void Stack<T>::push(T value)
{
    Node *oldFirst = first;
    first = new Node();

    first->item = value;
    first->next = oldFirst;
}

template <typename T> 
T Stack<T>::pop()
{
    if (isEmpty())
    {
        throw new StackException("Cannot pop an empty stack");
    }
    
    T value = first->item;
    Node *next = first->next;

    first->~Node();

    first = next;

    return value;
}

template <typename T> 
bool Stack<T>::isEmpty()
{
    return first == nullptr;
}

template <typename T> 
void Stack<T>::displayStack()
{
    Node *node = first;

    while (node != nullptr)
    {
        cout << node->item << " ";
        node = node->next;
    }
    cout << endl;
}

#endif