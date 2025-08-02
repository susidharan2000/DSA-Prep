package Array.MergeTwoSortedArray;

//optimal solution - time Complixity:O(log2(n+m))+O(n+m)
class Solution {
    public void mergeArrays(int a[], int b[]) {
        // code here
        int n = a.length;
        int m = b.length;
        int gap = (n+m)/2+(n+m)%2;// to ceil
        while(gap > 0){
        int left = 0;
        int right = gap+left;
        while(right< m+n){
           // left in a and right in b
            if(left < n && right >= n){
                if(a[left] > b[right-n])swap(a,b,left,right-n);
            }else if(left >= n){ //  both left and right in  array b
                if(b[left-n] > b[right-n])swap(b,b,left-n,right-n);
            }else{ //  both left and right in  array a
                if(a[left] > a[right])swap(a,a,left,right);
            }
            right++;
            left++;
        }
        if(gap == 1)break;
        gap = gap/2+gap%2;
        }
    }
    public static void swap(int [] a,int []b,int i,int j){
        int temp = a[i];
        a[i] = b[j];
        b[j] = temp;
    }
}
    // l.             r
// [2, 4, 7, 10]  [2, 3]

// class Solution {
//     public void mergeArrays(int a[], int b[]) {
//         // code here
//         int i = a.length-1;
//         int j = 0;
//         while(i >= 0 && j <b.length){
//             if(a[i] > b[j]){
//                 swap(i,j,a,b);
//             }
//             i--;
//             j++;
//         }
//         Arrays.sort(a);
//         Arrays.sort(b);
//     }
//     public static void swap(int i,int j,int [] a,int []b){
//         int temp = a[i];
//         a[i] = b[j];
//         b[j] = temp;
//     }
// }
//time complixity: O(min(n,m))+O(n log n)+O(m log m) = O(n log n + m log m)
// space complixity: O(1)
