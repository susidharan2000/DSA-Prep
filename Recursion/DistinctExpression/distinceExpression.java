class Solution {
    public static void getCombination(int index,int sum,int []nums,Set<Integer> set){
        if(index == nums.length){
            set.add(sum);
            return;
        }
        getCombination(index+1,sum+nums[index],nums,set);
        getCombination(index+1,sum-nums[index],nums,set);
    }
    public int[] distinctExpressions(int[] nums) {
        Set<Integer> set = new HashSet<>();
        getCombination(1,nums[0],nums,set);
        int [] res = new int [set.size()];
        int i = 0;
        for(int item:set){
            res[i++] = item;
        }
        Arrays.sort(res);
        return res;
    }
}