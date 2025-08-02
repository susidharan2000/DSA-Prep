package Array.ReversePairs;

import java.util.*;

class Solution {
    public static int getReverseCount(int low,int high,int []nums){
        int count = 0;
        if(low >= high)return count;
        int mid = (low+high)/2;
        int leftcount = getReverseCount(low,mid,nums);//2
        int rightcount = getReverseCount(mid+1,high,nums);//0
        count = leftcount+rightcount;//2
        count +=merge(low,mid,high,nums);//0
        return count;//2
    }
    public static int  merge(int low,int mid,int high,int [] nums){
        List<Integer> temp = new ArrayList<>();
        int left = low;
        int right = mid+1;
        int count = 0;
        //et count 
        int r = mid+1;
        for(int l = low;l<=mid;l++){
            while(r<=high && (long)nums[l] > 2L*nums[r]){
                r++;
            }
            count += r - (mid+1);
    }
        while(left <= mid && right <= high){
            if(nums[left]<=nums[right]){
                temp.add(nums[left++]);
            }else{
                temp.add(nums[right++]);
            }
        }
        while(left <= mid){
            temp.add(nums[left++]);
        }
        while(right <= high){
            temp.add(nums[right++]);
        }
        //
        for(int i = 0;i<temp.size();i++){
            nums[i+low] = temp.get(i);
        }
        return count;
    }
    public int reversePairs(int[] nums) {
       return getReverseCount(0,nums.length-1,nums);
    }
}
