package Array.LongestConsecutiveSequance;
import java.util.*;
class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0)return 0;
     Set<Integer> set= new HashSet<>();
     for(int num:nums){
        set.add(num);
     }
     int maxCount = 1;
     for(int ele:set){
        int count = 1;
        if(set.contains(ele-1))continue;// mid of seqiance
        while(set.contains(ele+1)){
            count++;
            ele = ele+1;
        }
        maxCount = Math.max(count,maxCount);
     }
     return maxCount;
    }
}
//tc = O(n)+O(n)
//sc = O(n)
// // better solution
//.                     i         
//. {6,4,3,7,9,5,-1,8,0,1}

// 3,4,5,6,7,8,9
// if(!map.contains(ele-1)){
// while(set.contains(ele+1)){
//     count++;
//     ele = ele+1;
// }
// }
// count = 7
// maxCount =7






//beter solution force
class Solution1 {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0)return 0;
     int count  = 1;
     int maxCount = 1;
     Arrays.sort(nums);
     for(int i =1;i<nums.length;i++){
        if(nums[i] == nums[i-1])continue;
        if(nums[i] == nums[i-1]+1){
            count++;
        }else{
            count = 1;
        }
        maxCount = Math.max(count,maxCount);
     }
     return maxCount;
    }
}
//time complixity: O(n log n)+o(n);
// space complixity : O(1);

//.                      i
// -1,-1,0,1,3,4,5,6,7,8,9
//count = 7
//max =7
  
