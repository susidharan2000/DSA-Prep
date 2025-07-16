class Solution {
    public void sortColors(int[] nums) {
        int low = 0;
        int high = nums.length-1;
        int mid = 0;
        while(mid <= high){
            if(nums[mid] == 0){
                swap(mid,low,nums);
                mid++;
                low++;
            }else if(nums[mid] == 1){
                mid++;
            }
            else if(nums[mid] == 2){
                swap(mid,high,nums);
                high--;
            }
        }
    }
    public static void swap(int i,int j,int [] arr){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
//        l
// // 0,0,1,1,2,2
//             m         
//           h

// if(m == 0){
//     swap(l,m,arr);
//     mid++;
//     low++;
// }
// else if(m == 1){
// mid++;
// }
// else if(m == 2){
//     swap(mis,high,arr);
//     high--;
// }
