#ifndef MERGESORT_HPP
#define MERGESORT_HPP

#include <iostream>
#include <vector>
#include <string>
#include <iostream>
#include <cassert>

#include "./InsertionSort.hpp"
#define CUTOFF 7

using namespace std;

template <class T>
bool isSorted(vector<T> arr, int lo, int hi)
{
    for(int i = lo + 1; i < hi; i++){
        if(arr[i - 1] > arr[i]){
            return false;
        }
    }
    return true;
}

template <class T>
void merge(vector<T> &arr, vector<T> &aux, int lo, int mid, int hi)
{
    assert(isSorted(arr, lo, mid));
    assert(isSorted(arr, mid + 1, hi));

    int i = lo, j = mid + 1;
    for(int k = lo; k <= hi; k++){

        if(i > mid){
            aux[k] = arr[j++];
        }
        else if (j > hi){
            aux[k] = arr[i++];
        }
        else if(arr[i] > arr[j]){
            aux[k] = arr[j++];
        }
        else {
            aux[k] = arr[i++];
        }
    }

    assert(isSorted(aux, lo, hi));
}

template <class T>
void sort(vector<T> &arr, vector<T> &aux, int lo, int hi)
{
    if (hi > lo)
    {
        if(hi <= lo + CUTOFF - 1){
            insertionStartEnd(aux, lo, hi);
        }
        else{
            int mid = lo + (hi - lo)/2;

            sort(aux, arr, lo, mid);
            sort(aux, arr, mid + 1, hi);
            if(aux[mid] > aux[mid + 1]){
                merge(arr, aux, lo, mid, hi);
            }
        }
    }
}

template <class T>
void mergeSort(vector<T> &arr)
{
    vector<T> aux(arr);
    sort(aux, arr, 0, arr.size() - 1);
}

#endif