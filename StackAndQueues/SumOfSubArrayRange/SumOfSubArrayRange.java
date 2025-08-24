package StackAndQueues.SumOfSubArrayRange;
import java.util.*;
class Solution {
    public static long subarrayRanges(int[] arr) {
        // code here
        int n = arr.length;
        // calculate the sum on max
        int [] leftBoundrymax = new int [n];
        Stack<Integer> stack = new Stack<>();
        for(int i = 0;i< n;i++){
            while(!stack.isEmpty() && arr[i] >= arr[stack.peek()]){
                stack.pop();
            }
            leftBoundrymax[i] = stack.isEmpty()?-1:stack.peek();
            stack.push(i);
        }
        stack.clear();
        int [] rightBoundrymax = new int [n];
        for(int i = n-1;i>=0;i--){
            while(!stack.isEmpty() && arr[i] > arr[stack.peek()]){
               stack.pop(); 
            }
            rightBoundrymax[i] = stack.isEmpty()?n:stack.peek();
            stack.push(i);
        }
        long maxSum = 0;
        for(int i = 0;i< arr.length;i++){
            int left = i -leftBoundrymax[i];
            int right = rightBoundrymax[i] - i;
            maxSum+=(long) left*right*arr[i];
        }
        //caculate the sum min
        stack.clear();
        int [] leftBoundrymin = new int [n];
        for(int i= 0;i< n;i++){
            while(!stack.isEmpty() && arr[i]<= arr[stack.peek()]){
                stack.pop();
            }
            leftBoundrymin[i] = stack.isEmpty()?-1:stack.peek();
            stack.push(i);
        }
        stack.clear();
        int []rightBoundarymin = new int [n];
        for(int i = n-1;i>=0;i--){
            while(!stack.isEmpty() && arr[i] < arr[stack.peek()]){
                stack.pop();
            }
            rightBoundarymin[i] = stack.isEmpty()?n:stack.peek();
            stack.push(i);
        }
        long minSum = 0;
        for(int i = 0;i< arr.length;i++){
            int left = i - leftBoundrymin[i];
            int right = rightBoundarymin[i] - i;
            minSum+=(long)left*right*arr[i];
        }
        return maxSum-minSum;
    }
}