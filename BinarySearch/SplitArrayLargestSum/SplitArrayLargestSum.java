package BinarySearch.SplitArrayLargestSum;

class Solution {
    public int splitArray(int[] nums, int k) {
        int n = nums.length;
        int low = 0;
        int high = 0;
        for(int i = 0;i<n;i++){
            low = Math.max(low,nums[i]);
            high +=nums[i];
        }
        int sum = 0;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(isMaxSumValid(mid,nums,k)){
                sum = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return sum;
    }
    //helper function to check isMaxSumValid
    public static boolean isMaxSumValid(int maxSum,int [] arr,int k){
        int totalSubarrays = 1;
        int i =0;
        int sum = 0;
        while(i < arr.length){
            if(arr[i]+sum > maxSum){
                sum = 0;
                totalSubarrays++;
                if(totalSubarrays > k)return false;
            }
            sum+=arr[i];
            i++;
        }
        return true;
    }
}
