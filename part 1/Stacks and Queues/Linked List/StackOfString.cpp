#include "StackOfString.hpp"

StackOfString::StackOfString()
{
    first = nullptr;
}

void StackOfString::push(string value)
{
    Node *oldFirst = first;
    first = new Node();

    first->item.assign(value);
    first->next = oldFirst;
}

string StackOfString::pop()
{
    if (isEmpty())
    {
        throw new StackException("Cannot pop an empty stack");
    }
    
    string value = first->item;
    Node *next = first->next;

    first->~Node();

    first = next;

    return value;
}

bool StackOfString::isEmpty()
{
    return first == nullptr;
}

void StackOfString::displayStack()
{
    Node *node = first;

    while (node != nullptr)
    {
        cout << node->item << " ";
        node = node->next;
    }
    cout << endl;
}
