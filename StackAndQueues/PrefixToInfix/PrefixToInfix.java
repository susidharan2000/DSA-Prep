package StackAndQueues.PrefixToInfix;

import java.util.Stack;

class Solution {
    static String preToInfix(String pre_exp) {
        // code here
        int n = pre_exp.length();
        Stack<String>stack = new Stack<>();
        for(int i = n-1;i>=0;i--){
            char val = pre_exp.charAt(i);
            if((val == '+' ||val == '-' || val == '*' || val == '/' || val == '%') && stack.size() >= 2){
                String val1 = stack.pop();
                String val2 = stack.pop();
                stack.push("("+val1+val+val2+")");
            }else{
                stack.push(val+"");
            }
        }
        return stack.peek();
    }
}
