class Solution {
    public int singleNumber(int[] nums) {
        int res = 0;
        for(int i = 0;i< nums.length;i++){
            res = res^nums[i];
    }
        return res;
    }
}

// optimal
// 2 ^ 2 ^ 1
// 0 ^ 1
// 1

// brute force// map = {
//     2=2;
//     1=1;
// }

// tc = O(n * log m) + O(m)
// sc = o(m)