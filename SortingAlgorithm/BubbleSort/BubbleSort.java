class Solution {
    public int[] sortArray(int[] nums) {
        for(int i = nums.length-1;i>=0;i--){
            boolean didSwap = false;
            for(int j = 0;j<i;j++){
                if(nums[j] > nums[j+1]){
                    //swap
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                    didSwap = true;
                }
            }
            if(!didSwap)break;
        }
        return nums;
    }
}