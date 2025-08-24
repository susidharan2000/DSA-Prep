package StackAndQueues.TrappingRainWater;


//solution :1
// class Solution {
//     public int trap(int[] height) {
//         //pre-compute the suffixMAx
//         int n = height.length;
//         int [] suffixMax = new int [n];
//         int maxval = -1;
//         for(int i = n-1;i>=0;i--){
//             if(height[i] > maxval){
//                 maxval = height[i];
//                 suffixMax[i] = -1;
//             }else{
//                 suffixMax[i] = maxval;
//             }
//         }
//         //pre-compute the prefixMax
//         maxval = -1;
//         int [] prefixMax = new int [n];
//         for(int i =0;i<n;i++){
//             if(height[i] > maxval){
//                 maxval = height[i];
//                 prefixMax[i] = -1;
//             }else{
//                 prefixMax[i] = maxval;
//             }
//         }
//         // do traversal
//         int total = 0;
//         for(int i = 0;i< n;i++){
//             if(suffixMax[i] != -1 && prefixMax[i] != -1){
//             total += Math.min(suffixMax[i],prefixMax[i])-height[i];
//             }
//         }
//         return total;
//     }
// }
//prefixMax = 5
//suffixMax = [0,0,0,0,0,0,3,2,2,2,1,-1]
// i
//[0,1,0,2,1,0,1,3,2,1,2,1]

//total  = Math.min(prefixMax,suffixMax)-arr[i];

//time Complixity:O(n)+O(n)+O(n) = O(3n)//three pass 
//two for pre-comutation
//one for Traversal
//space Complixity:O(2n)//SuffixMax // prefixMax




//solution :2

// class Solution {
//     public int trap(int[] height) {
//         //pre-compute the suffixMAx
//         int n = height.length;
//         int [] suffixMax = new int [n];
//         int maxval = -1;
//         for(int i = n-1;i>=0;i--){
//             if(height[i] > maxval){
//                 maxval = height[i];
//                 suffixMax[i] = -1;
//             }else{
//                 suffixMax[i] = maxval;
//             }
//         }
//         maxval = -1;
//         int prefixMax = 0;
//         // do traversal
//         int total = 0;
//         for(int i = 0;i< n;i++){
//             //compute the prefixMax
//             if(height[i] > maxval){
//                maxval =  height[i];
//                prefixMax = -1;
//             }else{
//                 prefixMax = maxval;
//             }
//             if(suffixMax[i] != -1 && prefixMax != -1){
//             total += Math.min(suffixMax[i],prefixMax)-height[i];
//             }
//         }
//         return total;
//     }
// }

//time Complixity:O(n)+O(n) = O(2n) // two pass
//space Complixity:O(n)


//solution:3
class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int left = 0;
        int right = n-1;
        int leftMax = 0;
        int rightMax = 0;
        int total = 0;
        while(left < right){
            if(height[left] <= height[right]){
                int curr = height[left];
                if(leftMax-curr >= 0){
                    total += leftMax-curr;
                }
                leftMax = Math.max(curr,leftMax);
                left++;
            }else{
                int curr = height[right];
                if(rightMax-curr >= 0){
                    total += rightMax-curr;
                }
                rightMax = Math.max(curr,rightMax);
                right--;
            }
        }
        return total;
    }
}