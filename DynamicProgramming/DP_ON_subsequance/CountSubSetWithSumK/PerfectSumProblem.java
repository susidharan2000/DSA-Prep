package DynamicProgramming.DP_ON_subsequance.CountSubSetWithSumK;

import java.util.Arrays;

class Solution1 {
    // Function to calculate the number of subsets with a given sum
    public int perfectSum(int[] nums, int target) {
        // code here
        //generate all possible sum equals target and reutrn i if the 
        // target is reached else return 0
        int n = nums.length;
        int [][]dp = new int [n][target+1];
        for(int []row:dp)Arrays.fill(row,-1);
        return getperfectSum(0,target,nums,dp);
    }
    public static int getperfectSum(int index,int sum,int []nums,int [][]dp){
        if(index >= nums.length){
            if(sum == 0)return 1;
            else return 0;
        }
        if(dp[index][sum]!= -1)return dp[index][sum];
        int include = 0;
        if(sum-nums[index] >= 0)include = getperfectSum(index+1,sum-nums[index],nums,dp);
        int exclude = getperfectSum(index+1,sum,nums,dp);
        dp[index][sum] = include+exclude;
        return dp[index][sum];
    }
}
//Time complixity:O(n*target)
//space Complxity:O(n*target)+O(n) ->stack space

class Solution2 {
    // Function to calculate the number of subsets with a given sum
    public int perfectSum(int[] nums, int target) {
        // code here
        //generate all possible sum equals target and reutrn i if the 
        // target is reached else return 0
        int n = nums.length;
        int [][]dp = new int [n+1][target+1];
        //fill the base case
        for(int i = 0;i<=n;i++)dp[i][0] = 1;
        //fill the table bottom up approch
        for(int i = n-1;i>=0;i--){
            for(int sum = 0;sum<=target;sum++){
                int include = 0;
                if(sum-nums[i] >= 0)include = dp[i+1][sum-nums[i]];
                int exclude = dp[i+1][sum];
                dp[i][sum] = include+exclude;
            }
        }
        return dp[0][target];
    }
}

//Time complixity:O(n*target)
//space Complxity:O(n*target)
