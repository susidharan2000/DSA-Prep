package Array.SprialMatrix;

import java.util.*;
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int top = 0;
        int bottom = matrix.length-1;
        int left = 0;
        int right = matrix[0].length-1;
        List<Integer> res = new ArrayList<>();
        while(left <= right && top <= bottom){
        for(int i= left;i<=right;i++){
            res.add(matrix[top][i]);
        }
        top++;
        for(int i = top;i<=bottom;i++){
            res.add(matrix[i][right]);
        }
        right--;
        if(top <= bottom){ // when (top == botom) in this case the top row is already traversed the the bottom row should not treaversed
            for(int i = right;i>=left;i--){
            res.add(matrix[bottom][i]);
        }
        bottom--;
        }
        if(left <= right){  // when (left == right) in this case the right column is already traversed the the left should not traversed
        for(int i = bottom;i>=top;i--){
            res.add(matrix[i][left]);
        }
        left++;
        }
        }
        return res;
    }
}

// t = 2
// b = 1
// l = 1;
// r = 1
// [1,2,3,4,8,12,11,10,9,5]6