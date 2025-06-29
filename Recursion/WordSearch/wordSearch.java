class Solution {
    public static boolean search(int row,int col,char[][]board,int [][]visited,String word,int p){
        if(row < 0 || col < 0 || row >= board.length || col >= board[0].length)return false;
        if(visited[row][col] == 1 || board[row][col] != word.charAt(p))return false;
        if(p == word.length()-1)return true;
        visited[row][col] = 1;
       if(search(row-1,col,board,visited,word,p+1))return true;
        if(search(row,col+1,board,visited,word,p+1))return true;
        if(search(row+1,col,board,visited,word,p+1))return true;
        if(search(row,col-1,board,visited,word,p+1))return true;
        visited[row][col] = 0;
        return false;
    }
    public boolean exist(char[][] board, String word) {
        int [][]visited = new int[board.length][board[0].length];
        for(int i =0;i< board.length;i++){
            for(int j = 0;j< board[i].length;j++){
                if(visited[i][j] == 0){
                if(search(i,j,board,visited,word,0))return true;
                }
            }
        }
        return false;
    }
}