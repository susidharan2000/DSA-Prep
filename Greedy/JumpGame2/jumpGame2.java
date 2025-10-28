package Greedy.JumpGame2;

class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int maxDistance = 0;
        int range = 0;
        int jumps = 0;
        for(int i = 0;i<n-1;i++){
            maxDistance = Math.max(nums[i]+i,maxDistance);
            if(i == range){
                range = maxDistance;
                jumps++;
            }
        }
        return jumps;
    }
}

//         i
//[2,3,1,1,4] n-1

//Maxdistance = 4 // is updated when the i moves Maxdistance = max(nums[i]+i,Maxdistance)

//CurrRange = 4 // this is updated when i == CurrRange
//jumps = 3