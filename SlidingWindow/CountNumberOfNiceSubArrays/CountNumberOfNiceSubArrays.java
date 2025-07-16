class Solution {
    public static int getNiceSubArray(int [] nums,int k){
        int left = 0;
        int res= 0;
        int niceCount = 0;
        for(int right = 0;right< nums.length;right++){
            if((nums[right] & 1) != 0){
                niceCount++;
            }
            while(niceCount > k ){
                if((nums[left] & 1) != 0){
                niceCount--;
            }
            left++;
            }
            res+=right-left+1;
        }
        return res;
    }
    public int numberOfSubarrays(int[] nums, int k) {
        return getNiceSubArray(nums,k)-getNiceSubArray(nums,k-1);
    }
}
 

 //niceCount = 3;
 //res=1
 //k = 3
//.     l 
// [1,1,2,1,1]
//.         r

//0-3 - Atmost k
//count = 1+2+3+4+4=14

//0-2. Atmost k-1
//count  = 1+2+3+3+3 = 12


//Exactly k = (Atmost k) - (Atmost k-1)
//14-12 = 2
//then get exactly k nice subarrays

