#include "UF.hpp"

UF::UF(int n)
{
    connections.resize(n);
    amount.resize(n);
    for (int i = 0; i < n; i++)
    {
        connections[i] = i;
        amount[i] = 1;
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

    if(rootP != rootQ){
        if(amount[rootP] < amount[rootQ]){
            connections[rootP] = rootQ;
            amount[rootQ] += amount[rootP];
        }
        else{
            connections[rootQ] = rootP;
            amount[rootP] += amount[rootQ];
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

    return getRoot(p) == getRoot(q);
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

void UF::showAmounts()
{
    int size = amount.size();

    for (int i = 0; i < size; i++)
    {
        cout << amount[i] << " ";
    }
    cout << endl;
}

int UF::getRoot(int n){
    int root = connections[n];

    while(n != root){
        connections[n] = connections[root];
        
        n = root;
        root = connections[n];
    }

    return root;
}