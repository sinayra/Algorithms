#ifndef UF_HPP
#define UF_HPP

#include <iostream>
#include <vector>
#include <stdexcept>
#include "PointException.hpp"

using namespace std;

class UF
{
private:
    vector<int> connections;
    vector<int> amount;

public:
    UF(int);
    void connect(int, int);
    bool isConnected(int, int);
    void showConnections();
    void showAmounts();
    int getRoot(int);

    int find(int);
};
#endif