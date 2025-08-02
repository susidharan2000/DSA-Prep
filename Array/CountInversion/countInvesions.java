package Array.CountInversion;

import java.util.*;
class Solution {
    public static int getInvertionCount(int low,int high,int []arr){
        int count  = 0;
        if(low >= high)return count ;
        int mid = (low+high)/2;
        int left = getInvertionCount(low,mid,arr);
        int right = getInvertionCount(mid+1,high,arr);
        count += left+right;
        count += merge(low,mid,high,arr);
        return count;
    }
    public static int merge(int low,int mid,int high,int [] arr){
        List<Integer> temp = new ArrayList<>();
        int count = 0;
        int left = low;
        int right = mid+1;
        while(left <= mid && right <= high){
            if(arr[left] <= arr[right]){
                temp.add(arr[left++]);
            }else{ //  arr[left] > arr[rigth].
                count+=mid-left+1;
                temp.add(arr[right++]);
            }
        }
        while(left <= mid){
            temp.add(arr[left++]);
        }
        while(right <= high){
            temp.add(arr[right++]); 
        }
        for(int i = 0;i<temp.size();i++){
            arr[i+low] = temp.get(i);
        }
        return count;
    }
    static int inversionCount(int arr[]) {
        // Code Here
        return getInvertionCount(0,arr.length-1,arr);
    }
}
//brute force solution 
//          i
//[2, 4, 1, 3, 5]
//             j
//count = 3
//tc:O(n^2)
// sc:O(1)

//optimized
// [1,2,3,4,5]

//      i
//[1,2,4]. [3,5].  mid-left+1
//            j

// i  
//[2,4][1] [3,5]
//      j

// i
//[2][4] [1] [3][5]
//.   j
//count = 3

//time complixity : O(n log n)
// space complixity :O(n)