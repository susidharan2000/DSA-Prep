package Array.ArrangeArrayElementsBySign;
import java.util.*;
class Solution {
    void rearrange(ArrayList<Integer> arr) {
        // code here
        List<Integer> negArray = new ArrayList<>();
        List<Integer> posArray = new ArrayList<>();
        for(int i = 0;i< arr.size();i++){
            if(arr.get(i) >= 0){
                posArray.add(arr.get(i));
            }else{
                negArray.add(arr.get(i));
            }
        }
        int posIndex = 0;
        int negIndex = 0;
        int i = 0;
        int len = Math.min(posArray.size(),negArray.size());
        while(posIndex < len && negIndex < len){
        arr.set(i,posArray.get(posIndex));
        posIndex++;
        i++;
        arr.set(i,negArray.get(negIndex));
        negIndex++;
        i++;
        }
        while(posIndex <  posArray.size()){
            arr.set(i,posArray.get(posIndex));
            i++;
            posIndex++;
        }
        while(negIndex < negArray.size()){
            arr.set(i,negArray.get(negIndex));
            i++;
            negIndex++;
        }
    }
}
//        i
// 9, 4, -2, -1, 5, 0, -5, -3, 2
//.
// p = 0;
// n = 0;
// //              p
// posArray = {9,4,5,0,2};
// //                n
// negArray = {-2,-1,-5,-3};
// len = Math.min(posArray.length,negArray.length)
// i = 0
// while( p< len && N < len){
//     arr[i] = posArray.get(p)
//     p++;
//     i++;
//     arr[i] = negArray.get(n)
//     n++;
//     i++;
// }
// arr[] = {9,-2,4,-1,5}
// Time Complixity : O(n)+O(n) = O(2n)
// Space Complixity : O(n/2)+O(n/2) = O(4n/4) = O(n)
//[3,1,-2,-5,2,-4]

// arr1 = [3,1,2]; if nums[i] < 0
// arr2 = [-2,-5,-4]; if nums[i] > 0

// [3,-2,1,-5,2,-4]