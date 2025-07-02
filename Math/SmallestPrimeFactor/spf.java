// User function Template for Java
class Solution {
    // Sieve of Eratosthenes for building the smallest prime factor
    public static int [] spf(int n){
        int [] spf = new int [n+1];
        for(int i = 0;i<=n;i++){
            spf[i] = i;
        }
        for(int i = 2;i*i<=n;i++){
            if(spf[i] == i){
                for(int j = i*i;j<=n;j+=i){
                    if(spf[j] == j){
                        spf[j] = i;
                    }
                }
            }
        }
        return spf;
    }
    public int[] leastPrimeFactor(int n) {
       return spf(n);
    }
}