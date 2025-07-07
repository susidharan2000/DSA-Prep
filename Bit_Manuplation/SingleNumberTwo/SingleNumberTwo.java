class Solution {
    public int singleNumber(int[] nums) {
        int once = 0;
        int twos = 0;
        for(int i = 0;i< nums.length;i++){
            once = (nums[i]^once)&(~twos);
            twos = (nums[i]^twos)&(~once);
        }
        return once;
    }
} //tc -O(n) sc-O(1)
// 2 2 3 2

// once = (nums[i]^once)& (~twos)
// two = (nums[i]^two)& (~once)
// once  = 3
// twos = 0
// return once

// if num in one it should not be in two
// if the number in two it should not be in one

//optimal
// class Solution {
//     public int singleNumber(int[] nums) {
//         Arrays.sort(nums);
//         for(int i = 1;i< nums.length;i+=3){
//             if(nums[i] != nums[i-1])return nums[i-1];
//         }
//         return nums[nums.length-1];
//     }
// }
// tc - O(n log n) + n/3;
// sc - 0(1)
// class Solution {
//     public int singleNumber(int[] nums) {
//         int res = 0;
//         int n = nums.length;
//         for(int setIndex = 0;setIndex < 32;setIndex++){
//             int count  = 0;
//             for(int i = 0;i<n;i++){
//                 if((nums[i]&(1<<setIndex)) != 0){
//                     count++;
//                 }
//             }
//             if(count % 3 != 0){
//                 res  = res | (1<<setIndex); 
//             }
//         }
//         return res;
//     }
// }
// tc - o(31 * n)
// sc - o(1)

//        41
// // 2-  10
// // 2-  10
// // 3-  11
// // 2-  10
//        11 - 3

// 11
// 01
// 01


// count  = 1

// res = 1
// 01
// 10
// 11 - 3





