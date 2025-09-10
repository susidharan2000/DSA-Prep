package BinarySearch.FindMinimumInRotatedSortedArray;

class Solution {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length-1;
        int minVal = Integer.MAX_VALUE;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(nums[low] <= nums[mid]){
                minVal = Math.min(minVal,nums[low]);
                low = mid+1;
            }else{
                minVal = Math.min(minVal,nums[mid]);
                high = mid-1;
            }
        }
        return minVal;
    }
}
