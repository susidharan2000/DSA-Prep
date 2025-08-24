package StackAndQueues.MaximumRectangle;
import java.util.*;
class Solution {
    public int maximalRectangle(char[][] matrix) {
        int maxRectangle = 0;
        int []height = new int [matrix[0].length];
        //do vertical traversal to stimulate the height array and max rectangle
        for(int i = 0;i< matrix.length;i++){
           for(int j = 0;j<matrix[i].length;j++){
            if(matrix[i][j] == '0'){
                height[j] = 0;
            }
            else{
                height[j]++;
            }
           }
           maxRectangle = Math.max(maxRectangle,getMaxRectangle(height));
        }
        return maxRectangle;
    }
    // helper function to get max rectangle
    public static int getMaxRectangle(int [] arr){
        int maxRectangle = 0;
            //stack
            Stack<Integer> stack = new Stack<>();
            for(int j = 0;j<arr.length;j++){
                while(!stack.isEmpty() && arr[j] < arr[stack.peek()]){
                    int height = arr[stack.pop()];
                    int pse = stack.isEmpty()?-1:stack.peek();
                    int nse = j;
                    int base = nse-pse-1;
                    int area = height*base;
                    maxRectangle = Math.max(area,maxRectangle);
                }
                stack.push(j);
            }
            //calculate for remanimg rectangles
                while(!stack.isEmpty()){
                    int height = arr[stack.pop()];
                    int pse = stack.isEmpty()?-1:stack.peek();
                    int nse = arr.length;
                    int base = nse-pse-1;
                    int area = height*base;
                    maxRectangle = Math.max(area,maxRectangle);
                }
            stack.clear();
        return maxRectangle;
    }
}