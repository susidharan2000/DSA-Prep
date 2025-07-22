package Array.ThreeSum;
import java.util.*;
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0;i< nums.length;i++){
            if(i>0 && nums[i] == nums[i-1])continue; //skips the duplicates
            int j = i+1;
            int k = nums.length-1;
            while(j<k){
                int sum = nums[i]+nums[j]+nums[k];
                if(sum == 0){
                    res.add(new ArrayList<>(Arrays.asList(nums[i],nums[j],nums[k])));
                    j++;
                    k--;
                    while(j<k && nums[j] == nums[j-1])j++; //skips the duplicates
                    while(j<k && nums[k] == nums[k+1])k--; //skips the duplicates
                }
                else if(sum < 0){
                    j++;
                }else{
                    k--;
                }
            }
        }
        return res;
    }
}
//sum = 0;
// //  i
// [-1,0,1,2,-1,-4]
//       j
//         k
// // time comnplixity: O(n^3)

//optimal approch
//             i j       
// [-4,-1,-1,0,1,2]
//               k
// sum = 1

// [-1,-1,2][-1,0,1]

// i
//[0,0,0,0,0,0,0,0,0,0,]
//.             j
//          k
