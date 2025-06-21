/**
 * The given Java class implements the Merge Sort algorithm to sort an array of integers in ascending
 * order.
 */
import java.util.*;
class Main {
    public static void MergeSort(int low,int high, int []arr){
        //base case if arr left 1 return and merge
        if(low >= high)return;
        //dividing the array into two equal halfs untill array size is one
        int mid = (low+high)/2; //calculate mid to divide equal
        MergeSort(low,mid,arr); // start to mid 
        MergeSort(mid+1,high,arr); // mid+1 to end
        // sort and merge array
        merge(low,mid,high,arr);
    }
    public static void merge(int low,int mid,int high,int [] arr){
        List<Integer> temp = new ArrayList<>();
        int left = low;// left is starting index of left array 
        int right =mid+1;// right is starting index of right array
        //sort the two arrays and put answer in temp
        while(left <= mid && right <= high){
            if(arr[left] < arr[right]){
                temp.add(arr[left]);
                left++;
            }
            else{
                temp.add(arr[right]);
                right++;
            }
        }
        //if there is remaning element in left arr add to temp
        while(left <= mid){
            temp.add(arr[left]);
            left++;
        }
        //if there is remaning elemnent right arr add to temp 
        while(right <= mid){
            temp.add(arr[right]);
            right++;
        }
        //transfer the values form temp to original arr
        for(int i = 0;i< temp.size();i++){
            arr[i+low] = temp.get(i);
        }
    }
    public static void main(String[] args) {
        int [] arr = {5,6,4,7,3,8,2,0,9,1};
        MergeSort(0,arr.length-1,arr);
        System.out.print(Arrays.toString(arr));
    }
}