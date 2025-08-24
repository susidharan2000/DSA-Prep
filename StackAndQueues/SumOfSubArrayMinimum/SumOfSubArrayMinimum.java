package StackAndQueues.SumOfSubArrayMinimum;
import java.util.*;
class Solution {
    public int sumSubMins(int[] arr) {
        int n = arr.length;
        int [] smallerLeft = new int [n];
        int [] SmallerRight = new int [n];
        Stack<Integer> stack = new Stack<>();
        //pre calculating left smaller index
        for(int i = 0;i<n;i++){
            while(!stack.isEmpty() && arr[i] < arr[stack.peek()]){
                stack.pop();
            }
            smallerLeft[i] = stack.isEmpty()?-1:stack.peek();
            stack.push(i);
        }
        //pre calculating right smaller index
        stack.clear();
        for(int i = n-1;i>=0;i--){
            while(!stack.isEmpty() && arr[i] <= arr[stack.peek()]){
                stack.pop();
            }
            SmallerRight[i] = stack.isEmpty()?n:stack.peek();
            stack.push(i);
        }
        int total = 0;
        for(int i = 0;i< n;i++){
            int left = i - smallerLeft[i];
            int right = SmallerRight[i] - i;
            total = total+(left*right*arr[i]);
        }
        return total;
    }
}
//optimal O(n) Time complixity :O(3n) 
//              space complixity:O(2n)
// i
//[3, 1, 2, 4]

//right = [1,4,4,4]
//stack = {(1,1)}

//if(arr[i] < arr[stack.peek()]) pop()



//          i
//[3, 1, 2, 4]
//left = [-1,-1,1,2]
//stack = {(2,2),(1,1)}

//arr[i] <= arr[stack.peek()]

//left = [-1,-1,1,2]
//right = [1,4,4,4]


//          i
//[3, 1, 2, 4]
// leftsmall = i - left[i]
// rihgtsmall = right[i]-i
//i = 0
// l = 3-(2) =1 
// r = 4-(3) = 1
// 1*1*arr[i]
// total = total+ (leftsmall*rihgtsmall*arr[i])

// total = 0+3+6+4+4 = 17









//Brute force Approch
// time complixity : O(n^2)
// space complixity is :O(1)
// i
//[3, 1, 2, 4]
//           j


// min = 4;

// sum = 0+3+1+1+1+1+1+1+2+2+4 = 17
