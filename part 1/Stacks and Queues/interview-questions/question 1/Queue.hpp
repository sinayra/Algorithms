#ifndef QUEUE_HPP
#define QUEUE_HPP

#include <iostream>
#include <vector>
#include <string>
#include <iostream>

#include "Stack.hpp"
using namespace std;

template <typename T>
class Queue
{
private:
    Stack<T> A, B;

    void rebalanceQueues(Stack<T>, Stack<T>);
public:
    Queue();
    void enqueue(T);
    T dequeue();
    bool isEmpty();
    //void size();

    void displayQueue();
};

template <typename T>
Queue<T>::Queue()
{
    A = new Stack<>();
}

template <typename T>
void Queue<T>::rebalanceQueues(Stack<T> A, Stack<T> B)
{

    while (!A.isEmpty())
    {
        B.push(A.pop());
    }

}

template <typename T>
void Queue<T>::enqueue(T item)
{
    rebalanceQueues(B, A);

    A.push(item);

}

template <typename T>
T Queue<T>::dequeue()
{
    T item;

    rebalanceQueues(A, B);

    item = B.pop();

    return item;
}

template <typename T>
bool Queue<T>::isEmpty()
{
    return (A.isEmpty() ? B.isEmpty() : false);
}

#endif