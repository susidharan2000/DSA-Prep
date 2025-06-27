class Solution {
    public int distinctPrimeFactors(int[] nums) {
        Set<Integer> set = new HashSet<>();
      //extract prime number from each element
      for(int num:nums){
        for(int i = 2;i*i<=num;i++){
            if(num%i == 0){
                set.add(i);
            while(num%i == 0){
                num/=i;
            }
            }
        }
        if(num!=1)set.add(num);
      } 
      return set.size(); 
    }
}