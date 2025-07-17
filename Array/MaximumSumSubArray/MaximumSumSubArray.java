// optimal - kadane's Algorithm
class Solution {
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int maxsum =Integer.MIN_VALUE;
        for(int i = 0;i< nums.length;i++){
            sum = Math.max(sum+nums[i],nums[i]);
            maxsum = Math.max(sum,maxsum);
        }
        return maxsum;
    }
}
//                      i
// [-2,1,-3,4,-1,2,1,-5,4]
//

// sum = 5;
// maxsum = 6; 

// sum = Math.max(sum+nums[i],nums[i]);
// maxsum = Math.max(sum,maxsum);

// time conplixity will be : o(n)





//Brute Force
// class Solution {
//     public int maxSubArray(int[] nums) {
//         int maxSum = Integer.MIN_VALUE;
//         for(int i = 0;i< nums.length;i++){
//             int sum = 0;
//             for(int j = i;j<nums.length;j++){
//                 sum+=nums[j];
//                 maxSum = Math.max(maxSum,sum);
//             }
//         }
//         return maxSum;
//     }
// }
//.           i
//[-2,1,-3,4,-1,2,1,-5,4]
//                  j

// sum = 3
// maxSum = 6;

// Time Complixity of:O(n^2)