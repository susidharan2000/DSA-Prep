package BinarySearch.Median_of_Two_Sorted_Arrays;

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int n = n1+n2;
        if(n2 < n1){
            return findMedianSortedArrays(nums2,nums1);
        }
        int low = 0;
        int high = n1;
        int half = (n1+n2+1)/2;
        while(low <= high){
            int mid1 = low+(high-low)/2;
            int mid2 = half-mid1;

            int l1 = Integer.MIN_VALUE;
            int l2 = Integer.MIN_VALUE;
            int r1 = Integer.MAX_VALUE;
            int r2 = Integer.MAX_VALUE;

            if(mid1 < n1)r1 = nums1[mid1];
            if(mid2 < n2)r2 = nums2[mid2];
            if(mid1-1 >= 0) l1 = nums1[mid1-1];
            if(mid2-1 >= 0) l2 = nums2[mid2-1];

            if(l1 <= r2 && l2 <= r1){
                if(n%2 == 0){
                    return (double)(Math.max(l1,l2)+Math.min(r1,r2))/2.0;
                }else{
                    return (double)Math.max(l1,l2);
                }
            }else if(l1>r2){
                high = mid1-1;
            }else{
                low = mid1+1;
            }
        }
        return 0.0;
    }
}
// class Solution {
//     public double findMedianSortedArrays(int[] nums1, int[] nums2) {
//         int n1 = nums1.length;
//         int n2 = nums2.length;
//         int count = 0;
//         int index1 = (n1 + n2) / 2;
//         int index2 = index1 - 1;

//         int ele1 = -1;
//         int ele2 = -1;
//         int i = 0;
//         int j = 0;
//         while (i < n1 && j < n2) {
//             if (nums1[i] < nums2[j]) {
//                 if (count == index1)
//                     ele1 = nums1[i];
//                 if (count == index2)
//                     ele2 = nums1[i];
//                 count++;
//                 i++;
//             } else {
//                 if (count == index1)
//                     ele1 = nums2[j];
//                 if (count == index2)
//                     ele2 = nums2[j];
//                 count++;
//                 j++;
//             }
//         }
//         while (i < n1) {
//             if (count == index1)
//                 ele1 = nums1[i];
//             if (count == index2)
//                 ele2 = nums1[i];
//             count++;
//             i++;
//         }
//         while (j < n2) {
//             if (count == index1)
//                 ele1 = nums2[j];
//             if (count == index2)
//                 ele2 = nums2[j];
//             count++;
//             j++;
//         }
//         //result
//         if ((n1 + n2) % 2 != 0) {
//             return (double) ele1;
//         } else {
//             return (double) (ele1 + ele2) / 2.0;
//         }
//     }
// }
//time complixity:O(n+m)
//space Complixity:O(1)

//brute force Approch
// class Solution {
//     public double findMedianSortedArrays(int[] nums1, int[] nums2) {
//         int n1= nums1.length;
//         int n2 = nums2.length;
//         int [] arr = new int [n1+n2];
//         int i = 0;
//         int j = 0;
//         int k = 0;
//         while(i<n1 && j< n2){
//             if(nums1[i] < nums2[j]){
//                 arr[k++] = nums1[i++];
//             }else{
//                 arr[k++] = nums2[j++];
//             }
//         }
//         while(i<n1){
//             arr[k++] = nums1[i++];
//         }
//         while(j< n2){
//             arr[k++] = nums2[j++];
//         }
//         int mid = (n1+n2)/2;
//         if((n1+n2)%2 == 0){
//             return (double)(arr[mid]+arr[mid-1])/2.0;
//         }else{
//             return (double)arr[mid];
//         }
//     }
// }

//time complixity:O(n+m)
//space Complixity:O(n+m)
