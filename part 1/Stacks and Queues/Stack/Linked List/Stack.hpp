#ifndef STACK_HPP
#define STACK_HPP

#include <iostream>
#include <vector>
#include <string>
#include <iostream>
#include "Node.hpp"
#include "ListIterator.hpp"
#include "Iterator.hpp"
#include "StackException.hpp"

using namespace std;

template <typename T> 
class Stack 
{
private:
    Node<T> *first;
    ListIterator<T> *it;

public:
    Stack();
    void push(T);
    T pop();
    bool isEmpty();
    //void size();

    Iterator<T> iterator();

    void displayStack();
};

template <typename T> 
Iterator<T> Stack<T>::iterator()
{
    if(it == nullptr){
        it = new ListIterator<T>(first);
    }

    return it;
}

template <typename T> 
Stack<T>::Stack()
{
    first = nullptr;
    it = nullptr;
}

template <typename T> 
void Stack<T>::push(T value)
{
    Node<T> *oldFirst = first;
    first = new Node<T>();

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
    Node<T> *next = first->next;

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
    Node<T> *node = first;

    while (node != nullptr)
    {
        cout << node->item << " ";
        node = node->next;
    }
    cout << endl;
}

#endif