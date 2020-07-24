#ifndef KNUTHSHUFFLE_HPP
#define KNUTHSHUFFLE_HPP

#include <iostream>
#include <vector>
#include <string>
#include <iostream>
#include <cstdlib>
#include <ctime>

using namespace std;

template <class T>
void knuthShuffle(vector<T> &arr)
{
    int size = arr.size();
    
    for(int i = 0; i < size; i++){
        int r = rand() % (i + 1);

        int aux = arr[i];
        arr[i] = arr[r];
        arr[r] = arr[i];
    }

#endif