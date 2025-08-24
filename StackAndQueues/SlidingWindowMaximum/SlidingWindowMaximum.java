package StackAndQueues.SlidingWindowMaximum;
import java.util.*;
public class SlidingWindowMaximum {
    //brute force approch
    public static void getMax(int [] arr,int k){
        List<Integer> list = new ArrayList<>();
        for(int i = 0;i<=arr.length-k;i++){
            int mavVal = arr[i];
            for(int j = i;j<i+k;j++){
                mavVal = Math.max(mavVal,arr[j]);
            }
            list.add(mavVal);
        }
        System.out.println(list);
    }
    // monotonic queue
    public static void getMAxOpt(int []arr,int k){
        Deque<Integer> dq = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        for(int i = 0;i<k;i++){
            while(!dq.isEmpty() && arr[i] > arr[dq.peekLast()]){
                dq.pollLast();
            }
            dq.addLast(i);
        }
        res.add(arr[dq.peekFirst()]);
        for(int i = k;i<arr.length;i++){
            while(!dq.isEmpty() && arr[i] > arr[dq.peekLast()]){
                dq.pollLast();
            }
            dq.addLast(i);
            //is the peekFirst is valid in the range
            while(!dq.isEmpty() &&  dq.peekFirst() < i-k+1 ) {
                dq.pollFirst();
            }
            res.add(arr[dq.peekFirst()]);
        }
        System.out.println(res);
    }

    public static void main(String [] args){
        int [] arr = {1,3,-1,-3,5,3,2,1,6};
        int k = 3;
        // calls the brute force function
        getMax(arr,k);
        //calls the optimized function
        getMAxOpt(arr,k);
    }
}
