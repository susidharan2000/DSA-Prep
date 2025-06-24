
class Solution {
    public static int getCount(int low,int high,int [] arr){
        int count  = 0;
        if(low >= high)return count;
        int mid = (low+high)/2;
        count +=getCount(low,mid,arr);
        count +=getCount(mid+1,high,arr);
        count +=merge(low,high,mid,arr);
        return count;
    }
    public static int merge(int low,int high,int mid,int[] arr){
        int count = 0;
        List<Integer> temp = new ArrayList<>();
        int left = low;
        int right = mid+1;
        while(left <= mid && right <= high){
            if(arr[left] <= arr[right]){
                temp.add(arr[left]);
                left++;
            }else{
                temp.add(arr[right]);
                //count inversion
                count += mid-left+1;
                //
                right++;
            }
        }
        //add the remaning elements
        while(left <= mid){
            temp.add(arr[left]);
            left++;
        }
        while(right <= high){
            temp.add(arr[right]);
            right++;
        }
        //transfer temp to arr
        for(int i = 0;i< temp.size();i++){
            arr[i+low] = temp.get(i);
        }
        return count;
    }
    // Function to count inversions in the array.
    static int inversionCount(int arr[]) {
        return getCount(0,arr.length-1,arr);
    }
}