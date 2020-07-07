#include "StackOfString.hpp"

StackOfString::StackOfString()
{
    last = 0;
    arr.resize(1);
}

void StackOfString::push(string value)
{
    int size = arr.size();

    if (last == size - 1)
    {
        arr.resize(2 * size);
    }

    arr[last].assign(value);
    last++;
}

string StackOfString::pop()
{
    int size = arr.size();

    if (isEmpty())
    {
        throw new StackException("Cannot pop an empty stack");
    }
    string s = arr[last - 1];

    if (last > 0 && last == size / 4)
    {
        arr.resize(size / 2);
    }

    arr[last - 1] = "\0";
    last--;

    return s;
}

bool StackOfString::isEmpty()
{
    return last == 0;
}

void StackOfString::displayStack()
{
    for (int i = last; i >= 0; i--)
    {
        cout << arr[i] << " ";
    }
    cout << endl;
}
