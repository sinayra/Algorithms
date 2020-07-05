#include <iostream>
#include <chrono>
#include <vector>

// Given N distinct integers, how many triples sum to exactly zero?

using namespace std;

void displayArr(vector<int> arr)
{
    int size = arr.size();

    for (int i = 0; i < size; i++)
    {
        cout << arr[i] << "\t";
    }
    cout << endl;
}

int getZeroTriplets(vector<int> arr)
{
    int size = arr.size();
    int count = 0;

    for (int i = 0; i < size; i++)
    {
        for (int j = i + 1; j < size; j++)
        {
            for (int k = j + 1; k < size; k++)
            {
                if (arr[i] + arr[j] + arr[k] == 0)
                {
                    count++;
                }
            }
        }
    }

    return count;
}

int main()
{
    int n;
    chrono::steady_clock::time_point start, end;

    cin >> n;
    vector<int> arr(n);

    for (int i = 0; i < n; i++)
    {
        cin >> arr[i];
    }

    start = chrono::steady_clock::now();

    cout << getZeroTriplets(arr) << endl;

    end = chrono::steady_clock::now();

    cout << "Elapsed time: " << chrono::duration_cast<chrono::nanoseconds>(end - start).count() << "ns";

    return 0;
}