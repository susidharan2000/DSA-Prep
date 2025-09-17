package BinarySearch.AllocateMinimumPages;

class Solution {
    // function to Allocate pages to student
    public static boolean canAllocatePages(int MinumumPages,int []arr,int students){
        int i = 0;
        int TotalPages = 0;
        int Totalstudents = 1;
        while(i<arr.length){
            if(arr[i]+TotalPages > MinumumPages){
                TotalPages = 0;
                Totalstudents++;
                if(Totalstudents > students)return false;
            }
            TotalPages+=arr[i];
            i++;
        }
        return true;
    }
    public int findPages(int[] arr, int k) {
        // code here
        if(k>arr.length)return -1;
        int n = arr.length;
        // range low and high
        int low = 0;
        int high = 0;
        for(int i = 0;i<n;i++){
            low = Math.max(low,arr[i]);
            high += arr[i];
        }
        // search on answers
        int minimumPages = -1;
        while(low <= high){
            int mid = low+(high-low)/2;
            if(canAllocatePages(mid,arr,k)){
                minimumPages = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return minimumPages;
    }
}