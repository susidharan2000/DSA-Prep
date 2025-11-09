import java.util.Arrays;

class Solution1 {
    public static int getMaxSum(int index,int []arr){
        int maxSum = 0; 
        for(int i = index+2;i<arr.length;i++){
            maxSum = Math.max(getMaxSum(i,arr),maxSum);
        }
        return maxSum+arr[index];
    }
    int findMaxSum(int arr[]) {
        // code here
      int maxSum = 0;
      for(int i = 0;i<arr.length;i++){
          maxSum = Math.max(getMaxSum(i,arr),maxSum);
      }
      return maxSum;
    }
}

//Time Complixity:O(2^n)
//Space Copmplicity:O(n)

//DP - Menoization
class Solution2 {
    public static int getMaxSum(int index,int []arr,int []dp){
        int maxSum = 0; 
        if(dp[index]!=-1)return dp[index];
        for(int i = index+2;i<arr.length;i++){
            maxSum = Math.max(getMaxSum(i,arr,dp),maxSum);
        }
        dp[index] = maxSum+arr[index];
        return dp[index];
    }
    int findMaxSum(int arr[]) {
        // code here
      int maxSum = 0;
      int n = arr.length;
      int [] dp = new int[n];
      Arrays.fill(dp,-1);
      for(int i = 0;i<n;i++){
          maxSum = Math.max(dp[i]!=-1?dp[i]:getMaxSum(i,arr,dp),maxSum);
      }
      return maxSum;
    }
}

//Time Complixity:O(n*n)
//Space Copmplicity:O(n)+O(n)


//Dp - Memoization (Pick / not Pick Method)
class Solution3 {
    public static int getMaxSum(int index,int []arr,int []dp){
        if(index == arr.length-1)return arr[arr.length-1];
        if(index > arr.length-1){
            return 0;
        }
        if(dp[index] != -1)return dp[index];
        int pick = arr[index]+getMaxSum(index+2,arr,dp);
        int notPick = getMaxSum(index+1,arr,dp);
        dp[index] = Math.max(pick,notPick);
        return dp[index];
    }
    int findMaxSum(int arr[]) {
        // code here
        int []dp = new int [arr.length];
        Arrays.fill(dp,-1);
        return getMaxSum(0,arr,dp);
    }
}
//Time Complixity:O(n)
//Space Copmplicity:O(n)+O(n)


//Dp - Tabulation (Pick / not Pick Method)
class Solution4 {
    int findMaxSum(int arr[]) {
        // code here
        int n = arr.length;
        int []dp = new int [n];
        Arrays.fill(dp,-1);
        dp[n-1] = arr[n-1];
        dp[n-2] = Math.max(arr[n-1],arr[n-2]);
        for(int i = n-3;i>=0;i--){
            dp[i] = Math.max(dp[i+1],dp[i+2]+arr[i]);
        }
        return dp[0];
    }
}
// //Time Complixity:O(n)
// // space Complixity:O(n)


//Dp - Tabulation (Pick / not Pick Method) - Space Optimization
class Solution5 {
    int findMaxSum(int arr[]) {
        // code here
        int n = arr.length;
        if(n == 1)return arr[0];
        int prev1 = Math.max(arr[n-1],arr[n-2]);
        int prev2 = arr[n-1];
        if(n == 2)return prev1;
        int curri = -1;
        for(int i = n-3;i>=0;i--){
            curri = Math.max(prev1,prev2+arr[i]);
            prev2 = prev1;
            prev1 = curri;
        }
        return curri;
    }
}
//Time Complixity:O(n)
// space Complixity:O(1)