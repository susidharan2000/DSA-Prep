package DynamicProgramming.KnapSack_Problems.CoinChangeProblem;

import java.util.Arrays;

class Solution1 {
    public int coinChange(int[] coins, int amount) {
        if(amount == 0)return 0;
        int n = coins.length;
        int [][]dp = new int [n][amount+1];
        for(int [] row:dp)Arrays.fill(row,-1);
        int res = getMinCoins(0,amount,coins,dp);
        return res == Integer.MAX_VALUE?-1:res;
    }
    public static int getMinCoins(int index,int amount,int []coins,int [][]dp){
        if(amount == 0)return 0;
        if(index >= coins.length)return Integer.MAX_VALUE;

        if(dp[index][amount] != -1)return dp[index][amount];
        int include = Integer.MAX_VALUE;
        if(amount-coins[index] >= 0)include = getMinCoins(index,amount-coins[index],coins,dp);
        if(include != Integer.MAX_VALUE)include = include+1;

        int exclude = getMinCoins(index+1,amount,coins,dp);

        dp[index][amount] = Math.min(include,exclude);
        return dp[index][amount];
    }
}
//Time copmplixity:O(n*amount)
//space complixity:O(n*amount)+O(n)->Stack Space

class Solution2 {
    public int coinChange(int[] coins, int amount) {
        if(amount == 0)return 0;
        int n = coins.length;
        int [][]dp = new int [n+1][amount+1];
        // fill the base case
        for (int amt = 1; amt <= amount; amt++) {
            dp[n][amt] = Integer.MAX_VALUE;
        }
        for(int i = n-1;i>=0;i--){
            for(int amt = 0;amt<=amount;amt++){
                int include = Integer.MAX_VALUE;
                if(amt-coins[i] >= 0 && dp[i][amt - coins[i]] != Integer.MAX_VALUE)include = 1+dp[i][amt-coins[i]];
                int exclude = dp[i+1][amt];
                dp[i][amt] = Math.min(include,exclude);
            }
        } 
        return dp[0][amount] == Integer.MAX_VALUE?-1:dp[0][amount];
    }
}

//Time copmplixity:O(n*amount)
//space complixity:O(n*amount)

class Solution3 {
    public int coinChange(int[] coins, int amount) {
        if(amount == 0)return 0;
        int n = coins.length;
        int []dp = new int [amount+1];
        // fill the base case
        for (int amt = 1; amt <= amount; amt++) {
            dp[amt] = Integer.MAX_VALUE;
        }
        for(int i = n-1;i>=0;i--){
            int []temp = new int [amount+1];
            for(int amt = 0;amt<=amount;amt++){
                int include = Integer.MAX_VALUE;
                if(amt-coins[i] >= 0 && temp[amt - coins[i]] != Integer.MAX_VALUE)include = 1+temp[amt-coins[i]];
                int exclude = dp[amt];
                temp[amt] = Math.min(include,exclude);
            }
            dp = temp;
        } 
        return dp[amount] == Integer.MAX_VALUE?-1:dp[amount];
    }
}
//Time copmplixity:O(n*amount)
//space complixity:O(amount)