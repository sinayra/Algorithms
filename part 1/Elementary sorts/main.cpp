#include <iostream>
#include <cstdlib>
#include <ctime>
#include <string>
#include <vector>
#include "InsertionSort.hpp"

using namespace std;

double fRand(double fMin, double fMax)
{
    double f = (double)rand() / RAND_MAX;
    return fMin + f * (fMax - fMin);
}

void Experiment()
{
    int N;
    cin >> N;

    srand(time(nullptr));

    vector<double> arr(N);

    for (int i = 0; i < N; i++)
    {
        arr[i] = fRand(0, 1);
    }

    insertionSort(arr);

    for (int i = 0; i < N; i++)
    {
        cout << arr[i] << endl;
    }
}

void StringSorter()
{
    int N;
    cin >> N;

    vector<string> arr(N);

    for (int i = 0; i < N; i++)
    {
        cin >> arr[i];
    }

    insertionSort(arr);

    for (int i = 0; i < N; i++)
    {
        cout << arr[i] << endl;
    }

}

int main(){

    StringSorter();

    return 0;
}