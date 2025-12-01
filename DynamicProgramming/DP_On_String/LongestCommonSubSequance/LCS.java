package DynamicProgramming.DP_On_String.LongestCommonSubSequance;

import java.util.Arrays;

//Recursion Approch
class Solution1 {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        return getLongestLen(n-1,m-1,text1,text2);
    }
    public static int getLongestLen(int index1,int index2,String s1,String s2){
        if(index1 < 0 || index2 < 0)return 0;
        if(s1.charAt(index1) == s2.charAt(index2)){
            return 1 + getLongestLen(index1-1,index2-1,s1,s2);
        }else{
            int left = getLongestLen(index1-1,index2,s1,s2);
            int right = getLongestLen(index1,index2-1,s1,s2);
            return Math.max(left,right);
        }
    }
}

//time Complixity:O(2^n * 2^m)
//space Complixity:O(m+n)


//Dp - Memoization
class Solution2 {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int [][]dp = new int [n+1][m+1];
        for(int []row:dp)Arrays.fill(row,-1);
        return getLongestLen(n,m,text1,text2,dp);
    }
    public static int getLongestLen(int index1,int index2,String s1,String s2,int [][]dp){
        if(index1 == 0 || index2 == 0)return 0;
        if(dp[index1][index2] != -1)return dp[index1][index2];
        if(s1.charAt(index1-1) == s2.charAt(index2-1)){
            dp[index1][index2] = 1 + getLongestLen(index1-1,index2-1,s1,s2,dp);
            return dp[index1][index2];
        }else{
            int left = getLongestLen(index1-1,index2,s1,s2,dp);
            int right = getLongestLen(index1,index2-1,s1,s2,dp);
            dp[index1][index2] =  Math.max(left,right);
            return dp[index1][index2];
        }
    }
}

//time Complixity:O(n*m)
//space Complixity:O(n*m)+O(m+n) - >stack space

//Dp - Tabulation
class Solution3 {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int [][]dp = new int [n+1][m+1];
        for(int i = 1;i<=n;i++){
            for(int j = 1;j<=m;j++){
                if(text1.charAt(i-1) == text2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[n][m];
    }
}

//time Complixity:O(n*m)
//space Complixity:O(n*m)

//Dp - Tabulation - space Optimization
class Solution4 {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int []dp = new int [m+1];
        for(int i = 1;i<=n;i++){
            int [] temp = new int [m+1];
            for(int j = 1;j<=m;j++){
                if(text1.charAt(i-1) == text2.charAt(j-1)){
                    temp[j] = 1 + dp[j-1];
                }else{
                    temp[j] = Math.max(dp[j],temp[j-1]);
                }
            }
            dp = temp;
        }
        return dp[m];
    }
}

//time Complixity:O(n*m)
//space Complixity:O(m)

