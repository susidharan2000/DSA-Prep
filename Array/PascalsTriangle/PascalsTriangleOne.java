package Array.PascalsTriangle;
import java.util.*;
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(new ArrayList<>());
        triangle.get(0).add(1);
        for(int i = 1;i<numRows;i++){
            List<Integer> row = new ArrayList<>();
            List<Integer> preRow = triangle.get(i-1); //previous row
            row.add(1);
            for(int j = 1;j<i;j++){
                int sum  = preRow.get(j-1)+preRow.get(j);
                row.add(sum);
            }
            row.add(1);
            triangle.add(row);
        }
        return triangle;
    }
}
