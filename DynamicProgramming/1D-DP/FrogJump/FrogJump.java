import java.util.Arrays;

//Resursive Solution
class Solution1 {
    public static int getMinCost(int i,int []height){
        if(i == 0)return 0;
        if (i == 1) return Math.abs(height[1] - height[0]);
        int left = getMinCost(i-1,height)+Math.abs(height[i]-height[i-1]);
        int right = getMinCost(i-2,height)+Math.abs(height[i]-height[i-2]);
        return Math.min(left,right);
    }
    int minCost(int[] height) {
        // code here
        int n = height.length;
        if(n == 1)return 0;
        return getMinCost(n-1,height);
    }
 } 

// Time Complixity:O(2^n)
// Space Complixity:O(n)

//Dp = Memozation

class Solution2 {
    public static int getMinCostdp(int i,int []height,int []dp){
        if(i == 0)return 0;
        if (i == 1) return Math.abs(height[1] - height[0]);
        int left = (dp[i-1] == -1)?getMinCostdp(i-1,height,dp):dp[i-1];
        int leftSum = left+Math.abs(height[i]-height[i-1]);
        int right = (dp[i-2] == -1)?getMinCostdp(i-2,height, dp):dp[i-2];
        int rightSum = right+Math.abs(height[i]-height[i-2]);
        dp[i] = Math.min(leftSum,rightSum);
        return dp[i];
    }
    int minCost(int[] height) {
        // code here
        int n = height.length;
        if(n == 1)return 0;
        int []dp = new int [n];
        Arrays.fill(dp,-1);
        return getMinCostdp(n-1,height,dp);
    }
} 

// Time Complixity:O(n)
// Space Complixity:O(n)+O(n)

// Dp - Tabulation

class Solution3 {
    int minCost(int[] height) {
        // code here
        int n = height.length;
        if(n == 1)return 0;
        if(n == 2)return Math.abs(height[0]-height[1]);
        int prev1 = 0;
        int prev2 = Math.abs(height[0]-height[1]);
        int curr = -1;
        for(int i = 2;i<n;i++){
            int left = prev2+Math.abs(height[i]-height[i-1]);
            int right = prev1+Math.abs(height[i]-height[i-2]);
            curr = Math.min(left,right);
            prev1 = prev2;
            prev2 = curr;
        }
        return curr;
    }
} 

//Time Complixity:O(n)
//Space Complixity:O(1)
