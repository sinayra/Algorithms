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
    int rootP, rootQ;

    if (p > size || q > size || p < 0 || q < 0)
    {
        throw PointException("invalid points to connect");
    }

    if (connections[p] == connections[q])
    {
        throw PointException("points are already connected");
    }

    rootP = getRoot(p);
    rootQ = getRoot(q);

    connections[rootP] = rootQ;
}

bool UF::isConnected(int p, int q)
{
    int size = connections.size();

    if (p > size || q > size || p < 0 || q < 0)
    {
        throw PointException("invalid points to connect");
    }

    int rootP = getRoot(p), rootQ = getRoot(q);

    return rootP == rootQ;
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

int UF::getRoot(int n){
    int root = connections[n];

    while(n != root){
        n = root;
        root = connections[n];
    }

    return root;
}