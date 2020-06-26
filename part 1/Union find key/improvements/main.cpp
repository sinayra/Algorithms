#include <iostream>
#include "UF.hpp"
#include "PointException.hpp"

using namespace std;
int main()
{
    int N, M;
    int p, q;
    cin >> N >> M;

    UF uf(N);
    for (int i = 0; i < M; i++)
    {
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

    cin >> p >> q;
    cout << uf.isConnected(p, q) << endl;

     uf.showConnections();
     uf.showAmounts();

    return 0;
}