class Solution {
    public static void getCombination(int row,int n,char[][]board,List<List<String>>res){
        if(row >= n){
            List<String> temp = new ArrayList<>();
            for(char[]ch:board){
                temp.add(new String(ch));
            }
            res.add(temp);
            return;
        }
        for(int i = 0;i<n;i++){
            if(board[row][i] == '.'){
                if(isSafe(row,i,board)){
                    board[row][i] = 'Q';
                    getCombination(row+1,n,board,res);
                    board[row][i] = '.';
                }
            }
        }
    }
    public static boolean isSafe(int row,int col,char[][]board){
        //up
        for(int i = row-1;i>=0;i--){
            if(board[i][col] == 'Q')return false;
        }
        //up right
        for(int i = row-1,j = col+1;i>=0 && j<board.length;i--,j++){
            if(board[i][j] == 'Q')return false;
    }
    //up left
    for(int i = row-1,j = col-1;i>=0 && j>=0;i--,j--){
        if(board[i][j] == 'Q')return false;
    }
    return true;
    }
    public List<List<String>> solveNQueens(int n) {
        List<List<String>>res = new ArrayList<>();
        char[][]board = new char[n][n];
        for(int i = 0;i< n;i++){
            for(int j = 0;j< n;j++){
                board[i][j] = '.';
            }
        }
        getCombination(0,n,board,res);
        return res;
    }
}