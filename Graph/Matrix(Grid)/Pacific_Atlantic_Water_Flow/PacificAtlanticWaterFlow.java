import java.util.*;
class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        List<List<Integer>> res = new ArrayList<>();
        boolean [][]reachableToPacific = new boolean [n][m]; // false
        boolean [][]reachableToAtlantic = new boolean [n][m]; // false
        //pacific traversal
        for(int i = 0;i<m;i++){
            dfs(0,i,heights,reachableToPacific,-1);
        }
        for(int i = 1;i<n;i++){
            dfs(i,0,heights,reachableToPacific,-1);
        }
        //Atlantic traversal
        for(int i = 0;i<m;i++){
            dfs(n-1,i,heights,reachableToAtlantic,-1);
        }
        for(int i = 0;i<n;i++){
            dfs(i,m-1,heights,reachableToAtlantic,-1);
        }

        //get the result
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(reachableToPacific[i][j] && reachableToAtlantic[i][j]){
                    res.add(new ArrayList<>(Arrays.asList(i,j)));
                }
            }
        }
        return res;
    }
    // hepler function to check the cell are reachable by ocean
    public static void dfs(int row,int col,int [][] heights,boolean [][] reachableToOcean,int previousHeight){
        if(row < 0 || col < 0 || row >= heights.length || col >= heights[0].length)return;
        if(previousHeight != -1 && previousHeight > heights[row][col])return;
        if(reachableToOcean[row][col])return;
        reachableToOcean[row][col] = true;
        //up
        dfs(row-1,col,heights,reachableToOcean,heights[row][col]);
        //right
        dfs(row,col+1,heights,reachableToOcean,heights[row][col]);
        //down
        dfs(row+1,col,heights,reachableToOcean,heights[row][col]);
        //left
        dfs(row,col-1,heights,reachableToOcean,heights[row][col]);
    }
}
