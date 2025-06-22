class Solution {
    public static boolean isValid(char[][]board,char ch,int row,int col){
        for(int i = 0;i<9;i++){
            //row     check the entire row for the duplication
            if(board[i][col] == ch){
                return false;
            }
            //col      check the entire column for the duplication
            if(board[row][i] == ch){
                return false;
            }
            //box      check the entire sub matrix(box) for the duplication
            int boxX = (3*(row/3)+i/3);
            int boxY = (3*(col/3)+i%3);
            if(board[boxX][boxY] == ch){
                return false;
            }
        }
        return true;
    }
    public static boolean solveSudokuBoard(char[][]board){
        //here lools throung the entire board 
        for(int i = 0;i< 9;i++){
            for(int j =0;j< board[i].length;j++){
                //if find  any empty  means '.'
                if(board[i][j] == '.'){
                    // generating all combination from 1 to 9
                    for(char ch= '1';ch <='9';ch++){
                        // chaeck valadation 
                        if(isValid(board,ch,i,j)){
                        board[i][j]= ch; // place the value and do recursive call
                    if(solveSudokuBoard(board))return true; // solved
                       board[i][j]= '.'; //backtrack
                        }
                    }
                    return false; // means no combination accepted this path cannot solove return fasle
                }
            }
        }
        return true; // looped through entire board all are filled means puzzle solved
    }
    public void solveSudoku(char[][] board) {
        solveSudokuBoard(board);
    }
}