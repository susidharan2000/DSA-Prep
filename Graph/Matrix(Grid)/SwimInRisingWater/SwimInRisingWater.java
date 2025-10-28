import java.util.*;
class Solution {
    // to store the cell coordinates
    public static class Cell{
        int row;
        int col;
        Cell(int row,int col){
            this.row = row;
            this.col = col;
        }
    }
    public int swimInWater(int[][] grid) {
        //square Matrix
        int n = grid.length;
        int maxValue = Integer.MIN_VALUE;
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                maxValue = Math.max(grid[i][j],maxValue);
            }
        }
        //binary Search on the time from (0 to MaxValue of grid)
        int res = -1;
        int low = 0;
        int high = maxValue;
        while(low <= high){
            int mid = low+(high-low)/2;
            if(isReachable(grid,mid)){
                // if dstination is reachable store the result and try smaller time
                res = mid;
                high = mid - 1;
            }else{
                //if the destination is not reachable try higher time
                low = mid + 1;
            }
        }
        return res;
    }
    //helper function to check the destination is reachable or not
    public static boolean isReachable(int [][]grid,int time){
        int n = grid.length;
        boolean [][] visited = new boolean [n][n];
        Queue<Cell> queue = new LinkedList<>();
        // add the source to the queue
        if(grid[0][0] <= time){
            visited[0][0] = true;
            queue.offer(new Cell(0,0));
        }
        //Breath first Search
        while(!queue.isEmpty()){
            Cell currCell = queue.poll();
            int currRow = currCell.row;
            int currCol = currCell.col;
            //reacheas the destination(Base case)
            if(currRow == n-1 && currCol == n-1){
                return true;
            }
            //directions
            int [] dx = {-1,0,1,0};
            int [] dy = {0,1,0,-1};
            //try all 4 directions
            for(int i = 0 ;i<4;i++){
                int newRow = currRow+dx[i];
                int newCol = currCol+dy[i];
                //boundary Check and Visited cell check
                if(newRow >= 0 && newCol >= 0 && newRow < n && newCol < n && !visited[newRow][newCol]){
                    visited[newRow][newCol] = true;
                    //if the height less than or equal to time we can swim through the cell
                    if(grid[newRow][newCol] <= time){
                        queue.offer(new Cell(newRow,newCol));
                    }
                }
            }
        }
        return false;
    }
}