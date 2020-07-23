#ifndef SELECTIONSORT_HPP
#define SELECTIONSORT_HPP

#include <iostream>
#include <vector>
#include <string>
#include <iostream>

using namespace std;

template <class T>
void selectionSort(vector<T> &arr)
{
    int size = arr.size();

    for(int i = 0; i < size; i++){
        T min = i;

        for(int j = i + 1; j < size; j++){
            if(arr[j] < arr[min]){
                min = j;
            }
        }
        T aux = arr[i];
        arr[i] = arr[min];
        arr[min] = aux;
    }
}

#endif