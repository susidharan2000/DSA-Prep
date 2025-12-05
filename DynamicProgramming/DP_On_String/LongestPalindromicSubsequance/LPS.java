package DynamicProgramming.DP_On_String.LongestPalindromicSubsequance;

import java.util.Arrays;

//Dp - Memoization
class Solution1 {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int [][]dp = new int [n][n];
        for(int []row:dp)Arrays.fill(row,-1);
        return getPalindrome(0,n-1,s,dp);
    }
    public static int getPalindrome(int i,int j,String s,int [][]dp){
        if (i == j) return 1;
        if (i > j) return 0;
        if(dp[i][j]!= -1)return dp[i][j];
        if(s.charAt(i) == s.charAt(j)){
            dp[i][j] =  2 + getPalindrome(i+1,j-1,s,dp);
            return dp[i][j];
        }else{
            int left = getPalindrome(i+1,j,s,dp);
            int right = getPalindrome(i,j-1,s,dp);
            dp[i][j] = Math.max(left,right);
            return dp[i][j];
        }
    }
}
//Time complixity:O(n*n)
//Space Complixity:O(n*n)+O(n) - > stack Space

// //Dp - Tabulation
class Solution2 {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int [][]dp = new int [n][n];
        //fill the base case
        for(int i = 0;i<n;i++){
            dp[i][i] = 1;
        }
        for(int i = n - 1; i >= 0; i--){
            for(int j = i + 1; j < n; j++){ //because j should be grater than i
                if(s.charAt(i) == s.charAt(j)){
                    dp[i][j] =  2 + dp[i+1][j-1];
                }else{
                    int left = dp[i+1][j];
                    int right = dp[i][j-1];
                    dp[i][j] = Math.max(left,right);
                }
            }
        }
        return dp[0][n-1];
    }
}
// //Time complixity:O(n*n)
// //Space Complixity:O(n*n)

//Dp - Tabulation
class Solution3 {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int []dp = new int [n];
        //fill the base case
        dp[n - 1] = 1;
        for(int i = n - 1; i >= 0; i--){
            int []temp = new int [n];
            temp[i] = 1;
            for(int j = i + 1; j < n; j++){ //because j should be grater than i
                if(s.charAt(i) == s.charAt(j)){
                    temp[j] =  2 + dp[j-1];
                }else{
                    int left = dp[j];
                    int right = temp[j-1];
                    temp[j]= Math.max(left,right);
                }
            }
            dp = temp;
        }
        return dp[n-1];
    }
}
// //Time complixity:O(n*n)
// //Space Complixity:O(n)