package StackAndQueues.StockSpan;
import java.util.*;
class StockSpanner {
    static class Pair{
        int stock;
        int span;
        Pair(int stock,int span){
            this.stock = stock;
            this.span = span;
        }
    }
    Stack<Pair> stack;
    public StockSpanner() {
       stack = new Stack<>();
    }
    
    public int next(int price) {
        if(stack.isEmpty()){
            stack.push(new Pair(price,1));
            return 1;
        }
        if(price <  stack.peek().stock){
            stack.push(new Pair(price,1));
            return 1;
        }
        int newSpan = 1;
        while(!stack.isEmpty() && price >=  stack.peek().stock){
            //take span
            newSpan += stack.pop().span;
        }
        stack.push(new Pair(price,newSpan));
        return stack.peek().span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */