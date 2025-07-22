package Array.countSubArrayWithGivenXor;

import java.util.*;
//optimal solution time complixity - O(n)
//                  space complixity - O(n)
class Solution {
    public long subarrayXor(int arr[], int k) {
        // code here
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        long count = 0;
        int xorr = 0;
        for(int i = 0;i< arr.length;i++){
            xorr^=arr[i];
        if(map.containsKey(xorr^k)){
            count += (long)map.get(xorr^k);
        }
        map.put(xorr,map.getOrDefault(xorr,0)+1);
        }
        return count;
    }
}

// // k = 6
//.x = xorr ^ k if it is in map add its count        
// xorr = 2
//.             i
// [4, 2, 2, 6, 4]
//count  = 4

// xorr = k ^ x
// xorr ^ k = (k^x)^k
// xorr ^ k = x


// map<xorr,count> = {
//     0:1,
//     4:2,
//     6:1,
//     2:1
    
// }




// brute force Approch - time complixity :O(n^2)
//                      - time complixity:O(1) 
// class Solution {
//     public long subarrayXor(int arr[], int k) {
//         // code here
//         long count = 0;
//         for(int i = 0;i< arr.length;i++){
//             long xorr = 0;
//             for(int j = i; j<arr.length;j++){
//                 xorr^=arr[j];
//                 if(xorr == k){
//                     count++;
//                 }
//             }
//         }
//         return count;
//     }
// }
//  i
// [4, 2, 2, 6, 4]
//.    j

// xorr = 6
// // k = 6

// count  = 1
