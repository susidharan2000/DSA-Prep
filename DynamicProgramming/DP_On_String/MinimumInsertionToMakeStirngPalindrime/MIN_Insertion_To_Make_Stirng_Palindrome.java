package DynamicProgramming.DP_On_String.MinimumInsertionToMakeStirngPalindrime;

import java.util.Arrays;

//Dp - Memoization
class Solution1 {
    public int minInsertions(String s) {
        String s2 = reverse(new String(s));
        int n = s.length();
        int [][]dp = new int [n+1][n+1];
        for(int []row:dp)Arrays.fill(row,-1);
        int len = getLCS(n,n,s,s2,dp);
        return n-len;
    }
    //getLCS
    public static int getLCS(int i,int j,String s1,String s2,int [][]dp){
        if(i == 0 || j == 0)return 0;
        if(s1.charAt(i-1) == s2.charAt(j-1)){
            dp[i][j] =  1+getLCS(i-1,j-1,s1,s2,dp);
            return dp[i][j];
        }else{
            dp[i][j] = Math.max(getLCS(i-1,j,s1,s2,dp),getLCS(i,j-1,s1,s2,dp));
            return dp[i][j];
        } 
    }
    //helper function : reverse 
    public static String reverse(String s){
        char []charArr = s.toCharArray();
        int i = 0;
        int j = charArr.length-1;
        while(i<j){
            char temp = charArr[i];
            charArr[i] = charArr[j];
            charArr[j] = temp;
            i++;
            j--;
        }
        return new String(charArr);
    }
}

//Time complixity:O(n*n)
//Space complixity:O(n*n)+O(n) - > stack space


//Dp - Tabulation
class Solution2 {
    public int minInsertions(String s) {
        String s2 = reverse(new String(s));
        int n = s.length();
        int []dp = new int [n+1];
        // LCS
        for(int i = 1;i<=n;i++){
            int []temp = new int [n+1];
            for(int j = 1;j<=n;j++){
                if(s.charAt(i-1) == s2.charAt(j-1)){
                    temp[j] =  1 +  dp[j-1];
                }else{
                    temp[j] = Math.max(dp[j],temp[j-1]);
                }
            }
            dp = temp;
        }
        return n-dp[n];
    }
    //helper function : reverse 
    public static String reverse(String s){
        char []charArr = s.toCharArray();
        int i = 0;
        int j = charArr.length-1;
        while(i<j){
            char temp = charArr[i];
            charArr[i] = charArr[j];
            charArr[j] = temp;
            i++;
            j--;
        }
        return new String(charArr);
    }
}

//Time complixity:O(n*n)
//Space complixity:O(n)