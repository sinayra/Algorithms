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
    vector<T> max;
    int last, lastMax;

    bool isEmptyMax();
    void pushMax(T);
    void popMax(T);

public:
    [[deprecated("Replaced by Stack(), no need to pass capacity")]]
    Stack(int);

    Stack();
    void push(T);
    T pop();
    bool isEmpty();
    T returnTheMaximum();
    //void size();

    void displayStack();
};

template <typename T> 
Stack<T>::Stack()
{
    last = 0;
    arr.resize(1);

    lastMax = 0;
    max.resize(1);
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

    pushMax(value);
}

template <typename T> 
void Stack<T>::pushMax(T value)
{
    int size = max.size();
    T top;
    bool insertValue = false;

    if(!isEmptyMax())
    {
        top = returnTheMaximum();
        if(top <= value)
        {
            insertValue = true;
        }
    }
    else
    {
        insertValue = true;
    }

    if(insertValue)
    {
        if (lastMax == size - 1)
        {
            max.resize(2 * size);
        }

        arr[lastMax] = value;
        lastMax++;
    }

}

template <typename T> 
T Stack<T>::returnTheMaximum()
{
    if (isEmpty() )
    {
        throw new StackException("Stack is empty");
    }

    return max[lastMax - 1];
}

template <typename T> 
T Stack<T>::pop()
{
    int size = arr.size();

    if (isEmpty())
    {
        throw new StackException("Cannot pop an empty stack");
    }
    T value = arr[last - 1];

    if (last > 0 && last == size / 4)
    {
        arr.resize(size / 2);
    }

    last--;

    popMax(value);

    return value;
}

template <typename T> 
void Stack<T>::popMax(T value)
{
    int size = max.size();

    T top = returnTheMaximum();
    
    if(top == value){
        if (lastMax > 0 && lastMax == size / 4)
        {
            max.resize(size / 2);
        }

        lastMax--;
    }
}

template <typename T> 
bool Stack<T>::isEmpty()
{
    return last == 0;
}

template <typename T> 
bool Stack<T>::isEmptyMax()
{
    return lastMax == 0;
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