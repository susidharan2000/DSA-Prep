class Solution {
    //get factorial
    public static int getfact(int num){
        if (num <= 1) return 1;
        return num * getfact(num - 1);
    }
    public String getPermutation(int n, int k){
        List<Integer> nums = new LinkedList<>(); //use linked list becauce for removal time complixity is o(n);
        //generating initial permuatiation
        for(int i = 1;i<=n;i++){
            nums.add(i);
        }
        String res = "";
        k = k-1;
        while(!nums.isEmpty()){
            int len = nums.size(); // calculate possibilities after piking one 
            int pickvalIndex = k/getfact(len-1); // get index of permutation value
            res += nums.get(pickvalIndex); // add it to the result
            nums.remove(pickvalIndex); // remove the pick value
            k = k%getfact(len-1); // reduce k after picking
        }
        return res;
    }
}
// Each += on a string creates a new object — O(n²) in total.
// Use StringBuilder for O(n) performance.

  // Optimized Version (with factorial caching)
  // * Precompute factorials → O(n) upfront
  // * Use LinkedList instead of ArrayList for O(1) removal at arbitrary index (in Java, LinkedList.remove(index) is still O(n), so this helps only in theory)
  // * With caching + optimal data structures, you can get:
  // * ✅ Time Complexity: O(n) (for practical purposes)