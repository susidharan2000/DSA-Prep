import java.util.Arrays;

class Solution1 {
    public static int getMinSquare(int sum){
        if(sum == 0)return 0;
        int minDepth = Integer.MAX_VALUE;
        for(int i = 1;i*i<=sum;i++){
            int squareValue = i*i;
            minDepth = Math.min(getMinSquare(sum-squareValue),minDepth);
        }
        return minDepth!=Integer.MAX_VALUE?1+minDepth:Integer.MAX_VALUE;
    }
    public int minSquares(int n) {
        // Code here
        return getMinSquare(n);
    }
}
//Time Complixity:O(sqrt(n)^n)
//sapce complixity:O(n)

//Dp - Memozation
class Solution2 {
    public static int getMinSquare(int sum,int []dp){
        if(sum == 0)return 0;
        int minDepth = Integer.MAX_VALUE;
        for(int i = 1;i*i<=sum;i++){
            int squareValue = i*i;
            minDepth = Math.min(dp[sum-squareValue]!= -1?dp[sum-squareValue]:getMinSquare(sum-squareValue,dp),minDepth);
        }
        dp[sum] = minDepth!=Integer.MAX_VALUE?1+minDepth:Integer.MAX_VALUE;
        return dp[sum];
    }
    public int minSquares(int n) {
        // Code here
        int []dp = new int [n+1];
        Arrays.fill(dp,-1);
        return getMinSquare(n,dp);
    }
}

//Time Complixity:O(n*sqrt(n))
//sapce complixity:O(n)+O(n)


//Dp - Tabulation
class Solution3 {
    public int minSquares(int n) {
        // Code here
        int []dp = new int [n+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;
        dp[1] = 1;
        for(int i = 2;i<=n;i++){
            for(int j = 1;j*j<=i;j++){
                int squareValue = j*j;
                dp[i] = Math.min(1+dp[i - squareValue],dp[i]); //only use the pre-computed result
            }
        }
        return dp[n];
    }
}
//Time Complixity:O(n*sqrt(n))
//sapce complixity:O(n)
