package DynamicProgramming.KnapSack_Problems.Unboubded_KnapSack;

import java.util.Arrays;

//Dp - Memoization - 
// The commented code snippet is implementing the unbounded knapsack problem using dynamic programming
// with memoization. The `knapSack` method initializes a 2D array `dp` to store the maximum profit for
// each item and capacity combination. It then calls the `getMaxProfit` method to calculate the maximum
// profit recursively.
class Solution1 {
    public int knapSack(int val[], int wt[], int capacity) {
        // code here
        int n = val.length;
        int [][]dp = new int [n][capacity+1];
        for(int []row:dp)Arrays.fill(row,-1);
        return getMaxProfit(0,capacity,val,wt,dp);
    }
    public static int getMaxProfit(int index,int capacity,int []val,int []wt,int [][]dp){
        if(capacity == 0)return 0;
        if(index == val.length)return 0;
        if(dp[index][capacity] != -1)return dp[index][capacity];
        int include = 0;
        if(capacity-wt[index]>=0)include = val[index]+getMaxProfit(index,capacity-wt[index],val,wt,dp);
        int exclude = getMaxProfit(index+1,capacity,val,wt,dp); 
        
        dp[index][capacity] = Math.max(include,exclude); 
        return dp[index][capacity];
    }
}

//time complixity:O(n*capacity)
//space complixity:O(n*capacity)+O(n) -> stack space

//Dp - Tabulation - 
class Solution2 {
    public int knapSack(int val[], int wt[], int capacity) {
        // code here
        int n = val.length;
        int [][]dp = new int [n+1][capacity+1];
        //fill the base case
        //fill the dp table
        for(int i = n-1;i>=0;i--){
            for(int cap = 0;cap<=capacity;cap++){
                int include = 0;
                if(cap - wt[i] >= 0)include = val[i]+dp[i][cap-wt[i]];
                int exclude = dp[i+1][cap];
                dp[i][cap] = Math.max(include,exclude);
            }
        }
        return dp[0][capacity];
    }
}

//time complixity:O(n*capacity)
//space complixity:O(n*capacity)

//Dp - Tabulation - space optimaization
class Solution3 {
    public int knapSack(int val[], int wt[], int capacity) {
        // code here
        int n = val.length;
        int []dp = new int [capacity+1];
        //fill the base case
        //fill the dp table
        for(int i = n-1;i>=0;i--){
            int []temp = new int [capacity+1];
            for(int cap = 0;cap<=capacity;cap++){
                int include = 0;
                if(cap - wt[i] >= 0)include = val[i]+temp[cap-wt[i]];
                int exclude = dp[cap];
                temp[cap] = Math.max(include,exclude);
            }
            dp = temp;
        }
        return dp[capacity];
    }
}
//time complixity:O(n*capacity)
//space complixity:O(capacity)

