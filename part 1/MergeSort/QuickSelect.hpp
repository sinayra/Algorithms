#ifndef QUICKSELECT_HPP
#define QUICKSELECT_HPP

#include <iostream>
#include <vector>
#include <string>
#include <iostream>
#include <cassert>
#include "./KnuthShuffle.hpp"

using namespace std;

template <class T>
int partition(vector<T> &arr, int lo, int hi)
{
    T aux;
    int i = lo, j = hi + 1;

    while(true)
    {
        i++;
        while(arr[i] < arr[lo])
        {
            if (i == hi)
            {
                break;
            }
            i++;
        }

        j--;
        while(arr[j] > arr[lo])
        {
            if (j == lo)
            {
                break;
            }
            j--;
        }

        if(i >= j)
        {
            break;
        }

        aux = arr[i];
        arr[i] = arr[j];
        arr[j] = aux;
    }

    aux = arr[j];
    arr[j] = arr[lo];
    arr[lo] = aux;

    return j;
}

template <class T>
T quickSelect(vector<T> &arr, int k)
{
    knuthShuffle(arr);
    int lo = 0, hi = arr.size() - 1;

    while(hi > lo){
        int j = partition(arr, lo, hi);
        if (j < k)
        {
            lo = j + 1;
        }
        else if (j > k)
        {
            hi = j - 1;
        }
        else {
            return arr[k];
        }
    }

    return arr[k];
}

#endif