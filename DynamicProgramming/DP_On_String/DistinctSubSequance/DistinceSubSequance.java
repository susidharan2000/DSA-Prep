package DynamicProgramming.DP_On_String.DistinctSubSequance;

import java.util.Arrays;

// Dp - Memoization
class Solution1 {
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        int [][]dp = new int [n+1][m+1];
        for(int [] row:dp)Arrays.fill(row,-1);
        return getDistinctSubSequance(n,m,s,t,dp);
    }
    public static int getDistinctSubSequance(int i,int j,String s,String t,int [][]dp){
        if(j == 0)return 1;
        if(i == 0)return 0;
        if(dp[i][j] != -1)return dp[i][j];
        if(s.charAt(i-1) == t.charAt(j-1)){
            dp[i][j] =  getDistinctSubSequance(i-1,j-1,s,t,dp)+getDistinctSubSequance(i-1,j,s,t,dp);
            return dp[i][j];
        }else{
            dp[i][j] = getDistinctSubSequance(i-1,j,s,t,dp);
            return dp[i][j];
        }
    }
}

//Time Complixity:O(n*m)
//space Complixity:O(n*m)+O(m+n)->stack space

// Dp - Tabulation

class Solution2 {
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        int [][]dp = new int [n+1][m+1];
        //fill the base case
        for(int i = 0;i<=n;i++){
            dp[i][0] = 1;
        }
        //fill the table
        for(int i = 1;i<=n;i++){
            for(int j = 1;j<=m;j++){
                if(s.charAt(i-1) == t.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]+dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][m];
    }
}
//Time Complixity:O(n*m)
//space Complixity:O(n*m)


// Dp - Tabulation - Space Optimization
class Solution3 {
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        int []dp = new int [m+1];
        //fill the base case
        dp[0] = 1;
        //fill the table
        for(int i = 1;i<=n;i++){
            for(int j = m; j >= 1; j--){
                if(s.charAt(i-1) == t.charAt(j-1)){
                    dp[j] = dp[j-1]+dp[j];
                }
            }
        }
        return dp[m];
    }
}
//Time Complixity:O(n*m)
//space Complixity:O(m)
