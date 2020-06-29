#include "MySet.hpp"

MySet::MySet(int n)
{
    S.resize(n);
    for (int i = 0; i < n - 1; i++)
    {
        S[i] = i + 1;
    }
    S[n - 1] = n - 1;
}

int MySet::getSuccessor(int x)
{
    int size = S.size();
    int successor;

    if (x > size || x < 0)
    {
        throw MySetException("invalid element");
    }

    successor = S[x];

    
    if (successor < x || successor == 0)
    {
        throw MySetException("x was removed");
    }
    else if (successor == x)
    {
        throw MySetException("there is no successor for the last element");
    }

    return successor;
}

void MySet::remove(int x)
{
    int predecessor, successor;
    int size = S.size();

    if (x > size || x < 0)
    {
        throw MySetException("invalid element");
    }

    try
    {
        predecessor = getPredecessor(x);
    }
    catch (MySetException &e)
    {
        predecessor = x;
    }
    
    try
    {
        successor = getSuccessor(x);
    }
    catch (MySetException &e)
    {
        successor = predecessor;
    }

    S[predecessor] = successor;
    S[x] = predecessor;
}

int MySet::getPredecessor(int x)
{
    int predecessor;
    int size = S.size();

    if (x > size || x < 0)
    {
        throw MySetException("invalid element");
    }

    if (x == 0)
    {
        throw MySetException("no predecessor");
    }

    predecessor = x - 1;

    if (x != S[predecessor])
    {
        predecessor = S[predecessor];
    }

    return predecessor;
}