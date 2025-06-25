class Solution {
    public int[] sortArray(int[] nums) {
        for(int i = 1;i< nums.length;i++){
            for(int j = i;j>0;j--){
                if(nums[j] < nums[j-1]){
                    //swap
                    int temp = nums[j];
                    nums[j] = nums[j-1];
                    nums[j-1] = temp;
                }else{
                    break;
                }
            }
        }
        return nums;
    }
}