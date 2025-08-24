package StackAndQueues.MaximumRectangleInHistogram;
import java.util.*;
//Brute force Solution
// class Solution {
//     public int largestRectangleArea(int[] heights) {
//         int n = heights.length;
//         int []leftBoundry = new int [n];
//         int []rigthBoundry = new int [n];
//         //pre-compute the left boundery 
//         Stack<Integer> stack = new Stack<>();
//         for(int i = 0;i<n;i++){
//             while(!stack.isEmpty() && heights[i] <= heights[stack.peek()]){
//                 stack.pop();
//             }
//             leftBoundry[i] = stack.isEmpty()?-1:stack.peek();
//             stack.push(i);
//         }
//         stack.clear();
//         //precompute the right
//         for(int i = n-1;i>=0;i--){
//             while(!stack.isEmpty() && heights[i] < heights[stack.peek()]){
//                 stack.pop();
//             }
//             rigthBoundry[i] = stack.isEmpty()?n:stack.peek();
//             stack.push(i);
//         }

//         //get max rectangle
//         int maxRectangle = 0;
//         for(int i = 0;i< n;i++){
//             int left = i - leftBoundry[i];
//             int right = rigthBoundry[i] - i;
//             int base = left+right-1;
//             int rectangle = heights[i]*base;
//             maxRectangle = Math.max(rectangle,maxRectangle);
//         }
//         return maxRectangle;
//     }
// }
//time complixity :O(n)+O(n)+O(n) = O(3n)
//space omplicity:O(2n)


// optimal approch
class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int maxRectangle = Integer.MIN_VALUE;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0;i<n;i++){
            while( !stack.isEmpty() && heights[i] < heights[stack.peek()]){
            int nse = i;
            int height = heights[stack.pop()];
            int pse = stack.isEmpty()?-1:stack.peek();
            int rectangle = height * (nse - pse - 1);
            maxRectangle = Math.max(rectangle,maxRectangle);
            }
            stack.push(i);
        }
        while(!stack.isEmpty()){
            int nse = n;
            int height = heights[stack.pop()];
            int pse = stack.isEmpty()?-1:stack.peek();
            int rectangle = height * (nse - pse - 1);
            maxRectangle = Math.max(rectangle,maxRectangle);
        }
        return maxRectangle;
    }
}

//time complixity :O(n)
//space omplicity:O(n)


