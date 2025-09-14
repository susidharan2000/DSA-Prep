package BinarySearch.BinarySearchOnAnswers.Find_nth_Root_m;

class Solution {
    public static int isValid(int num,int n){
        int ans = 1;
        for(int i = 0;i<n;i++){
            ans *= num;
        }
        return ans;
    }
    public int nthRoot(int n, int m) {
        // code here
        int low = 0;
        int high = m;
        while(low <= high){
            int mid = low+(high-low)/2;
            if(isValid(mid,n) == m)return mid;
            else if(isValid(mid,n) > m){
             high = mid-1;   
            }else{
                low = mid+1;
            }
        }
        return -1;
    }
}
