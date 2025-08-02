package StackAndQueues.MinStack;
import java.util.*;
class MinStack {
    Stack<Long> stack;
    long min;
    public MinStack() {
       stack = new Stack<>();
       min = 0;
    }
    
    public void push(int val) {
        if(stack.isEmpty()){
            min = (long)val;
            stack.push((long)val);
        }else{
            if(val < min){
                long newVal = (long)(2L*val)-min;
                min = val;
                stack.push(newVal);
            }else{
                stack.push((long)val);
            }
        }
    }
    
    public void pop() {
        if(stack.isEmpty())return;
        if(stack.peek() < min){
            min = (long)(2L*min)-stack.peek();
        }
        stack.pop();
    }
    
    public int top() {
        if(stack.isEmpty())return -1;
        if(stack.peek() < min){
            return (int)min;
        }
        return (int)(long)stack.peek();
    }
    
    public int getMin() {
        return (int)min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
