#include <iostream>
#include <vector>
#include <cassert>
#include "../QuickSort.hpp"

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

void test_quickSort1(){
    vector<int> arr {5, 3, 9, 1, 10, 2, 6, 4, 8, 7};
    vector<int> expected {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    quickSort(arr);
    assert(isEqual(arr, expected));
}

void test_quickSort2(){
    vector<int> arr {5, 3, 9, 15, 10, 2, 6, 4, 8, 7, 14, 12, 20, 11, 18, 19, 16, 13, 1, 17};
    vector<int> expected {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};

    quickSort(arr);
    assert(isEqual(arr, expected));
}

int main(){
    test_quickSort1();
    test_quickSort2();

    return 0;
}