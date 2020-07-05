#include <iostream>
#include <chrono>
#include <vector>

// Given a sorted array and a key, find index of the key in the array

using namespace std;

void displayArr(vector<int> arr){
    int size = arr.size();

    for(int i = 0; i < size; i++){
        cout << arr[i] << "\t";
    }
    cout << endl;
}

int binarySearch(vector<int> arr, int key){
    int low = 0;
    int high = arr.size() - 1;
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


int main(){
    int n, key;
    chrono::steady_clock::time_point start, end;
    

    cin >> n;
    vector<int> arr(n);

    for(int i = 0; i < n; i++){
        cin >> arr[i];
    }

    cin >> key;

    start = chrono::steady_clock::now();

    cout << binarySearch(arr, key) << endl;

    end = chrono::steady_clock::now();

    cout << "Elapsed time: " << chrono::duration_cast<chrono::nanoseconds>(end - start).count() << "ns";

    return 0;
}