class Solution {
    public int getSecondLargest(int[] arr) {
        // code here
        int largest = -1;
        int second = -1;
        for(int i = 0;i<arr.length;i++){
            if(largest<arr[i]){
                second = largest;
                largest = arr[i];
            }else if(largest > arr[i] && second < arr[i]){
                second = arr[i];
            }
        }
        return second;
    }
}