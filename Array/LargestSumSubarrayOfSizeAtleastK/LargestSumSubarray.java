// User function Template for Java

class Solution {

    public long maxSumWithK(long a[], long n, long k) {
        int size = 0;
        int maxsum =Integer.MIN_VALUE;
       for(int i = 0;i< n;i++){
           int sum = 0;
           for(int j = i;j<n;j++){
               size = j-i+1;
               sum+=a[j];
               if(size >= k){
                   maxsum = Math.max(sum,maxsum);
               }
           }
       }
       return maxsum == Integer.MIN_VALUE?-1:maxsum;
    }
}
//               i
// int [] arr = {1,-2,2,-3}
// k = 2         j
// size = 0
// maxsum = 0
//sum = 0
//if(size >= k){
    //maxsum = math.max(maxsum,sum);
//}
//return maxsum

//O(n^2)