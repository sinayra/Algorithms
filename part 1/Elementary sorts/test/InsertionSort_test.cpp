#include <iostream>
#include <vector>
#include <cassert>
#include "../InsertionSort.hpp"

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

void test_insertionSort(){
    vector<int> arr {5, 3, 9, 1, 10, 2, 6, 4, 8, 7};
    vector<int> expected {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    insertionSort(arr);
    assert(isEqual(arr, expected));
}

void test_insertionSortSetStart(){
    vector<int> arr {5, 3, 9, 1, 10, 2, 6, 4, 8, 7};
    vector<int> expected1 {5, 2, 6, 1, 8, 3, 9, 4, 10, 7};
    vector<int> expected2 {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    insertionSortWithGap(arr, 4);
    assert(isEqual(arr, expected1));

    insertionSortWithGap(arr, 1);
    assert(isEqual(arr, expected2));
}

void test_insertionSortStartEnd(){
    vector<int> arr {5, 3, 9, 1, 10, 2, 6, 4, 8, 7};
    vector<int> expected {5, 3, 9, 1, 10, 2, 4, 6, 7, 8};

    insertionStartEnd(arr, 5, 9);
    assert(isEqual(arr, expected));
}

int main(){

    test_insertionSort();
    test_insertionSortSetStart();
    test_insertionSortStartEnd();

    return 0;
}