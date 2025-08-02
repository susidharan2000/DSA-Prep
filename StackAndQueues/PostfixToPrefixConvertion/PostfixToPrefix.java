package StackAndQueues.PostfixToPrefixConvertion;

import java.util.Stack;

class Solution {
    static String postToPre(String post_exp) {
        // code here
        int n = post_exp.length();
        Stack<String> stack = new Stack<>();
        for(int i = 0;i<n;i++){
            char exp = post_exp.charAt(i);
            if((exp == '+' || exp == '-' || exp == '*' || exp == '/' || exp == '%')&& stack.size() >= 2){
                String operandOne = stack.pop();
                String operandTwo = stack.pop();
                stack.push(exp+operandTwo+operandOne);
            }else{
                stack.push(exp+"");
            }
        }
        return stack.peek();
    }
}
