#ifndef SHELLSORT_HPP
#define SHELLSORT_HPP

#include <iostream>
#include <vector>
#include <string>
#include <iostream>
#include "InsertionSort.hpp"

using namespace std;

template <class T>
void shellSort(vector<T> &arr)
{
    int N = arr.size();
    int h = 1;

    while(h < N/3){
        h = 3*h + 1;
    }

    while(h >= 1){
        insertionSortWithGap(arr, h);
        h = h/3;
    }
}

#endif