package StackAndQueues.RemoveKDigits;
import java.util.*;
// Greedy + monotonic stack
class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> stack= new Stack<>();
        for(int i = 0;i<num.length();i++){
            char ch = num.charAt(i);
            while(!stack.isEmpty() && k>0 && ch < stack.peek()){
                stack.pop();
                k--;
            }
            stack.push(ch);
        }
        while(!stack.isEmpty() && k > 0){
            stack.pop();
            k--;
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        //reverse
        sb.reverse();
        // remove the leading zeros
            int i = 0;
            while(sb.length() > i && sb.charAt(i) == '0'){
                i++;
            }
            sb.delete(0, i);
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
//Time complixity:O(n)+O(n)+O(n)+O(n) = O(4n)
//SpaceComplixity:O(n)



