package StackAndQueues.AstroidCollision;
import java.util.*;
// User function Template for Java
class Solution {
    public static int[] asteroidCollision(int N, int[] asteroids) {
        // code here
        Deque<Integer> stack = new LinkedList<>();
        for(int astroid:asteroids){
            boolean isDestroyed = false;
            while(!stack.isEmpty() && astroid < 0 && stack.peekLast() > 0){
                if( !stack.isEmpty() && Math.abs(astroid)  > stack.peekLast()){
                    stack.removeLast();
                }else if(!stack.isEmpty() && Math.abs(astroid)  == stack.peekLast()){
                    isDestroyed = true;
                    stack.removeLast();
                    break;
                }else{
                    isDestroyed = true;
                    break;
                }
            }
            if(!isDestroyed){
            stack.addLast(astroid);
            }
        }
        int[] res = new int [stack.size()];
        int i = 0;
        for(int ele :stack){
            res[i++] = ele;
        }
        return res;
    }
}

