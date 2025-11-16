//Dp - Memoization
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid[0][0] == 1)return 0;
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        int [][]dp = new int [n][m];
        return dfs(0,0,obstacleGrid,n,m,dp);
    }
    public static int dfs(int row,int col,int [][]obstacleGrid,int n,int m,int [][]dp){
        if(row >= n || col >= m)return 0;//boundary
        if(obstacleGrid[row][col] == 1)return 0;//obstracl
        if(row == n-1 && col == m-1)return 1;//destination
        int right = dfs(row,col+1,obstacleGrid,n,m,dp);//move right 
        int left = dfs(row+1,col,obstacleGrid,n,m,dp);//move left
        dp[row][col] = right+left; //cache the result
        return dp[row][col];//return the resukt
    }
}
//Time Complixity:O(m*n)
//space Complixity:O(m*n)+O(m+n)->stack

//Dp - Tabulation
class Solution2 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid[0][0] == 1)return 0;
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        int [][]dp = new int [n][m];
        dp[0][0] = 1;
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(obstacleGrid[i][j] == 1)continue;
                if(j != m-1 && obstacleGrid[i][j+1] != 1)dp[i][j+1] += dp[i][j];//update the right
                if(i != n-1 && obstacleGrid[i+1][j] != 1)dp[i+1][j] += dp[i][j];//update the down
            }
        }
        return dp[n-1][m-1];
    }
}
//Time Complixity:O(m*n)
//space Complixity:O(m*n)

class Solution3 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid[0][0] == 1)return 0;
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        int []dp = new int [m];
        dp[0] = obstacleGrid[0][0] == 1?0:1;
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(obstacleGrid[i][j] == 1){
                    dp[j] = 0;
                }
                else{
                    if(j>0)dp[j]+=dp[j-1];
                }
            }
        }
        return dp[m-1];
    }
}
//time Complixity: O(n*m)
//space Complixity: O(n)
