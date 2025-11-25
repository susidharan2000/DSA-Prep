package DynamicProgramming.DP_ON_subsequance.PartiationEqualSubSetSum;

class Solution1 {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int total = 0;
        for(int num:nums)total+=num;
        if(total%2 != 0)return false;
        int target = total/2;
        Boolean [][]dp = new Boolean [n][target+1];
        return canEqualSubSetPossible(0,target,nums,dp);
    }
    public static boolean canEqualSubSetPossible(int index,int target,int []nums,Boolean [][]dp){
        if(target == 0)return true;
        if(index >= nums.length)return false;
        if(target < 0)return false;
        if(dp[index][target]!= null)return dp[index][target];
        boolean pick = false;
        boolean notPick = false;
        pick = canEqualSubSetPossible(index+1,target-nums[index],nums,dp);
        notPick = canEqualSubSetPossible(index+1,target,nums,dp);
        dp[index][target] = pick || notPick;
        return dp[index][target];
    }
}
//Time complixity:O(n*target)
//soace complixity:O(n* target)+O(n)->stack space


//dp - Tabulation
class Solution2 {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int total = 0;
        for(int num:nums)total+=num;
        if(total%2 != 0)return false;
        int target = total/2;
        boolean [][]dp = new boolean [n+1][target+1];
        //base case
        for(int i = 0;i<=n;i++){
            dp[i][0] = true;
        }
        //fill
        for(int i = n-1;i>=0;i--){
            for(int sum = 0;sum<=target;sum++){
                boolean include = false;
                if(sum-nums[i] >= 0)include = dp[i+1][sum-nums[i]];
                boolean exclude = dp[i+1][sum];
                dp[i][sum] = include || exclude;
            }
        }
        return dp[0][target];
    }
}
//Time complixity:O(n*target)
//soace complixity:O(n* target)

//Dp - tabulation - Space optimazation
class Solution3 {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int total = 0;
        for(int num:nums)total+=num;
        if(total%2 != 0)return false;
        int target = total/2;
        boolean []dp = new boolean [target+1];
        //base case
        dp[0] = true;
        //fill
        for(int i = n-1;i>=0;i--){
            boolean []temp = new boolean [target+1];
            temp[0] = true;
            for(int sum = 0;sum<=target;sum++){
                boolean include = false;
                if(sum-nums[i] >= 0)include = dp[sum-nums[i]];
                boolean exclude = dp[sum];
                temp[sum] = include || exclude;
            }
            dp = temp;
        }
        return dp[target];
    }
}
//Time complixity:O(n*target)
//soace complixity:O(target)
