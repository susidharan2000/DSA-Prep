package Math.JumpNumbers;

import java.util.LinkedList;
import java.util.Queue;

// User function Template for Java

//brute force. Solution
// time complixity:O(n)
// space complixity:O(1)

// class Solution {
//     public static boolean isJumpingNunmber(long num){
//         long PreviousDigit = -1;
//         while(num>=1){
//             long currDigit = num%10;
//             if(PreviousDigit != -1){
//             if(currDigit+1 != PreviousDigit &&currDigit-1 != PreviousDigit ){
//                 return false;
//             }
//             }
//             PreviousDigit = currDigit;
//             num/=10;
//         }
//         return true;
//     }
//     static long jumpingNums(long n) {
//         // code here
//         if(n<=10)return n; // single digit number are jumping Numbers
//         for(long i = n;i>=0;i--){
//             if(isJumpingNunmber(i)){
//                 return i;
//             }
//         }
//         return -1;
//     }
// };

class Solution {
    //helper function 
    public static long appendPlusOne(long num){ //6
        long n = num%10; //6
        if(n == 9)return -1;
        n = n+1; //7
        return (num*10)+n;//(60+7) = 67
    }
    public static long appendMinumOne(long num){//6
        long n = num%10; //6
        if(n == 0)return -1;
        n = n-1; //5
        return (num*10)+n; //60+5 = 65
    }
    
    static long jumpingNums(long n) {
        // code here
        long res = -1;
        Queue<Long>queue = new LinkedList<>();
        for(long i = 1;i<=9;i++){
            queue.offer(i);
        }
        while(!queue.isEmpty()){
            long num = queue.poll();
            if(num <= n){
               // res = Math.max(res, num); //safe when the enqueue order changes
                res = num;
            }
            else{
                continue;
            }
            long plusOne = appendPlusOne(num);
            long minusOne = appendMinumOne(num);
            if(minusOne!= -1){
                queue.offer(minusOne);
            }
            if(plusOne != -1){
                queue.offer(plusOne);
            }
        }
        return res;
    }
}

//Time Complexity=O(2^d)