package StackAndQueues.ValidParanthesis;
import java.util.*;
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0;i< s.length();i++){
            char para = s.charAt(i);
            if(para == '(' || para == '[' || para == '{'){
                stack.push(para);
                continue;
            }
            if(!stack.isEmpty() ){
                if(para == ')' &&  stack.peek() == '('){
                    stack.pop();
                }else if(para == ']' &&  stack.peek() == '['){
                    stack.pop();
                }else if(para == '}' &&  stack.peek() == '{'){
                    stack.pop();
                }else{
                    stack.push(para);
                }
            }else{
                return false;
            }
        }
        if(stack.isEmpty())return true;
        return false;
    }
}
