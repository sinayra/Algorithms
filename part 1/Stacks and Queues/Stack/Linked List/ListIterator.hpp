#ifndef LISTITERATOR_HPP
#define LISTITERATOR_HPP

#include <iostream>
#include <vector>
#include <string>
#include <iostream>

#include "Iterator.hpp"
#include "Node.hpp"
#include "StackException.hpp"

using namespace std;

//TO-DO Create a functional iterator

template <typename T> 
class ListIterator:Iterator<T>
{
    private:
        Node<T> *first;
    public:
        ListIterator(Node<T>*);
        T begin() = 0;
        T end() = 0;
};

template <typename T> 
ListIterator<T>::ListIterator(Node<T> *_first): first(_first)
{
}

template <typename T> 
T ListIterator<T>::begin()
{
    return first->item;
}

template <typename T> 
T ListIterator<T>::end()
{
    return nullptr;
}
#endif
