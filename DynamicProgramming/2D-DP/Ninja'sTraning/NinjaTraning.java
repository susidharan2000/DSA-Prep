import java.util.Arrays;

// DP - Memoization
class Solution1 {
    public int maximumPoints(int arr[][]) {
        // code here
        int n = arr.length;
        int [][]dp = new int [n][4];
        for(int []row:dp){
            Arrays.fill(row,-1);
        }
        return getmaxPoints(n-1,arr,3,dp);
    }
    public static int getmaxPoints(int day,int[][]arr,int last,int [][]dp){
        if(day == 0){
            int maxP =Integer.MIN_VALUE;
            for(int i = 0;i<3;i++){
                if(i == last) continue;
                maxP = Math.max(arr[day][i],maxP);
            }
            return maxP;
        }
        if(dp[day][last] != -1)return dp[day][last];
        int maxPoint= Integer.MIN_VALUE;
        for(int i = 0;i<3;i++){
            if(i == last) continue;
            maxPoint = Math.max(arr[day][i]+getmaxPoints(day-1,arr,i,dp),maxPoint);
        }
        dp[day][last] = maxPoint;
        return dp[day][last];
    }
}

//time copmplixty:O(n*4*3)
//sapce Complixity:O(n)+O(n*n)

//Dp - Tabulation

class Solution2 {
    public int maximumPoints(int arr[][]) {
        // code here
        int n = arr.length;
        int [][]dp = new int [n][4];
        for(int []row:dp){
            Arrays.fill(row,-1);
        }
        dp[0][0] =Math.max(arr[0][1],arr[0][2]);
        dp[0][1] = Math.max(arr[0][0],arr[0][2]);
        dp[0][2] = Math.max(arr[0][0],arr[0][1]);
        dp[0][3] = Math.max(arr[0][0], Math.max(arr[0][1], arr[0][2]));
        for(int day = 1;day<n;day++){
            for(int i = 0;i<4;i++){
                int maxPoint = Integer.MIN_VALUE;
                for(int prev = 0;prev<3;prev++){
                    if(i == prev)continue;
                    maxPoint = Math.max(maxPoint,arr[day][prev]+dp[day-1][prev]);
                }
            dp[day][i] = maxPoint;
            }
        }
        return dp[n-1][3];
    }
}
//time copmplixty:O(n*4*3)
//sapce Complixity:O(n*n)