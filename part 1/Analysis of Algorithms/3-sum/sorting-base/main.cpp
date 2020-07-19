#include <iostream>
#include <chrono>
#include <vector>

// Given N distinct integers, how many triples sum to exactly zero?

using namespace std;

void displayArr(vector<int> arr)
{
    int size = arr.size();

    for (int i = 0; i < size; i++)
    {
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

void insertionSort(vector<int> &arr){
    int size = arr.size();

    for(int i = 1; i < size; i++){
        int key = arr[i];

        int j = i - 1;
        while(j >= 0 && arr[j] > key){
            arr[j + 1] = arr[j];
            j--;
        }

        arr[j + 1] = key;
    }
}

int getZeroTriplets(vector<int> arr)
{
    int size = arr.size();
    int count = 0;

    insertionSort(arr);

    for(int i = 0; i < size; i++){
        for(int j = i + 1; j < size; j++){
            
            int key = (arr[i] + arr[j]) * -1;

            if(key > arr[j] && binarySearch(arr, key) != -1){
                count++;
            }
        }
    }

    return count;
}

int main()
{
    int n;
    chrono::steady_clock::time_point start, end;

    cin >> n;
    vector<int> arr(n);
    vector<int> triple(3);

    for (int i = 0; i < n; i++)
    {
        cin >> arr[i];
    }

    start = chrono::steady_clock::now();

    cout << getZeroTriplets(arr) << endl;

    end = chrono::steady_clock::now();

    cout << "Elapsed time: " << chrono::duration_cast<chrono::nanoseconds>(end - start).count() << "ns";

    return 0;
}