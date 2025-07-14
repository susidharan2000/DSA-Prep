class Solution {
    public void moveZeroes(int[] nums) {
        int i = 0;
        while( i < nums.length && nums[i]!=0){   //O(x)
            i++;
        }
        for(int j = i+1;j<nums.length;j++){    // O(n-x)
            if(nums[j] != 0){
                //swap
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
            }
        }
    }
}
//so the time complixity will be: x + n-x = n
// time complixity : O(n) 