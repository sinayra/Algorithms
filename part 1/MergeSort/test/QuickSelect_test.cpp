#include <iostream>
#include <vector>
#include <cassert>
#include "../QuickSelect.hpp"

using namespace std;


void test_quickSelect(){
    vector<int> arr {5, 3, 7, 1, 13, 17, 6, 9};

    int sixthSmallest = quickSelect(arr, 6 - 1);
    assert(9 == sixthSmallest);
}

int main(){
    test_quickSelect();

    return 0;
}