package StackAndQueues.MinStack;

import java.util.Stack;

class MinStack {
    static class Pair{
        int first;
        int second;
        Pair(int first,int second){
            this.first = first;
            this.second = second;
        }
    }
    Stack<Pair> stack;
    public MinStack() {
        stack = new Stack<>();
    }
    
    public void push(int val) {
        if(stack.isEmpty()){
            stack.push(new Pair(val,val));
        }else{
            if(val <= stack.peek().second){
                stack.push(new Pair(val,val));
            }else{
                stack.push(new Pair(val,stack.peek().second));
            }
        }
    }
    
    public void pop() {
        stack.pop();
    }
    
    public int top() {
        return stack.peek().first;
    }
    
    public int getMin() {
        return stack.peek().second;
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