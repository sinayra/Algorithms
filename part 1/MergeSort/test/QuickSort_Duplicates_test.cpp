#include <iostream>
#include <vector>
#include <cassert>
#include "../QuickSort_Duplicates.hpp"

using namespace std;

bool isEqual(vector<int> arr1, vector<int> arr2)
{
    int size1 = arr1.size();
    int size2 = arr2.size();

    if (size1 != size2)
    {
        return false;
    }

    for (int i = 0; i < size1; i++)
    {
        if (arr1[i] != arr2[i])
        {
            return false;
        }
    }

    return true;
}

void test_quickSort()
{
    vector<int> arr{3, 2, 2, 5, 1, 3, 5, 9, 6, 9};
    vector<int> expected{1, 2, 2, 3, 3, 5, 5, 6, 9, 9};

    quickSort(arr);
    assert(isEqual(arr, expected));
}

int main()
{
    test_quickSort();

    return 0;
}