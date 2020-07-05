#include <iostream>
#include <vector>

using namespace std;

/*
*
*   Search in a bitonic array. An array is bitonic if it is comprised of an increasing sequence of integers followed 
*   immediately by a decreasing sequence of integers. Write a program that, given a bitonic array of n distinct integer 
*   values, determines whether a given integer is in the array.
*
*/

void displayArr(vector<int> arr){
    int size = arr.size();

    for(int i = 0; i < size; i++){
        cout << arr[i] << "\t";
    }
    cout << endl;
}

int binarySearchIncreasing(vector<int> arr, int key, int start, int end){
    int low = start;
    int high = end;
    int mid = low + (high - low)/2;

    while(low <= high){
        if(arr[mid] == key){ // found key
            return mid;
        }
        else if(arr[mid] > key){ //key is less than mid
            high = mid - 1;
        }
        else{ //key is greater than mid
            low = mid + 1;
        }

        mid = low + (high - low)/2;
    }

    return -1;
}

int binarySearchDecreasing(vector<int> arr, int key, int start, int end){
    int low = start;
    int high = end;
    int mid = low + (high - low)/2;

    while(low <= high){
        if(arr[mid] == key){ // found key
            return mid;
        }
        else if(arr[mid] < key){ //key is greater than mid
            high = mid - 1;
        }
        else{ //key is less than mid
            low = mid + 1;
        }

        mid = low + (high - low)/2;
    }

    return -1;
}

int splitBitonic(vector<int> arr){
    int low = 0;
    int high = arr.size() - 1;
    int mid = low + (high - low)/2;

    while(low <= high){
        if(arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]){
            return mid;
        }
        else if(arr[mid] < arr[mid + 1]){
            low = mid + 1;
        }
        else if(arr[mid] < arr[mid - 1]){
            high = mid - 1;
        }

        mid = low + (high - low)/2;
    }

    return -1;
}

int bitonicSearch(vector<int> arr, int key)
{   
    int mid = splitBitonic(arr);
    
    if(mid > -1){
        int index = binarySearchIncreasing(arr, key, 0, mid);
        if(index == -1){
            index = binarySearchDecreasing(arr, key, mid + 1, arr.size() - 1);
        }

        return index;
    }

    return binarySearchDecreasing(arr, key, 0, arr.size() - 1);
}


int main(){
    int n, key;
    

    cin >> n;
    vector<int> arr(n);

    for(int i = 0; i < n; i++){
        cin >> arr[i];
    }

    cin >> key;

    cout << bitonicSearch(arr, key) << endl;

    return 0;
}