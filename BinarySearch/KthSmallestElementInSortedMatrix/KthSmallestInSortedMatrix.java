package BinarySearch.KthSmallestElementInSortedMatrix;

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int m = matrix[0].length;
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;
        for(int i = 0;i<n;i++){
            low = Math.min(low,matrix[i][0]);
            high = Math.max(high,matrix[i][m-1]);
        }
        int res = -1;
        while(low <= high){
            int mid = low+(high-low)/2;
            if(SmallerElementCount(matrix,mid) < k){
                low = mid+1;
            }else{
                res = mid;
                high= mid-1;
            }
        }
        return res;
    }
    //hepler function used starcase method for counting the small numbers
    public static int SmallerElementCount(int [][]matrix,int currntNumber){
        int total = 0;
        int row = 0;
        int col = matrix[0].length-1;
        while(row <= matrix.length-1 && col >= 0){
            if(matrix[row][col] <= currntNumber){
                total+=(col+1);
                row++;
            }else{
                col--;
            }
        }
        return total;
    }
}

//nt k = 8
// [[1,5,9],
// [10,11,13],
// [12,13,15]]
