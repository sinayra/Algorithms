#include <iostream>
#include <vector>
#include <cassert>
#include "../SelectionSort.hpp"

using namespace std;

bool isEqual(vector<int> arr1, vector<int> arr2){
    int size1 = arr1.size();
    int size2 = arr2.size();

    if(size1 != size2){
        return false;
    }

    for(int i = 0; i < size1; i++){
        if(arr1[i] != arr2[i]){
            return false;
        }
    }

    return true;
}

void test_selectionSort(){
    vector<int> arr {5, 3, 9, 1, 10, 2, 6, 4, 8, 7};
    vector<int> expected {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    selectionSort(arr);
    assert(isEqual(arr, expected));
}


int main(){

    test_selectionSort();

    return 0;
}