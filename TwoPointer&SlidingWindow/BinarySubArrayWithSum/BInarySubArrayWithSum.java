// Brute force approch

class Solution {
    public int numberOfSubarrays(int[] arr, int target) {
        // code here
        int n = arr.length;
        int count = 0;
        for(int i = 0;i<n;i++){
            int sum = 0;
            for(int j = i;j<n;j++){
                sum+=arr[j];
                if(sum > target)break;
                if(sum == target){
                    count++;
                }
            }
        }
        return count;
    }
}

//           i
// [1, 0, 1, 0, 1]
//.             j
// sum = 0

// count = 4

// target = 2
//Time and spaceComplixity:O(n^2)
//Space Comnplixity:O(1)


//optimal approch
class OptimalSolution{
    public static int atmost(int [] arr,int k){
        int left = 0;
        int sum = 0;
        int subArrayCount = 0;
        for(int right = 0;right<arr.length;right++){
            sum+=arr[right];
            while(sum > k){
                sum-=arr[left];
                left++;
            }
            subArrayCount += right-left+1;
        }
        return subArrayCount;
    }
    public int numberOfSubarrays(int[] arr, int target) {
        // code here
        return atmost(arr,target) - atmost(arr,target-1) ;
    }
}

//              r
// [1, 0, 1, 0, 1]
//           l
// sum = 2

// 1 = count =1+2+2+3+2 = 10
// 2 -count = 1+2+3+4+4 = 14

// atmost(2) = exactly(0) + exactly(1) + exactly(2)
// atmost(1) =  exactly(0) + exactly(1) 
//exactly K subarrays = atMost(K) - atMost(K - 1)
//                    = atmost(2) - atmost(1)
//                    = exactly(0) - exactly(0) + exactly(1) - exactly(1) + exactly(2)
//exactly K subarray. = exactly(2)

// target = 2
