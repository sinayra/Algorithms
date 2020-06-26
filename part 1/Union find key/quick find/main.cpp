#include <iostream>
#include "UF.hpp"
#include "PointException.hpp"

using namespace std;
int main()
{
    int N, M;
    cin >> N;
    cin >> M;

    UF uf(N);
    for (int i = 0; i < M; i++)
    {
        int p, q;
        cin >> p >> q;

        try
        {
            if (!uf.isConnected(p, q))
            {
                cout << "Connecting: " << p << "->" << q << endl;
                uf.connect(p, q);
            }
        }
        catch (PointException &e)
        {
            cout << "Error: " << e.what() << endl;
        }
    }

    uf.showConnections();

    return 0;
}