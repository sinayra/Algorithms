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
    vector<T> arr;
    int head, tail;

public:
    Queue(int);
    void enqueue(T);
    T dequeue();
    bool isEmpty();
    //void size();

    void displayQueue();
};

template <typename T>
Queue<T>::Queue(int capacity)
{
    tail = 0;
    head = 0;
    arr.resize(capacity);
}

template <typename T>
void Queue<T>::enqueue(T value)
{
    tail++;

    if (tail == arr.size())
    {
        throw new QueueException("Full capacity reached");
    }

    arr[tail] = value;
}

template <typename T>
T Queue<T>::dequeue()
{
    if (isEmpty())
    {
        throw new QueueException("Cannot dequeue an empty queue");
    }
    
    T value = arr[head];
    arr[head] = 0;
    head++;
    
    return value;
}

template <typename T>
bool Queue<T>::isEmpty()
{
    return head == tail;
}

template <typename T>
void Queue<T>::displayQueue()
{
    int size = arr.size();
    for (int i = 0; i < size; i++)
    {
        cout << arr[i] << " ";
    }
    cout << endl;
}
#endif