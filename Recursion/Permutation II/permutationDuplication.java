//used set because while swaping the sorted order might getChanged
class Solution {
    public static void getUniquePermutation(int index,int[]nums,List<List<Integer>>res){
        if(index >= nums.length){
            List<Integer> list = new ArrayList<>();
            for(int num:nums){
                list.add(num);
            }
            res.add(list);
            return;
        }
        Set<Integer> set = new HashSet<>(); // checks duplication in same level 
        for(int i = index;i< nums.length;i++){
            set.add(nums[i]);
            swap(index,i,nums);
            getUniquePermutation(index+1,nums,res);
            swap(index,i,nums);
        }
    }
    public static void swap(int i,int j,int []nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        getUniquePermutation(0,nums,res);
        return res;
    }
}