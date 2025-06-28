class Solution {
    public static void getCombination(int index,int sum,int k,int n,List<Integer>list,List<List<Integer>>res){
        if(list.size() == k){
            if(sum == n){
                res.add(new ArrayList<>(list));
                return;
            }
        }
        for(int i = index;i<=9;i++){
            if(sum+i > n)break; // purning if sum is grater than this
            list.add(i);
            getCombination(i+1,sum+i,k,n,list,res);
            list.remove(list.size()-1);
        }
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
       List<List<Integer>>res = new ArrayList<>();
       List<Integer>list = new ArrayList<>();
       getCombination(1,0,k,n,list,res);
       return res;
    }
}