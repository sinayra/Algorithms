/*
Hint: 3-way partitioning.
*/
#include <iostream>
#include <vector>
#include <string>

#include <cstdlib>
#include <ctime>

#include <cassert>

using namespace std;

int colorCount = 0;
int swapCount = 0;

char color(vector<char> arr, int i)
{
    colorCount++;
    return arr[i];
}

void swap(vector<char> &arr, int i, int j)
{
    swapCount++;
    char aux = arr[i];
    arr[i] = arr[j];
    arr[j] = aux;
}

void displayArr(vector<char> arr)
{
    int size = arr.size();
    for (int i = 0; i < size; i++)
    {
        cout << arr[i] << " ";
    }
    cout << endl;
}

void moveStartPointer(vector<char> &arr, int *i, int *j)
{
    char c = color(arr, *i);

    while (c != 'r')
    {
        if (c == 'b')
        {
            (*i)++;
        }
        else if (c == 'w')
        {
            swap(arr, *i, *j);
            (*j)--;
        }
        c = color(arr, *i);
    }
}

void moveEndPointer(vector<char> &arr, int *i, int *j, bool moveStart)
{
    char c = color(arr, *j);

    while (c != 'r')
    {
        if (c == 'w')
        {
            (*j)--;
        }
        else if (c == 'b')
        {
            swap(arr, *i, *j);
            (*i)++;
            if (moveStart)
            {
                moveStartPointer(arr, i, j);
            }
            break; //swap with i that has a red position
        }
        c = color(arr, *j);
    }
}

vector<char> generateRandomBuckets(int *j)
{
    int n;
    char flag[4] = {'r', 'w', 'b'};

    srand(time(nullptr));

    n = rand() % 10000 + 1;
    vector<char> arr(n);

    for (int i = 0; i < n; i++)
    {
        arr[i] = flag[rand() % 3];
    }

    (*j) = n - 1;

    return arr;
}

int main()
{

    int testcases;

    cin >> testcases;
    for (int test = 0; test < testcases; test++)
    {
        int i, j;

        colorCount = 0;
        swapCount = 0;
        vector<char> arr = generateRandomBuckets(&j);
        vector<char> arrclone = arr;
        int n = arr.size();
        i = 0;


        moveStartPointer(arr, &i, &j);
        moveEndPointer(arr, &i, &j, true);

        for (int k = i + 1; k < j && i < j && j > 0; k++)
        {
            char c = color(arr, k);
            if (c == 'b')
            {
                swap(arr, k, i);
                i++;
            }
            else if (c == 'w')
            {
                swap(arr, k, j);
                j--;
                moveEndPointer(arr, &i, &j, false);
            }
        }

        if(colorCount > n + 1 || swapCount > n + 1){
            displayArr(arrclone);
            cout << "N: " << n << endl;
            cout << "Color: " << colorCount << endl;
            cout << "Swap: " << swapCount << endl;
        }
        assert(colorCount <= n + 1);
        assert(swapCount <= n + 1);
    }

    return 0;
}