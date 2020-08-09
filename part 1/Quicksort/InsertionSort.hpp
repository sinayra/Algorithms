#ifndef INSERTIONSORT_HPP
#define INSERTIONSORT_HPP

#include <iostream>
#include <vector>
#include <string>
#include <iostream>

using namespace std;

template <class T>
void insertionSort(vector<T> &arr)
{
    int size = arr.size();

    for(int i = 1; i < size; i++){
        T key = arr[i];

        int j = i - 1;
        while(j >= 0 && arr[j] > key){
            arr[j + 1] = arr[j];
            j--;
        }

        arr[j + 1] = key;
    }
}

template <class T>
void insertionSortWithGap(vector<T> &arr, int gap)
{
    int size = arr.size();

    for(int i = gap; i < size; i++){
        T key = arr[i];

        int j = i;
        while(j >= gap && arr[j - gap] > key){
            arr[j] = arr[j - gap];
            j -= gap;
        }

        arr[j] = key;
    }
}

template <class T>
void insertionStartEnd(vector<T> &arr, int start, int end)
{

    for(int i = start + 1; i <= end; i++){
        T key = arr[i];

        int j = i - 1;
        while(j >= 0 && arr[j] > key){
            arr[j + 1] = arr[j];
            j--;
        }

        arr[j + 1] = key;
    }
}

#endif