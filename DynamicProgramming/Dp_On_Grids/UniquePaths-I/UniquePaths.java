package DynamicProgramming.Dp_On_Grids.UniquePaths;

import java.util.Arrays;

//DFS - Memoization
class Solution1 {
    public int uniquePaths(int m, int n) {
        int [][]dp = new int [m][n];
        for(int []row:dp)Arrays.fill(row,-1);
        dp[m-1][n-1] = 1;
        int count = 0;
        count = dfs(0,0,m,n,dp);
        return count;
    }
    public static int dfs(int row,int col,int m,int n,int [][]dp){
        if(row >= m || col >= n)return 0;
        if(dp[row][col]!= -1)return dp[row][col];
        int right = dfs(row,col+1,m,n,dp);
        int down = dfs(row+1,col,m,n,dp);
        dp[row][col] = right+down;
        return dp[row][col];
    }
}
//Time Complixity:O(m*n)
//Space Complixity:O((m-1)*(n-1))+O(m+n)

//DP - Tabulation
class Solution2 {
    public int uniquePaths(int m, int n) {
        int [][] dp = new int [n][m];
        dp[0][0] = 1;
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(j != n-1)dp[i][j+1]+=dp[i][j];
                if(i != m-1)dp[i+1][j]+=dp[i][j];
            }
        }
        return dp[m-1][n-1];
    }
}
//Time Complixity:O(n*m)
//Space Complixity:O(n*m)


//DP - Tabulation - Space optimized
class Solution3 {
    public int uniquePaths(int m, int n) {
        int [] dp = new int [n];
        dp[0] = 1;
        for(int i = 0;i<m;i++){
            int [] temp= new int [n];
            for(int j = 0;j<n;j++){
                if(j != n-1) dp[j+1]+=dp[j];
                temp[j]+=dp[j];
            }
            dp = temp;
        }
        return dp[n-1];
    }
}
//Time Complixity:O(n*m)
//Space Complixity:O(2n) = O(n)

//Combinatoral Approch
class Solution4 {
    public int uniquePaths(int m, int n) {
        int N = m+n-2;
        int r = Math.min(m-1,n-1);
        long res = 1;
        for(int i = 1;i<=r;i++){
            res = res * (N-r+i)/i;
        }
        return (int)res;
    }
}
//time Comnplixity:O(min(n-1,m-1))
//space Complixity:O(1)