#ifndef QUEUE_HPP
#define QUEUE_HPP

#include <iostream>
#include <vector>
#include <string>
#include <iostream>
#include "QueueException.hpp"

using namespace std;

template <typename T>
class Queue
{
private:
    class Node
    {
    public:
        T item;
        Node *next;
    };
    Node *first, *last;

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
    first = nullptr;
    last = nullptr;
}

template <typename T>
void Queue<T>::enqueue(T value)
{
    Node *old = last;

    last = new Node();

    last->item = value;
    last->next = nullptr;

    if (isEmpty())
    {
        first = last;
    }
    else
    {
        old->next = last;
    }
}

template <typename T>
T Queue<T>::dequeue()
{
    if (isEmpty())
    {
        throw new QueueException("Cannot dequeue an empty queue");
    }

    T value = first->item;
    Node *next = first->next;

    first->~Node();

    first = next;

    if (isEmpty())
    { //if now it turn empty
        last = nullptr;
    }

    return value;
}

template <typename T>
bool Queue<T>::isEmpty()
{
    return first == nullptr;
}

template <typename T>
void Queue<T>::displayQueue()
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