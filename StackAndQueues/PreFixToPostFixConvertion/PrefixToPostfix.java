package StackAndQueues.PreFixToPostFixConvertion;

import java.util.Stack;

class Solution {
    static String preToPost(String pre_exp) {
        // code here
        int n = pre_exp.length();
        Stack<String> stack = new Stack<>();
        for(int i = n-1;i>=0;i--){
            char exp = pre_exp.charAt(i);
            if((exp == '+' || exp == '-' || exp == '/' || exp == '%' || exp == '*') && stack.size() >= 2){
                String operandOne =stack.pop();
                String operandTwo = stack.pop();
                stack.push(operandOne+operandTwo+exp);
            }else{
                stack.push(exp+"");
            }
        }
        return stack.peek();
    }
}

