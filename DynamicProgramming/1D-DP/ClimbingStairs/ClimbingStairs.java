

import java.util.Arrays;

//recursive Solution
class Solution1 {
    public static int totalWays(int n){
        if(n <= 1)return 1;
        return totalWays(n-1) + totalWays(n-2);
    }
    public int climbStairs(int n) {
        return totalWays(n);
    }
}
//time Complixity:O(2^n)
//space Complixity:O(n)

//Dp - memoziation
class Solution2 {
    public static int totalWays(int n,int []dp){
        if(n <= 1)return 1;
        if(dp[n] != -1)return dp[n];
        dp[n] = totalWays(n-1,dp) + totalWays(n-2,dp);
        return dp[n];
    }
    public int climbStairs(int n) {
        int []dp = new int [n+1];
        Arrays.fill(dp,-1);
        return totalWays(n,dp);
    }
}
//time Complixity:O(n)
//space Complixity:O(n)+O(n)


// Dp - Tabulation

class Solution3 {
    public int climbStairs(int n) {
        if(n<=1)return 1;
        int prev1 = 1;
        int prev2 = 1;
        int curr = -1;
        for(int i = 2;i<=n;i++){
            curr = prev1+prev2;
            prev1 = prev2;
            prev2 = curr;
        }
        return curr;
    }
}
//time Complixity:O(n)
//space Complixity:O(1)
//[1,1,2,3,5,8]
