package DynamicProgramming.KnapSack_Problems.CoinChange2;

import java.util.Arrays;

//dp - menoization
class Solution1 {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int [][]dp = new int [n][amount+1];
        for(int []row:dp)Arrays.fill(row,-1);
        return getNumOfWays(0,amount,coins,dp);
    }
    public static int getNumOfWays(int index,int amount ,int []coins,int [][]dp){
        if(amount == 0)return 1;
        if(index >= coins.length)return 0;
        int include = 0;
        if(dp[index][amount] != -1)return dp[index][amount];
        if(amount-coins[index] >= 0)include = getNumOfWays(index,amount-coins[index],coins,dp);
        int exclude = getNumOfWays(index+1,amount,coins,dp);
        dp[index][amount] = include + exclude;
        return dp[index][amount];
    }
}

//time complixity:O(n*amount)
//space complixity:O(n*amount)+O(n) -> stack space


//dp = tabulation

class Solution2 {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int [][]dp = new int [n+1][amount+1];
        //fill the base 
        for(int i = 0;i<=n;i++){
            dp[i][0] = 1;
        }
        // fill the table
        for(int i = n-1;i>=0;i--){
            for(int amt = 0;amt<=amount;amt++){
                int include = 0;
                int exclude = 0;
                if(amt-coins[i] >= 0)include =dp[i][amt-coins[i]];
                exclude  = dp[i+1][amt];
                dp[i][amt] = include+exclude;
            }
        }
        return dp[0][amount];
    }

}
//time complixity:O(n*amount)
//space complixity:O(n*amount)


class Solution3 {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int []dp = new int [amount+1];
        //fill the base 
            dp[0] = 1;
        // fill the table
        for(int i = n-1;i>=0;i--){
            int [] temp = new int [amount+1];
            temp[0] = 1;
            for(int amt = 0;amt<=amount;amt++){
                int include = 0;
                int exclude = 0;
                if(amt-coins[i] >= 0)include = temp[amt-coins[i]];
                exclude  = dp[amt];
                temp[amt] = include+exclude;
            }
            dp = temp;
        }
        return dp[amount];
    }

}
//time complixity:O(n*amount)
//space complixity:O(2*amount)