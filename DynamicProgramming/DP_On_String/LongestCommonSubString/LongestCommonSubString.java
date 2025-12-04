package DynamicProgramming.DP_On_String.LongestCommonSubString;


class Solution1 {
    public int longestCommonSubstr(String s1, String s2) {
        // code here
        int n = s1.length();
        int m = s2.length();
        int [][]dp = new int [n+1][m+1];
        int maxLen = 0;
        for(int i = 1;i<=n;i++){
            for(int j = 1;j<=m;j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = 1+dp[i-1][j-1]; 
                    maxLen = Math.max(maxLen,dp[i][j]);
                }else{
                    dp[i][j] = 0;
                }
            }
        }
        return maxLen;
    }
}

//Time complixity:O(n*m)
//space Complixity:O(n*m)


class Solution2 {
    public int longestCommonSubstr(String s1, String s2) {
        // code here
        int n = s1.length();
        int m = s2.length();
        int []dp = new int [m+1];
        int maxLen = 0;
        for(int i = 1;i<=n;i++){
            int [] temp = new int [m+1];
            for(int j = 1;j<=m;j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    temp[j] = 1+dp[j-1]; 
                    maxLen = Math.max(maxLen,temp[j]);
                }else{
                    temp[j] = 0;
                }
            }
            dp = temp;
        }
        return maxLen;
    }
}
//Time complixity:O(n*m)
//space Complixity:O(m)
