package DynamicProgramming.Dp_On_Grids.MinimumSumPath;

import java.util.Arrays;

class Solution1 {
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int [][]dp = new int [n][m];
        for(int[]row:dp)Arrays.fill(row,-1);
        return getMinSum(0,0,grid,n,m,dp);
    }
    public static int getMinSum(int row,int col,int [][]grid,int n,int m,int[][]dp){
        if(row >= n || col >= m)return Integer.MAX_VALUE;
        if(row == n-1 && col == m-1){
            return grid[row][col];
        }
        if(dp[row][col] != -1)return dp[row][col];
        int right = getMinSum(row,col+1,grid,n,m,dp);
        int down = getMinSum(row+1,col,grid,n,m,dp);
        dp[row][col]= Math.min(right,down)+grid[row][col];
        return dp[row][col];
    }
}
//Time Complixity:O(n*m)
//space Complixity:O(m*n)+O(m+n) -> Stack space

class Solution2 {
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int [][]dp = new int [n][m]; 
        for(int []row:dp)Arrays.fill(row,Integer.MAX_VALUE);
        dp[0][0] = grid[0][0];
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(j!=m-1)dp[i][j+1] = Math.min(dp[i][j+1],grid[i][j+1]+dp[i][j]);
                if(i!=n-1)dp[i+1][j] = Math.min(dp[i+1][j],grid[i+1][j]+dp[i][j]);
            }
        }
        return dp[n-1][m-1];
    }
}
//Time Complixity:O(n*m)
//space Complixity:O(m*n)


//DP - Tabulation Space Optimation
class Solution3 {
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int []dp = new int [m]; 
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]= grid[0][0];
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(i>0)dp[j]+= grid[i][j];//update the row except the first row
                if(j>0){
                    dp[j] = Math.min(dp[j-1]+grid[i][j],dp[j]);
                }
            }
        }
        return dp[m-1];
    }
}
//time Complixity:O(m*n)
//space Comlixity:O(m)

