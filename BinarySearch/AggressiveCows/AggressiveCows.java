package BinarySearch.AggressiveCows;

import java.util.Arrays;

class Solution {
    public int aggressiveCows(int[] stalls, int k) {
        // code here
        int n = stalls.length;
        Arrays.sort(stalls);
        int low = 1;
        int high = stalls[n-1];
        int res= -1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(isPossibleToPlaceCows(stalls,mid,k)){
                res = mid;
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return res;
    }
    //hepler finction to place the cows
    public static boolean isPossibleToPlaceCows(int [] stalls,int distance,int k){
        k = k-1;//because the first cow allwauys take the first place
        int cowPos = 0;// traks the cow position 
        for(int i = 1;i<stalls.length;i++){
            if(stalls[i]-stalls[cowPos] >= distance){
                k--;
                cowPos = i;
            }
            if(k <= 0)return true;//means all cow are placed
        }
        return false;
    }
}
