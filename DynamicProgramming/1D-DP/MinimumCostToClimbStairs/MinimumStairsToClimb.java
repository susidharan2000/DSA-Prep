import java.util.Arrays;

//recursive Solution
class Solution1 {
    public static int minCost(int n,int []cost){
        if(n <= 1)return cost[n];
        return cost[n] + Math.min(minCost(n-1,cost),minCost(n-2,cost));
    }
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int []c = new int[n+1];
        for(int i = 0;i<n;i++){
            c[i] = cost[i];
        } 
        return minCost(n,c);
    }
}
//time complixity:O(2^n)
//space Complixity:O(n)+O(n)


//Dp - memoization
class Solution2 {
    public static int minCost(int n,int []cost,int []dp){
        if(n <= 1)return cost[n];
        if(dp[n] != -1)return dp[n];
        dp[n] = cost[n] + Math.min(minCost(n-1,cost,dp),minCost(n-2,cost,dp));
        return dp[n];
    }
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int [] dp = new int [n+1];
        Arrays.fill(dp,-1);
        return Math.min(minCost(n-1,cost,dp),minCost(n-2,cost,dp));
    }
}
// time Complixity:O(n)
// space Complixity:O(n)+O(n)

//Dp - Tebulation
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        if(n == 1) return cost[0];
        if(n == 2)return Math.min(cost[0],cost[1]);
        int prev1 = cost[0];
        int prev2 = cost[1];
        int curr = -1;
        for(int i = 2;i<n;i++){
            curr = cost[i]+Math.min(prev1,prev2);
            prev1 = prev2;
            prev2 = curr;
        }
        return Math.min(prev1,prev2);
    }
}
// time Complixity:O(n)
// space Complixity:O(1)
