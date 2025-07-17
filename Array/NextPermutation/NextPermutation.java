package Array.NextPermutation;

class Solution {
    //sawp helper function
    public static void swap(int i,int j,int []nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    //helper function reverse
    public static void reverse(int i,int j,int [] arr){
        while(i<j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int pivot = -1;
        for(int i = n-2;i>=0;i--){
            if(nums[i] < nums[i+1]){
                pivot = i;
                break;
            }
        }
        if(pivot == -1){
            reverse(0,n-1,nums);
        }else{
            // find its succussor
        for(int i = n-1;i>=0;i--){
            if(nums[pivot] < nums[i]){
                swap(pivot,i,nums);
                break;
            }
        }
            reverse(pivot+1,n-1,nums);
        }
    }
}

// p =-1
//    p i
// [1,3,2]

// if(nums[i] < nums[i+1]){
//     pivot = i;
// }
