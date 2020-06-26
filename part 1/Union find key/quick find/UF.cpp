#include "UF.hpp"

UF::UF(int n)
{
    connections.resize(n);
    for (int i = 0; i < n; i++)
    {
        connections[i] = i;
    }
}

void UF::connect(int p, int q)
{
    int size = connections.size();
    int lowerGroup, higherGroup;

    if (p > size || q > size || p < 0 || q < 0)
    {
        throw PointException("invalid points to connect");
    }

    if (connections[p] == connections[q])
    {
        throw PointException("points are already connected");
    }

    if (connections[p] < connections[q])
    {
        lowerGroup = connections[p];
        higherGroup = connections[q];
    }
    else
    {
        lowerGroup = connections[q];
        higherGroup = connections[p];
    }

    for (int i = 0; i < size; i++)
    {
        if (connections[i] == higherGroup)
        {
            connections[i] = lowerGroup;
        }
    }
}

bool UF::isConnected(int p, int q)
{
    int size = connections.size();

    if (p > size || q > size || p < 0 || q < 0)
    {
        throw PointException("invalid points to connect");
    }

    return connections[p] == connections[q];
}

void UF::showConnections()
{
    int size = connections.size();

    for (int i = 0; i < size; i++)
    {
        cout << connections[i] << " ";
    }
    cout << endl;
}