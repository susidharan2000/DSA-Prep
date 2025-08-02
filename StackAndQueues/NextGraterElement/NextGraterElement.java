package StackAndQueues.NextGraterElement;
import java.util.*;
class Solution {
    public ArrayList<Integer> nextLargerElement(int[] arr) {
        // code here
        int n = arr.length;
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> res = new ArrayList<>();
        for(int i = 0;i<n;i++){
            res.add(0);
        }
        for(int i = n-1;i>=0;i--){
            while(!stack.isEmpty() && arr[i] >= stack.peek()){
                stack.pop();
            }
            if(stack.isEmpty()){
                res.set(i,-1);
            }else{
                res.set(i,stack.peek());
            }
            stack.push(arr[i]);
        }
        return res;
    }
}

// i
//[6, 8, 0, 1, 3]

// stack = {6,8}
// res = [8,-1,1,3,-1]


// |
// |
// |
// |.  |
// |.  |. |
// |   |. |. 