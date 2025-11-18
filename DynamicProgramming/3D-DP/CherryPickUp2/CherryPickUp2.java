import java.util.Arrays;

class Solution {
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int [][][]dp = new int [n][m][m];
        for(int [][]rowi:dp){
            for(int []rowj:rowi){
                Arrays.fill(rowj,-1);
            }
        }
        return getmaxCherry(0,0,m-1,grid,n,m,dp);
    }
    public static int getmaxCherry(int i,int j1,int j2,int[][]grid,int n,int m,int [][][]dp){
        if(j1 < 0 || j2 < 0 || j1 > m-1 || j2 > m-1)return (int)-1e8;
        if(i == n-1){
            if(j1 == j2){
                return grid[i][j1];
            }else{
                return grid[i][j1]+grid[i][j2];
            }
        }
        if(dp[i][j1][j2] != -1)return dp[i][j1][j2];
        int maxi = Integer.MIN_VALUE;
        for(int dx = -1;dx <= 1; dx++){
            for(int dy = -1;dy <= 1;dy++){
                if(j1 == j2)maxi = Math.max(grid[i][j1]+getmaxCherry(i+1,j1+dx,j2+dy,grid,n,m,dp),maxi);
                else maxi = Math.max(grid[i][j1]+grid[i][j2]+getmaxCherry(i+1,j1+dx,j2+dy,grid,n,m,dp),maxi);
            }
        }
        dp[i][j1][j2] = maxi;
        return dp[i][j1][j2];
    }
}
//time complixity:O(n*m*m)*9
//space complixity:O(n*m*m)+O(n*m*m) ->stack space
