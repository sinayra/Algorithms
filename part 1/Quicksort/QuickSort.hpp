#ifndef QUICKSORT_HPP
#define QUICKSORT_HPP

#include <iostream>
#include <vector>
#include <string>
#include <iostream>
#include <cassert>
#include "./KnuthShuffle.hpp"

#include "./InsertionSort.hpp"
#define CUTOFF 10

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
void sort(vector<T> &arr, int lo, int hi)
{
    if (hi > lo)
    {
        if (hi <= lo + CUTOFF - 1)
        {
            insertionStartEnd(arr, lo, hi);
        }
        else
        {
            int m = (lo + (lo + (hi - lo)/2) + hi)/3;
            T aux = arr[lo];
            arr[lo] = arr[m];
            arr[m] = aux;

            int j = partition(arr, lo, hi);
            sort(arr, lo, j - 1);
            sort(arr, j + 1, hi);
        }
        
    }
}

template <class T>
void quickSort(vector<T> &arr)
{
    knuthShuffle(arr);
    sort(arr, 0, arr.size() - 1);
}

#endif