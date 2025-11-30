package DynamicProgramming.KnapSack_Problems.RodCutting;

import java.util.Arrays;

//Dp -memoization 
class Solution1 {
    public int cutRod(int[] price) {
        // code here
        int n =  price.length;
        int [][]dp = new int [n][n+1];
        for(int []row:dp)Arrays.fill(row,-1);
        return maxProfit(0,n,price,dp);
    }
    public static int maxProfit(int index,int pieces,int []price,int [][]dp){
        if(pieces == 0)return 0;
        if(index == price.length)return 0;
        if(dp[index][pieces]!=-1)return dp[index][pieces];
        int include= 0;
        if(pieces-(index+1) >= 0)include = price[index]+maxProfit(index,pieces-(index+1),price,dp); 
        int exclude = maxProfit(index+1,pieces,price,dp); 
        dp[index][pieces] = Math.max(include,exclude);
        return dp[index][pieces];
    }
}

//time complixity:O(n*(n+1))
//space comlixity:O(n*(n+1))+O(n)->stack space


//dp - Tabulation
class Solution2 {
    public int cutRod(int[] price) {
        // code here
        int n =  price.length;
        int [][]dp = new int [n+1][n+1];
        for(int i = n-1;i>=0;i--){
            for(int p = 0;p<=n;p++){
                int include = 0;
                if(p-(i+1) >= 0)include = price[i]+dp[i][p-(i+1)];
                int exclude = dp[i+1][p];
                dp[i][p] = Math.max(include,exclude);
            }
        }
        return dp[0][n];
    }
}
//time complixity:O(n*(n+1))
//space comlixity:O(n*(n+1))

//dp - Tabulation -Space optimization
class Solution3 {
    public int cutRod(int[] price) {
        // code here
        int n =  price.length;
        int []dp = new int [n+1];
        for(int i = n-1;i>=0;i--){
            for(int p = 0;p<=n;p++){
                int include = 0;
                if(p-(i+1) >= 0)include = price[i]+dp[p-(i+1)];
                int exclude = dp[p];
                dp[p] = Math.max(include,exclude);
            }
        }
        return dp[n];
    }
}
//time complixity:O(n*(n+1))
//space comlixity:O((n+1))
