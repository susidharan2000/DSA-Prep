class Solution {
    // Function to sort an array using quick sort algorithm.
    static void quickSort(int arr[], int low, int high) {
        // code here
        if(low >= high)return;
        int pi = partition(arr,low,high);
        quickSort(arr,low,pi-1);
        quickSort(arr,pi+1,high);
    }
    static void swap(int i,int j,int []arr){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    static int partition(int arr[], int low, int high) {
        int pivot = arr[high];
        int i = low-1;
        for(int j = low;j< high;j++){
            if(arr[j]<=pivot){
                i++;
                swap(i,j,arr);
            }
        }
        swap(i+1,high,arr); //place pivot to it's right postion
        return i+1; // return pivot index
    }
}