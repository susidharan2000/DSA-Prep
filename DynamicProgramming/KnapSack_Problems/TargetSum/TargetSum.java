package DynamicProgramming.KnapSack_Problems.TargetSum;

import java.util.Arrays;

// User function Template for Java

class Solution1 {
    static int findTargetSumWays(int N, int[] A, int target) {
        // code here
        int totalSum = 0;
        for(int num : A) totalSum += num;
        int [][]dp = new int [N][2*totalSum+1];
        for(int []row:dp)Arrays.fill(row,-1);
        return getSumWays(0,0,target,A,dp,totalSum);
    }
    public static int getSumWays(int index,int sum,int target,int []arr,int [][]dp,int totalSum){
        if(index >= arr.length){
            if(sum == target)return 1;
            return 0;
        }
        if(dp[index][sum+totalSum] != -1)return dp[index][sum+totalSum];
        int positive = getSumWays(index+1,sum+arr[index],target,arr,dp,totalSum);
        int negative = getSumWays(index+1,sum-arr[index],target,arr,dp,totalSum);
        dp[index][sum+totalSum] = positive+negative;
        return dp[index][sum+totalSum];
    }
};

//time complixity:O(n*target)
//space Complixity:O(n*2*totalSum)

class Solution2 {
    static int findTargetSumWays(int N, int[] A, int target) {
        // code here
        int total = 0;
        for(int num : A) total += num;
        int [][]dp = new int [N+1][2*total+1];
        int offset = total;
        //fill the base case
        if(target+offset >= 0 && target+offset <= 2 * total){
            dp[N][target + offset] = 1;
        }
        //fill the table
        for(int i = N-1;i>=0;i--){
            for(int sum = -total;sum<= total;sum++){
                int positive = 0;
                int negative = 0;
                
                int posSum = A[i]+sum;
                if(posSum >= -total && posSum <= total){
                    positive = dp[i+1][posSum + offset];
                }
                int negSum = sum - A[i];
                if(negSum >= -total && negSum <= total){
                    negative = dp[i+1][negSum + offset];
                }
                dp[i][sum+offset] = positive+negative;
            }
        }
        return dp[0][0 + total];
    }
};
//time complixity:O(n*target)
//space Comnplixity:O(n*2*total)

class Solution3 {
    static int findTargetSumWays(int N, int[] A, int target) {
        // code here
        int total = 0;
        for(int num : A) total += num;
        int []dp = new int [2*total+1];
        int offset = total;
        //fill the base case
        if(target+offset >= 0 && target+offset <= 2 * total){
            dp[target + offset] = 1;
        }
        //fill the table
        for(int i = N-1;i>=0;i--){
            int []temp = new int [2*total+1];
            for(int sum = -total;sum<= total;sum++){
                int positive = 0;
                int negative = 0;
                
                int posSum = A[i]+sum;
                if(posSum >= -total && posSum <= total){
                    positive = dp[posSum + offset];
                }
                int negSum = sum - A[i];
                if(negSum >= -total && negSum <= total){
                    negative = dp[negSum + offset];
                }
                temp[sum+offset] = positive+negative;
            }
            dp = temp;
        }
        return dp[0 + total];
    }
};
//time complixity:O(n*target)
//space Comnplixity:O(2*total)

