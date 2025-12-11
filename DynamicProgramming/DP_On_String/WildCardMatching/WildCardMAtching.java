package DynamicProgramming.DP_On_String.WildCardMatching;

class Solution1 {
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        Boolean [][]dp = new Boolean [n+1][m+1];
        return matchingStr(n,m,s,p,dp);
    }
    public static boolean matchingStr(int i,int j,String s,String p,Boolean[][] dp){
        if(i == 0 && j == 0) return true;
        if(j == 0) return false;
        if(i == 0){
            for(int k = 0;k<j;k++){
                if(p.charAt(k)!= '*')return false;
            }
            return true;
        }
        if(dp[i][j] != null)return dp[i][j];
        if(s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '?'){
            dp[i][j] =  matchingStr(i-1,j-1,s,p,dp);
        }else if(p.charAt(j-1) == '*'){
            dp[i][j] = matchingStr(i-1,j,s,p,dp) || matchingStr(i,j-1,s,p,dp);
        }else{
            dp[i][j] = false;
        }
        return dp[i][j];
    }
}
//time Complixity :O(n*m)
//space Complixity:O(n*m)+O(n+m) -> stack space


//dp - tabulation
class Solution2 {
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        boolean [][]dp = new boolean [n+1][m+1];
        //fill the base case
        dp[0][0] = true;
        for(int j = 1;j<=m;j++){
            if(p.charAt(j-1)!='*')break;
            dp[0][j] = true;
        }
        //fill the table
        for(int i = 1;i<=n;i++){
            for(int j = 1;j<=m;j++){
                if(s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '?'){
                    dp[i][j] = dp[i-1][j-1];
                }else if(p.charAt(j-1) == '*'){
                    dp[i][j] = dp[i-1][j] || dp[i][j-1];
                }else{
                    dp[i][j] = false;
                }
            }
        }
        return dp[n][m];
    }
}

//time Complixity :O(n*m)
//space Complixity:O(n*m)



//dp - space optimization
class Solution3 {
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        boolean []prev = new boolean [m+1];
        //fill the base case
        prev[0] = true;
        for(int j = 1;j<=m;j++){
            if(p.charAt(j-1)!='*')break;
            prev[j] = true;
        }
        //fill the table
        for(int i = 1;i<=n;i++){
            boolean [] curr = new boolean [m+1];
            curr[0] = false;
            for(int j = 1;j<=m;j++){
                if(s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '?'){
                    curr[j] = prev[j-1];
                }else if(p.charAt(j-1) == '*'){
                    curr[j] = prev[j] || curr[j-1];
                }else{
                    curr[j] = false;
                }
            }
            prev = curr;
        }
        return prev[m];
    }
}
//time Complixity :O(n*m)
//space Complixity:O(m)
