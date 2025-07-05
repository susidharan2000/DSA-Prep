class Solution {
    public static int countBitsFlip(int a, int b) {
        // code here
        int res = a^b;
        int count = 0;
        while(res != 0){
            count+=res&1;
         res =res >>  1;   
        }
        return count;
    }
}