package Array.FourSum;
import java.util.*;
//brute force algorithm. ------O(n^4)
// class Solution {
//     public List<List<Integer>> fourSum(int[] nums, int target) {
//         List<List<Integer>> res = new ArrayList<>();
//         Arrays.sort(nums);
//         int n = nums.length;
//         for(int i = 0;i<n;i++){
//             if(i>0 && nums[i] == nums[i-1])continue; // skip the duplicates
//             for(int j = i+1;j<n;j++){
//                 if(j>i+1 && nums[j] == nums[j-1])continue; // skip the duplicates
//                 for(int k = j+1;k<n;k++){
//                     if(k>j+1 && nums[k] == nums[k-1])continue; // skip the duplicates
//                     for(int l = k+1;l<n;l++){
//                         if(l>k+1 && nums[l] == nums[l-1])continue; // skip the duplicates
//                         long sum =(long) nums[i]+nums[j]+nums[k]+nums[l];
//                         if(sum == target){
//                             res.add(new ArrayList<>(Arrays.asList(nums[i],nums[j],nums[k],nums[l])));
//                         }
//                     }
//                 }
//             }
//         }
//         return res;
//     }
// }
//target = 0
//i
//[1,0,-1,0,-2,2]
//.  j. k       
//             l   





//optimal solution the time complixity is O(n^3)
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0;i<n;i++){
            if(i > 0 && nums[i] == nums[i-1])continue; // skip the duplicates
            for(int j = i+1;j<n;j++){
                if(j > i+1 && nums[j] == nums[j-1])continue; // skip the duplicates
                int left = j+1;
                int right = n-1;
                while(left < right){
                    long sum = (long)nums[i]+nums[j]+nums[left]+nums[right];
                    if(sum == target){
                        res.add(new ArrayList<>(Arrays.asList(nums[i],nums[j],nums[left],nums[right])));
                        left++;
                        right--;
                        while(left < right && nums[left] == nums[left-1])left++; // skip the duplicates
                        while(left < right && nums[right] == nums[right+1])right--; // skip the duplicates
                    }else if(sum < target){
                        left++;
                    }else{
                        right--;
                    }
                }
        }
        }
        return res;
    }
}
//  i   j       r
// [0,0,0,0,0,0,0,0,0,0]
//              l              
