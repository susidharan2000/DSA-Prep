package BinarySearch.Minimum_days_to_make_M_Bouquets;

class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        int low = 1;
        int high = Integer.MIN_VALUE;
        int res = -1;
        for(int day:bloomDay){
            high = Math.max(day,high);
        }
        while(low <= high){
            int mid = low+(high-low)/2;
            if(totalBouquets(bloomDay,mid,k) >= m){
                res = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return res;
    }
    //helper function to get the total Bouquets can made till that day
    public static int totalBouquets(int [] arr,int day,int k){
        int totalBouquets = 0;
        int count = 0;
        for(int i = 0;i<arr.length;i++){
            if(arr[i] <= day){
                count++;
            }else{
                count = 0;
            }
            if(count == k){
                totalBouquets++;
                count = 0;
            }
        }
        return totalBouquets;
    }
}