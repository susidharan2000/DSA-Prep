package BinarySearch.BinarySearchBasics.BinarySearchImplementation;

public class BinarySearch {
    public int binarysearchs(int[] arr, int k) {
        return binarySearchs(0,arr.length-1,arr,k,-1);
    }
    public static int binarySearchs(int low,int high,int []arr,int k,int res){
        if(low > high)return res;
        int mid = (low+high)/2; // use ((low)+(high- low))/2 - to avoid the int overflow
        if(arr[mid] ==k){
            res = mid;
            res = binarySearchs(low,mid-1,arr,k,res);
            return res;
        }else if(k > arr[mid]){
            res = binarySearchs(mid+1,high,arr,k,res);
        }else{
            res = binarySearchs(low,mid-1,arr,k,res);
        }
        return res;
    }
}
