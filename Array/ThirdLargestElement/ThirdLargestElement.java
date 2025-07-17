//this solution allow duplicates

class Solution {
    int thirdLargest(int arr[]) {
        // Your code here
        int first = -1;
        int second = -1;
        int third = -1;
        int n = arr.length;
        for(int i = 0;i< n;i++){
          
            if(first < arr[i]){
                third = second;
                second = first;
                first = arr[i];
            }
            else if(arr[i] > second){
                third = second;
                second = arr[i];
            }
            else if(arr[i] > third){
                third = arr[i];
            }
        }
        return third;
    }
}