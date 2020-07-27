#ifndef MERGESORTBU_HPP
#define MERGESORTBU_HPP

#include <iostream>
#include <vector>
#include <string>
#include <iostream>
#include <cassert>

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
void merge(vector<T> &arr, int lo, int mid, int hi)
{
    assert(isSorted(arr, lo, mid));
    assert(isSorted(arr, mid + 1, hi));

    vector<T> aux(arr);
    int i = lo, j = mid + 1;
    for(int k = lo; k <= hi; k++){

        if(i > mid){
            arr[k] = aux[j++];
        }
        else if (j > hi){
            arr[k] = aux[i++];
        }
        else if(aux[i] > aux[j]){
            arr[k] = aux[j++];
        }
        else {
            arr[k] = aux[i++];
        }
    }

    assert(isSorted(arr, lo, hi));
}

template <class T>
void sort(vector<T> &arr)
{
    int N = arr.size();

    for(int size = 1; size < N; size = size + size){
        for(int lo = 0; lo < N - size; lo += size + size){
            int min = (N - 1 < lo + size + size - 1 ? N - 1 : lo + size + size - 1);
            merge(arr, lo, lo + size - 1, min);
        }
    }

}

template <class T>
void mergeSortBU(vector<T> &arr)
{
    sort(arr);
}

#endif