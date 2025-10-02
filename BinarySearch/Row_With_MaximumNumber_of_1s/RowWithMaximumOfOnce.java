package BinarySearch.Row_With_MaximumNumber_of_1s;

class Solution {
    public int[] rowAndMaximumOnes(int[][] mat) {
        int index = -1;
        int maxCount = -1;
        for(int i = 0;i<mat.length;i++){
            int []arr = mat[i];
            int count = 0;
            for(int j = 0;j<arr.length;j++){
                if(arr[j] == 1)count++;
            }
            if(count > maxCount){
                maxCount = count;
                index = i;
            }
        }
        return  new int []{index,maxCount};
    }
}