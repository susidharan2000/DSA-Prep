//better solution solution
// class Solution {
//     public void rotate(int[][] matrix) {
//         // transpose
//         int n = matrix.length;
//         for(int i = 0;i< n;i++){
//             for(int j = i+1;j<n;j++){ // if i give j = 0 it will undo the swapped cells so start with 
//                 // Swap matrix[i][j] and matrix[j][i]
//                 int temp = matrix[i][j];
//                 matrix[i][j] = matrix[j][i];
//                 matrix[j][i] = temp;
//             }
//         }
//         // reverse the matris
//         for(int[] mat:matrix){
//             reverse(mat);
//         }
//     }
//     public static void reverse(int [] mat){
//         int i = 0;
//         int j = mat.length-1;
//         while(i<j){
//             //swap()
//             int temp = mat[i];
//             mat[i] = mat[j];
//             mat[j] = temp;
//             i++;
//             j--;
//         }
//     }
// }
//time complixity : O(n*n)+O(n*n) = O(2(n*n))
//space complixity: O(1)


class Solution {
    public void rotate(int[][] matrix) {
        // transpose
        int n = matrix.length;
        for(int i = 0;i< n;i++){
            for(int j = i+1;j<n;j++){ // if i give j = 0 it will undo the swapped cells so start with 
                // Swap matrix[i][j] and matrix[j][i]
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
            //reverse the matrix
            reverse(matrix[i]);
        }
    }
    public static void reverse(int [] mat){
        int i = 0;
        int j = mat.length-1;
        while(i<j){
            //swap()
            int temp = mat[i];
            mat[i] = mat[j];
            mat[j] = temp;
            i++;
            j--;
        }
    }
}
//time complixity : O(n*n)= O(n*n)
//space complixity: O(1)