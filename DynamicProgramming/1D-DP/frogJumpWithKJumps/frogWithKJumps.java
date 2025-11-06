import java.util.Arrays;

//Recursive Solution
class Solution1 {
    public static int minJumps(int i,int []heights,int k){
        if(i == 0)return 0;
        if(i == 1)return Math.abs(heights[0]-heights[1]);
        int j = i-1;
        int count = 0;
        int minSum = Integer.MAX_VALUE;
        while(j>= 0 && count < k){
            minSum = Math.min(minJumps(j,heights,k)+Math.abs(heights[i]-heights[j]),minSum);
            j--;
            count++;
        }
        return minSum;
    }
    public int frogJump(int[] heights, int k) {
        int n  = heights.length;
        if(n == 1)return 0;
        return minJumps(n-1,heights,k);
    }
}

//Dp - memoization
class Solution2 {
    public static int minJumps(int i,int []heights,int k,int []dp){
        if(i == 0)return 0;
        if(i == 1)return Math.abs(heights[0]-heights[1]);
        if(dp[i] != -1)return dp[i];
        int j = i-1;
        int count = 0;
        int minSum = Integer.MAX_VALUE;
        while(j>= 0 && count < k){
            minSum = Math.min(minJumps(j,heights,k,dp)+Math.abs(heights[i]-heights[j]),minSum);
            j--;
            count++;
        }
        dp[i] = minSum;
        return dp[i];
    }
    public int frogJump(int[] heights, int k) {
        int n  = heights.length;
        if(n == 1)return 0;
        int [] dp = new int [n+1];
        Arrays.fill(dp,-1);
        return minJumps(n-1,heights,k,dp);
    }
}


//Dp - Tabulation
class Solution3 {
    public int frogJump(int[] heights, int k) {
        int n = heights.length;
        if(n == 1)return 0;
        int [] dp = new int [n];
        Arrays.fill(dp,-1);
        dp[0] = 0;
        dp[1] = Math.abs(heights[0]-heights[1]);
        for(int i = 2;i<n;i++){
            int count = 0;
            int minDist = Integer.MAX_VALUE;
            for(int j = i-1;j>=0 && count < k;j--){
                minDist = Math.min(dp[j]+Math.abs(heights[i]-heights[j]),minDist);
                count++;
            }
            dp[i] = minDist;
        }
        return dp[n-1];
    }
}