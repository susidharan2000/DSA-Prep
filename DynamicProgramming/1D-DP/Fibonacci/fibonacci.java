

//recursive Solution
// class Solution {
//     public int fib(int n) {
//         if(n <= 1)return n;
//         return fib(n-1)+fib(n-2);
//     }
// }

//dp- memozation
// class Solution {
//     public static int f(int n,int [] dp){
//         if(n <= 1)return n;
//         if(dp[n]!=-1)return dp[n];
//         dp[n] = f(n-1,dp)+f(n-2,dp);
//         return dp[n];
//     }
//     public int fib(int n) {
//         int []dp = new int [n+1];
//         Arrays.fill(dp,-1);
//         return f(n,dp);
//     }
// }

//time complixity:O(n)
//space complixity :O(n)+O(n)

//dp - Tabulation
// class Solution {
//     public int fib(int n) {
//         if(n <= 1)return n;
//         int []dp = new int [n+1];
//         Arrays.fill(dp,-1);
//         dp[0] = 0;
//         dp[1] = 1;
//         for(int i = 2;i<=n;i++){
//             dp[i] = dp[i-1]+dp[i-2];
//         }
//         return dp[n];
//     }
// }
//time complixity:O(n)
//space complixity :O(n)

// optimized version
class Solution {
    public int fib(int n) {
        if(n <= 1)return n;
        int prev1 = 0;
        int prev2 = 1;
        int temp =-1;
        for(int i = 2;i<=n;i++){
            temp = prev1+prev2;
            prev1 = prev2;
            prev2 = temp;;
        }
        return temp;
    }
}

//time complixity:O(n)
//space complixity :O(1)

//        1
//0,1,1,2,3,5
//          2
//            t
