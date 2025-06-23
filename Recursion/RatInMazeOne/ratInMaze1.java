class Solution {
    public static void getPath(int [][]maze,StringBuilder sb,List<String> res){
        int [][] visited = new int [maze.length][maze[0].length];
        dfs(0,0,maze,visited,sb,res);
    }
    public static void dfs(int row,int col,int [][]maze,int [][]visited,StringBuilder sb,List<String>res){
        // boundry condition of matrix
        if(row<0 || col<0 || row >= maze.length || col >= maze[0].length)return;
        if(maze[row][col] == 0 || visited[row][col] == 1)return;
        visited[row][col] = 1;
        //base condition
        if(row == maze.length-1 && col == maze.length-1){
            res.add(sb.toString());
        }
        // Correct order for lexicographical output: D, L, R, U
        //down
        sb.append("D");
        dfs(row+1,col,maze,visited,sb,res);
        sb.deleteCharAt(sb.length() - 1);
        //left
        sb.append("L");
        dfs(row,col-1,maze,visited,sb,res);
        sb.deleteCharAt(sb.length() - 1);
        //right
        sb.append("R");
        dfs(row,col+1,maze,visited,sb,res);
        sb.deleteCharAt(sb.length() - 1);
        //up
        sb.append("U");
        dfs(row-1,col,maze,visited,sb,res);
        sb.deleteCharAt(sb.length() - 1);
        visited[row][col] = 0; // backtrack
    }
    // Function to find all possible paths
    public ArrayList<String> ratInMaze(int[][] maze) {
        // code here
        StringBuilder sb = new StringBuilder();
        ArrayList<String> res = new ArrayList<>();
        getPath(maze,sb,res);
        return res;
    }
}