class Solution {
    public int[] singleNumber(int[] nums) {
        int xorr = 0;
        for(int i = 0;i< nums.length;i++){
            xorr = xorr ^ nums[i];
        }
        int b1 = 0;
        int b2 = 0;
        //rightmost
        int rightMost = (xorr & xorr-1) ^ (xorr);
        for(int i = 0;i< nums.length;i++){
            if((rightMost & nums[i]) != 0){
                b1= b1^nums[i];
            }else{
                b2 = b2^nums[i];
            }
        }
        return new int []{b1,b2};
    }
}


// 1:  001
// 2:  010
// 1:  001
//          3:  011
// 2:  010
//          5:  101
        

// 3^5 - 6 -  n 110
//          n-1 101 &
             
//              rightmost - 100
//                          110   ^

//                          010
//              b1 = 
//              b2 = 
                  


// right