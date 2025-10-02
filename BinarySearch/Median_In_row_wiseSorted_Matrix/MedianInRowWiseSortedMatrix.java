package BinarySearch.Median_In_row_wiseSorted_Matrix;

class Solution {
    public int median(int[][] mat) {
        // code here
        int n = mat.length;
        int m = mat[0].length;
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;
        for(int i = 0;i<n;i++){
            low = Math.min(mat[i][0],low);
            high = Math.max(mat[i][m-1],high);
        }
        int required = (m*n)/2;
        int res = -1;
        while(low <= high){
            int mid = low+(high-low)/2;
            if(smallesrNumbers(mat,n,m,mid) <= required){
                low = mid+1;
            }else{
                res = mid;
                high = mid-1;
            }
        }
        return res;
    }
    //helper function for this approch
        public static int smallesrNumbers(int [][] mat,int n,int m,int currentNumber){
        int total = 0;
        for(int [] arr : mat){
            if(currentNumber >= arr[arr.length-1]){
                total+= arr.length;
                continue;
            }
            //binary search
            int low = 0;
            int high = m-1;
            int count = 0;
            while(low <= high){
                int mid = low+(high-low)/2;
                if(arr[mid] <= currentNumber){
                    count = mid+1;
                    low = mid+1;
                }else{
                    high = mid-1;
                }
            }
            total+=(count);
        }
        return total;
    }
}
//                         l           
//Search Space: //1,2,3,4,5,6,7,8,9
//                        m h
// mid= (n*n)/2  // (9)/2 = 4

//  [[1, 3, 5], 
//   [2, 6, 9], 
//   [3, 6, 9]]

//l   
//2,3,4,5,6,7,8,9,10
//      h
// [[2, 4, 9],
// [3, 6, 7],
// [4, 7, 10]]

//   m  l 
// //1,2,3
//   h
// //required = 3/2 = 1;

// [[1],
//  [2],
//  [3]]
