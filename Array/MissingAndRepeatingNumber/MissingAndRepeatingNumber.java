package Array.MissingAndRepeatingNumber;
import java.util.*;

//optimal solution 
//time complixity:O(n)+O(n)+O(n) = O(3n) O(n)
//space Complixity:O(1)
class Solution {
    ArrayList<Integer> findTwoElement(int arr[]) {
        // code here
        int s = 0;
        int sn = 0;
        for(int i = 0;i<arr.length;i++){
            s^=arr[i];
            sn^=i+1;
        }
        int nums = s^sn;
        int seperator = (nums &(nums-1))^nums;
        int b1 = 0;
        int b2 = 0;
        for(int i = 0;i<arr.length;i++){
            if((arr[i] &seperator)!=0){
                b1 = b1^arr[i];
            }else{
                b2 = b2^arr[i];
            }
            if((i+1 &seperator)!=0){
                b1 = b1^i+1;
            }else{
                b2 = b2^i+1;
            }
            
        }
        //got the ans but need to find what is missing number and what is reapeating number
        int x = -1; // missing number
        int y = -1; // repeating number
        int count = 0;
        for(int i = 0;i<arr.length;i++){
           if(b1 == arr[i]){
               count++;
               if(count == 2){
                   y = b1;
                   x = b2;
               }
           } else if(b2 == arr[i]){
               count++;
               if(count == 2){
                   x = b1;
                   y = b2;
               }
           }
        }
        return new ArrayList<>(Arrays.asList(y,x));
    }
}


//optimized solution 
// class Solution {
//     ArrayList<Integer> findTwoElement(int arr[]) {
//         // code here
//         long x=-1;
//         long y=-1;
//         long n =arr.length;
//         long actualSum = 0;
//         long ExpectedSum = n*(n+1)/2;
        
//         long actualSum2 = 0;
//         long ExpectedSum2 = (n*(n+1)*((2*n)+1))/6;
//         for(int i = 0;i< n;i++){
//             actualSum+=(long)arr[i];
//             actualSum2+=(long)arr[i]*arr[i];
//         }
//         long eq1 = actualSum-ExpectedSum;//-------1
//         long eq2 = actualSum2-ExpectedSum2;
//         eq2 = eq2/eq1;//---------2
        
//         x =(eq1+eq2)/2;
//         y =x-eq1;
        
//         return new ArrayList<Integer>(Arrays.asList((int)x,(int)y));
//     }
// }

