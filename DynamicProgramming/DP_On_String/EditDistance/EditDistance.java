package DynamicProgramming.DP_On_String.EditDistance;

import java.util.Arrays;

class Solution1 {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int [][]dp = new int [n+1][m+1];
        for(int []row:dp)Arrays.fill(row,-1);
        return editDistance(n,m,word1,word2,dp);
    }
    public static int editDistance(int i,int j,String s1,String s2,int [][]dp){
        if(i == 0)return j;
        if(j == 0)return i;
        if(dp[i][j] != -1)return dp[i][j];
        if(s1.charAt(i-1) == s2.charAt(j-1)){
            dp[i][j] =  editDistance(i-1,j-1,s1,s2,dp);
            return dp[i][j];
        }else{
            int insert = 1+editDistance(i,j-1,s1,s2,dp);
            int delete = 1+editDistance(i-1,j,s1,s2,dp);
            int replace = 1+editDistance(i-1,j-1,s1,s2,dp);
            dp[i][j] = Math.min(insert,Math.min(delete,replace));
            return dp[i][j];
        }
    }
}
//Time complixity:O(n*m)
//Space complixity:O(n*m)+O(n+m) -> Stack space


//Dp - Tabulation
class Solution2 {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int [][]dp = new int [n+1][m+1];
        //fill the base case
        for(int i = 0;i<=n;i++){
            dp[i][0] = i;
        }
        for(int j = 0;j<=m;j++){
            dp[0][j] = j;
        }
        //fill the table
        for(int i = 1;i<=n;i++){
            for(int j = 1;j<=m;j++){
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    int insert = 1+dp[i][j-1];
                    int delete = 1+dp[i-1][j];
                    int replace = 1+dp[i-1][j-1];
                    dp[i][j] = Math.min(insert,Math.min(delete,replace));
                }
            }
        }
        return dp[n][m];
    }
}

//Time complixity:O(n*m)
//Space complixity:O(n*m)

//space optimization
class Solution3 {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int []dp = new int [m+1];
        for(int j = 0;j<=m;j++){
            dp[j] = j;
        }
        //fill the table
        for(int i = 1;i<=n;i++){
            int []temp = new int [m+1];
            temp[0] = i;
            for(int j = 1;j<=m;j++){
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    temp[j] = dp[j-1];
                }else{
                    int insert = 1+temp[j-1];
                    int delete = 1+dp[j];
                    int replace = 1+dp[j-1];
                    temp[j] = Math.min(insert,Math.min(delete,replace));
                }
            }
            dp = temp;
        }
        return dp[m];
    }
}
//Time complixity:O(n*m)
//Space complixity:O(m)


