//boyer-moore majority voting algorithm
class Solution {
    public int majorityElement(int[] nums) {
        int ele = nums[0];
        int count = 1;
        for(int i = 1;i<nums.length;i++){
            if(count == 0){
                ele = nums[i];
            }
            if(nums[i] == ele){
                count++;
            }else{
                count--;
            }
        }
        return ele;
    }
}
//ele = 2
//count = 1
//                   i
// 2, 2, 1, 1, 1, 2, 2
