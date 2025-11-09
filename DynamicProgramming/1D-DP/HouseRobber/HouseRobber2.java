import java.util.Arrays;

//Dp - Memoization
class Solution1 {
    public static int maxProfit(int index,int end,int []nums,int []dp){
        if(index < end)return 0;
        if(index == end)return nums[index];
        if(dp[index] != -1)return dp[index];
        int pick = maxProfit(index-2,end,nums,dp)+nums[index];
        int notPick = maxProfit(index-1,end,nums,dp);
        dp[index] = Math.max(pick,notPick);
        return dp[index];
    }
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1)return nums[0];
        if(n == 2)return Math.max(nums[0],nums[1]);
        int dp1[] = new int [n];
        int dp2[] = new int [n];
        Arrays.fill(dp1,-1);
        Arrays.fill(dp2,-1);
        return Math.max(maxProfit(n-1,1,nums,dp1),maxProfit(n-2,0,nums,dp2));
    }
}

//Time Complixity:O(n)
//Space Complixity:O(n)+O(n)

class Solution2 {
    public static int maxProfit(int start,int end,int []nums){
        //case 1: prev1 = nums[1]
        int prev2 = 0;
        int prev1 = nums[start];
        int curr = -1;
        for(int i = start+1;i<=end;i++){
            int pick = prev2+nums[i];
            int notPick = prev1;
            curr = Math.max(pick,notPick);
            prev2 = prev1;
            prev1 = curr;
        }
        return curr;
    }
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1)return nums[0];
        if(n == 2)return Math.max(nums[0],nums[1]);
        return Math.max(maxProfit(0,n-2,nums),maxProfit(1,n-1,nums));
    }
}
//Time Complixity:O(n)
//Space Complixity:O(1)
