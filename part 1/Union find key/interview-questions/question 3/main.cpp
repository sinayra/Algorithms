#include <iostream>
#include "MySet.hpp"
#include "MySetException.hpp"

using namespace std;
int main()
{
    int N;
    N = 10;

    MySet S(N);

    try
    {
        cout << "Remove 1" << endl;
        S.remove(1);
        cout << "Remove 3" << endl;
        S.remove(3);
        cout << "Remove 5" << endl;
        S.remove(5);
        cout << "Successor 0: " << S.getSuccessor(0) << endl;
        cout << "Successor 2: " << S.getSuccessor(2) << endl;
        cout << "Remove 4" << endl;
        S.remove(4);
        cout << "Successor 2: " << S.getSuccessor(2) << endl;

    }
    catch (MySetException &e)
    {
        cout << "Error: " << e.what() << endl;
    }

    return 0;
}