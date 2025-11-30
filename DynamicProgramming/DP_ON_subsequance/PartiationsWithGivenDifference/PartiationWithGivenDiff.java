package DynamicProgramming.DP_ON_subsequance.PartiationsWithGivenDifference;

import java.util.Arrays;

class Solution1 {
    public int countPartitions(int[] arr, int diff) {
        // code here
        // generate all subset sum
        // s1-s2 = diff
        // s1 - (total-s1) = diff
        // s1 - total + s1 = diff
        // 2s1 - total = diff
        // 2s1 = diff+total;
        //s1 = (diff+total)/2;
        //target = (diff+total)/2;
        int n = arr.length;
        int total = 0;
        for(int num:arr)total+=num;
        if((diff+total)%2!= 0)return 0;
        int target = (diff+total)/2;
        int [][]dp = new int [n][target+1];
        for(int []row:dp)Arrays.fill(row,-1);
        return getDiffCount(0,target,arr,dp);
    }
    public static int getDiffCount(int index,int sum,int []arr,int [][]dp){
        if(index>=arr.length){
            return sum == 0?1:0;
        }
        if(dp[index][sum]!= -1)return dp[index][sum];
        int include = 0;
        if(sum-arr[index] >= 0)include = getDiffCount(index+1,sum-arr[index],arr,dp);
        int exclude = getDiffCount(index+1,sum,arr,dp);
        dp[index][sum] = include+exclude;
        return dp[index][sum];
    }
}

//Time complixity O(n*target)
//space Complixity:O(n*target)+O(n) - > stack space



class Solution2 {
    public int countPartitions(int[] arr, int diff) {
        // code here
        // generate all subset sum
        // s1-s2 = diff
        // s1 - (total-s1) = diff
        // s1 - total + s1 = diff
        // 2s1 - total = diff
        // 2s1 = diff+total;
        //s1 = (diff+total)/2;
        //target = (diff+total)/2;
        int n = arr.length;
        int total = 0;
        for(int num:arr)total+=num;
        if((diff+total)%2!= 0)return 0;
        int target = (diff+total)/2;
        int [][]dp = new int [n+1][target+1];
        //fill the base case
        for(int i = 0;i<=n;i++)dp[i][0] = 1;
        //fill the table
        for(int i = n-1;i>=0;i--){
            for(int sum = 0;sum<=target;sum++){
                int include = 0;
                if(sum-arr[i] >= 0)include = dp[i+1][sum-arr[i]];
                int exclude = dp[i+1][sum];
                dp[i][sum] = include+exclude;
            }
        }
        return dp[0][target];
    }
}
//Time complixity O(n*target)
//space Complixity:O(n*target)


class Solution3 {
    public int countPartitions(int[] arr, int diff) {
        // code here
        // generate all subset sum
        // s1-s2 = diff
        // s1 - (total-s1) = diff
        // s1 - total + s1 = diff
        // 2s1 - total = diff
        // 2s1 = diff+total;
        //s1 = (diff+total)/2;
        //target = (diff+total)/2;
        int n = arr.length;
        int total = 0;
        for(int num:arr)total+=num;
        if((diff+total)%2!= 0)return 0;
        int target = (diff+total)/2;
        int []dp = new int [target+1];
        //fill the base case
        dp[0] = 1;
        //fill the table
        for(int i = n-1;i>=0;i--){
            int temp[] = new int [target+1];
            temp[0] = 1;
            for(int sum = 0;sum<=target;sum++){
                int include = 0;
                if(sum-arr[i] >= 0)include = dp[sum-arr[i]];
                int exclude = dp[sum];
                temp[sum] = include+exclude;
            }
            dp = temp;
        }
        return dp[target];
    }
}
//Time complixity O(n*target)
//space Complixity:O(target)
