package StackAndQueues.CloneStack;
import java.util.*;
class Solution {
    void clonestack(Stack<Integer> st, Stack<Integer> cloned) {
        // code here
        int n = st.size();
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n-i;j++){
                cloned.push(st.pop());
            }
            int top = cloned.peek();
            for(int j = 0;j<n-i;j++){
                st.push(cloned.pop());
            }
            cloned.push(top);
        }
    }
}
