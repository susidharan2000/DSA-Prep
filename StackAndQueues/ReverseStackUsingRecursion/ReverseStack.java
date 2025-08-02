package StackAndQueues.ReverseStackUsingRecursion;

import java.util.Stack;

// User function Template for Java

class Solution {
    public static void insertBottm(int popVal,Stack<Integer>stack){
        if(stack.isEmpty()){
            stack.push(popVal);
            return;
        }else{
            int x = stack.pop();
            insertBottm(popVal,stack);
            stack.push(x);
        }
    }
    public static void reverseStack(Stack<Integer>stack){
        if(stack.isEmpty())return;
        int popval = stack.pop();
        reverse(stack);
        insertBottm(popval,stack);
    }
    static void reverse(Stack<Integer> s) {
        // add your code here
        reverseStack(s);
    }
}