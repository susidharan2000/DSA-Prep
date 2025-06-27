class Solution {
    public double myPow(double x, int n) {
        double ans = 1;
        long N = n;
        long m = n;
        N = Math.abs(N);
        while(N>0){
            if(N % 2 != 0){ //odd opwer
                ans = ans * x; // adding extracted result to ouput
                N--; //make it even power
            }else{ //even power
                N = N/2; 
                x = x*x;  
            }
        }
        if(m < 0)return 1/ans;
        return ans;
    }
}