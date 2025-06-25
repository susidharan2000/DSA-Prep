class Solution {
    public int[] sortArray(int[] nums) {
        for(int i = 0;i<nums.length;i++){
            //selecting the minimum
            int min = i; // min elements position
            for(int j = i+1;j<nums.length;j++){
                if(nums[min] > nums[j]){
                    min =j;
                }
            }
            //swap
            int temp = nums[i];
            nums[i] = nums[min];
            nums[min] = temp;
        }
        return nums;
    }
}