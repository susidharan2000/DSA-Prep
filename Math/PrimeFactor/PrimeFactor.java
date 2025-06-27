class Main {
    public static void main(String[] args) {
        // prime factor number
       int n = 80;
       for(int i = 2;i*i<=n;i++){
           if(n%i == 0){
               System.out.print(i+", ");
               while(n%i==0){
                   n/=i;
               }
           }
       }
       if (n != 1) {
            System.out.print(n);
        }
    }
}