package DynamicProgramming.Dp_On_Grids.Triangle;
import java.util.*;
//DP = Memoization
class Solution1 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int [][]dp = new int [n][n];
        for(int []row:dp)Arrays.fill(row,-1);
        return getminTotal(0,0,triangle,dp);
    }
    public static int getminTotal(int level,int index,List<List<Integer>> triangle,int[][] dp){
        if(level == triangle.size()-1){
            return triangle.get(level).get(index);
        }
        if(dp[level][index] != -1)return dp[level][index];
        int one = getminTotal(level+1,index,triangle,dp);
        int two = getminTotal(level+1,index+1,triangle,dp);
        dp[level][index] = Math.min(one,two)+triangle.get(level).get(index);
        return dp[level][index];
    }
}
//time Complixity:O(n*m)
//space Complixity:O(n*m)+O(n+m) -> Stack Space


//Dp - Tabulation
class Solution2 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int [][]dp = new int [n][n];
        int k = 0;
        for(int num:triangle.get(n-1)){
            dp[n-1][k] = num;
            k++;
        }
        for(int i = n-2;i>=0;i--){
            for(int j = 0;j<triangle.get(i).size();j++){
                dp[i][j] = Math.min(dp[i+1][j],dp[i+1][j+1])+triangle.get(i).get(j);
            }
        }
        return dp[0][0];
    }
}
//time Complixity:O(n*m)
//space Complixity:O(n*m)

//DP - Tabulation - Space Optimized
class Solution3 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int []dp = new int [n];
        int k = 0;
        for(int num:triangle.get(n-1)){
            dp[k] = num;
            k++;
        }
        for(int i = n-2;i>=0;i--){
            int len = triangle.get(i).size();
            for(int j = 0;j<len;j++){
                dp[j] = Math.min(dp[j],dp[j+1])+triangle.get(i).get(j);
            }
        }
        return dp[0];
    }
}
//Time Complixity:O(n*m)
//Space Complixity:O(n)

