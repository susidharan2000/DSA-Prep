class Solution {
    public int[] sieve(int n) {
        int [] prime = new int [n+1];
        Arrays.fill(prime,1);
        for(int i = 2;i*i<=n;i++){
            if(prime[i] == 1){
                for(int j = i*i;j<=n;j+=i){
                    prime[j] = 0;
                }
            }
        }
        List<Integer> list = new ArrayList<>();
        for(int i = 2;i<=n;i++){
            if(prime[i] == 1){
                list.add(i);
            }
        }
        int [] res = new int [list.size()];
        for(int i = 0;i<list.size();i++){
            res[i] = list.get(i);
        }
        return res;
    }
}