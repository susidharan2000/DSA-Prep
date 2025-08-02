package StackAndQueues.PreviousSmallerElement;

import java.util.Stack;

class Solution {
    public int[] leftSmaller(int[] arr) {
        // code here
        int n = arr.length;
        Stack<Integer> stack = new Stack<>();
        int []res = new int [n];
        for(int i = 0;i< n;i++){
            while(!stack.isEmpty() && arr[i] <= stack.peek()){
                stack.pop();
            }
            res[i] = stack.isEmpty()?-1:stack.peek();
            stack.push(arr[i]); //push currnt element into the stack
        }
        return res;
    }
}

//                 i
// [1, 5, 0, 3, 4, 5]

//stack = {5,4,3,0}
// res = {-1,1,-1,0,3,4}

//arr[i] <= stack.peek() :  pop()
