package BinarySearch.BinarySearchOnAnswers.FindTheSmallestDivisiorForTheGivenThreshold;

class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int low = 1;
        int high = Integer.MIN_VALUE;
        int res = -1;
        for(int num:nums){
            high = Math.max(num,high);
        }
        while(low<=high){
            int mid = low+(high-low)/2;
            if(sum(nums,mid) <= threshold){
                res = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return res;
    }
    public static int sum(int []arr,int divisor){
        int sum = 0;
        for(int i = 0;i<arr.length;i++){
            if(arr[i]%divisor == 0){
                sum+=arr[i]/divisor;
            }else{
                sum+=(arr[i]/divisor)+1;
            }
        }
        return sum;
    }
}
