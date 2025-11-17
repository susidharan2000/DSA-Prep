package DynamicProgramming.Dp_On_Grids.MinimumFallingPath;

import java.util.Arrays;

//Dp - Memoization
class Solution1 {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int [][]dp = new int [n][m];
        for(int []row:dp)Arrays.fill(row,-1);
        int minSumPath = Integer.MAX_VALUE;
        for(int i = 0;i<m;i++){
            minSumPath = Math.min(getMinSum(0,i,matrix,n,m,dp),minSumPath);
        }
        return  minSumPath;
    }
    public static int getMinSum(int row,int col,int [][]matrix,int n,int m,int [][]dp){
        if(col < 0)return Integer.MAX_VALUE;
        if(col > m-1)return Integer.MAX_VALUE;
        if(row == n-1){
            return matrix[row][col];
        }
        if(dp[row][col] != -1)return dp[row][col];
        int minSum = Integer.MAX_VALUE;
        int left = getMinSum(row+1,col-1,matrix,n,m,dp);
        int down = getMinSum(row+1,col,matrix,n,m,dp);
        int right = getMinSum(row+1,col+1,matrix,n,m,dp);
        minSum = Math.min(left,Math.min(right,down));
        dp[row][col] = minSum+matrix[row][col];
        return dp[row][col];
    }

}
//time Complixity:O(n*m)
//space Complixity :O(m*n)+O(n) -> stack space


// //Dp - Tabulation
class Solution2 {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int [][]dp = new int [n][m];
        for(int i = 0;i<matrix[n-1].length;i++){
            dp[n-1][i] = matrix[n-1][i];
        }
        for(int i = n-2;i>=0;i--){
            for(int j = 0;j<m;j++){
                int left = Integer.MAX_VALUE;
                int right= Integer.MAX_VALUE;
                if(j > 0)left = dp[i+1][j-1];
                if(j < m-1)right = dp[i+1][j+1];
                int down = dp[i+1][j];
                dp[i][j] = Math.min(left,Math.min(right,down))+matrix[i][j];
            }
        }
        int minSumPath = Integer.MAX_VALUE;
        for(int i = 0;i<m;i++){
            minSumPath = Math.min(dp[0][i],minSumPath);
        }
        return minSumPath;
    }
}
//time Complixity:O(n*m)
//space Complixity :O(m*n)


//Dp - Tabulation - space Optimaization
class Solution3 {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int []dp = new int [m];
        for(int i = 0;i<matrix[n-1].length;i++){
            dp[i] = matrix[n-1][i];
        }
        for(int i = n-2;i>=0;i--){
            int []temp = new int [m];
            for(int j = 0;j<m;j++){
                int left = Integer.MAX_VALUE;
                int right= Integer.MAX_VALUE;
                if(j > 0)left = dp[j-1];
                if(j < m-1)right = dp[j+1];
                int down = dp[j];
                temp[j] = Math.min(left,Math.min(right,down))+matrix[i][j];
            }
            dp = temp;
        }
        int minSumPath = Integer.MAX_VALUE;
        for(int i = 0;i<m;i++){
            minSumPath = Math.min(dp[i],minSumPath);
        }
        return minSumPath;
    }
}

//time Complixity:O(n*m)
//space Complixity :O(m)
