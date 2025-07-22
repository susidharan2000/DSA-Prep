package Array.SetMatrix0;


//optimal solution
class Solution {
    public void setMatrixZeroes(int[][] mat) {
        // code here
        //row -> matrix[..][0]; to track row
        //col - >matrix[0][..]; to track col
        //traversing the entire matrix and mark the row and col tracker
        int col0 = 1;
        for(int i = 0;i< mat.length;i++){
            for(int j= 0;j<mat[0].length;j++){
                if(mat[i][j] == 0){
                    mat[i][0] = 0;
                    if(j != 0){
                    mat[0][j] = 0;    
                }else{
                    col0 = 0;
                }
            }
        }
        }
        //now 
        for(int i = 1;i< mat.length;i++){
            for(int j =1 ;j< mat[i].length;j++){
                if(mat[i][0] == 0 || mat[0][j] == 0){
                    if(mat[i][j] != 0){
                    mat[i][j] = 0;
                    }
                }
            }
        }
        //check for the first row and colummn
        if(mat[0][0] == 0){
            for(int i = 1;i< mat[0].length;i++){
                if(mat[0][i] != 0){
                mat[0][i] = 0;
                }
            }
        }
        if(col0 == 0){
            for(int i = 0;i< mat.length;i++){
                if(mat[i][0] != 0){
                mat[i][0] = 0;
                }
            }
        }
    }
}
//Time complixity :O(n*m)+O(m*m)+O(m+n)
// time comlixity: O(1);









// Better solution

// class Solution {
//     public void setMatrixZeroes(int[][] mat) {
//         // code here
//         boolean [] row = new boolean [mat.length];
//         boolean [] col = new boolean [mat[0].length];
//         for(int i = 0;i< mat.length;i++){
//             for(int j = 0;j<mat[i].length;j++){
//                 if(mat[i][j] == 0){
//                     row[i]  = true;
//                     col[j] = true;
//                 }
//             }
//         }
//         for(int i = 0;i< mat.length;i++){
//             for(int j = 0;j<mat[i].length;j++){
//                 if(row[i] || col[j]){
//                     mat[i][j] = 0;
//                 }
//             }
//         }
//     }
// }

// Row = [011]
// col = [0110]

//   0 1 1 0
  
// 0  0 0 0 0 
// 1  0 4 5 0
// 1  0 3 1 0

// if(row[i] == 0 || col [i] == 0){
//     matrix[i][j] = 0
// }
// time complixity: O(m*n)+O(m*n)
// space cpmplixity:O(m+n)
