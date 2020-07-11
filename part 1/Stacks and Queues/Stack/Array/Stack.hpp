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
    vector<T> arr;
    int last;

public:
    [[deprecated("Replaced by Stack(), no need to pass capacity")]]
    Stack(int);

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
    last = 0;
    arr.resize(1);
}

template <typename T> 
void Stack<T>::push(T value)
{
    int size = arr.size();

    if (last == size - 1)
    {
        arr.resize(2 * size);
    }

    arr[last] = value;
    last++;
}
template <typename T> 
T Stack<T>::pop()
{
    int size = arr.size();

    if (isEmpty())
    {
        throw new StackException("Cannot pop an empty stack");
    }
    T s = arr[last - 1];

    if (last > 0 && last == size / 4)
    {
        arr.resize(size / 2);
    }

    arr[last - 1] = "\0";
    last--;

    return s;
}

template <typename T> 
bool Stack<T>::isEmpty()
{
    return last == 0;
}

template <typename T> 
void Stack<T>::displayStack()
{
    for (int i = last; i >= 0; i--)
    {
        cout << arr[i] << " ";
    }
    cout << endl;
}
#endif