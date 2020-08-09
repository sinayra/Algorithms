#ifndef QUICKSORTDUPLICATES_HPP
#define QUICKSORTDUPLICATES_HPP

#include <iostream>
#include <vector>
#include <string>
#include <iostream>
#include <cassert>
#include "./KnuthShuffle.hpp"

using namespace std;

template <class T>
void swap(vector<T> &arr, int i, int j)
{
    T aux = arr[i];
    arr[i] = arr[j];
    arr[j] = aux;
}

template <class T>
void sort(vector<T> &arr, int lo, int hi)
{
    if (hi > lo)
    {

        int lt = lo, gt = hi;
        T v = arr[lo];
        int i = lo;

        while (i <= gt)
        {
            if (arr[i] < v)
            {
                swap(arr, lt, i);
                lt++;
                i++;
            }
            else if (arr[i] > v)
            {
                swap(arr, i, gt);
                gt--;
            }
            else
            {
                i++;
            }
        }

        sort(arr, lo, lt - 1);
        sort(arr, gt + 1, hi);
    }
}

template <class T>
void quickSort(vector<T> &arr)
{
    knuthShuffle(arr);
    sort(arr, 0, arr.size() - 1);
}

#endif