package Greedy.Candy;

// class Solution {
//     public int candy(int[] ratings) {
//         int n = ratings.length;
//         int []left = new int [n];
//         left[0] = 1;
//         int []right = new int [n];
//         right[n-1] = 1;
//         //left
//         for(int i = 1;i<n;i++){
//             if(ratings[i] > ratings[i-1]){
//                 left[i] = left[i-1]+1;
//             }else{
//                 left[i] = 1;
//             }
//         }
//         //right
//         for(int i = n-2;i>=0;i--){
//             if(ratings[i] > ratings[i+1]){
//                 right[i] = right[i+1]+1;
//             }else{
//                 right[i] = 1;
//             }
//         }
//         int sum = 0;
//         for(int i = 0;i<n;i++){
//             sum+=Math.max(left[i],right[i]);
//         }
//         return sum;
//     }
// }
//time Complixity:O(3n)
//space complixity:O(2n)


//better solution
// class Solution {
//     public int candy(int[] ratings) {
//         int n = ratings.length;
//         int []left = new int [n];
//         left[0] = 1;
//         //left
//         for(int i = 1;i<n;i++){
//             if(ratings[i] > ratings[i-1]){
//                 left[i] = left[i-1]+1;
//             }else{
//                 left[i] = 1;
//             }
//         }
//         int sum = Math.max(left[n-1],1);
//         int right = 1;
//         for(int i = n-2;i>=0;i--){
//             if(ratings[i] > ratings[i+1]){
//                 right = right+1;
//             }else{
//                 right = 1;
//             }
//             sum+=Math.max(left[i],right);
//         }
//         return sum;
//     }
// }
//time Complixity:O(2n)
//space complixity:O(n)


class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int i = 1;
        int sum = 1;
        while(i<n){
            //flat
            while(i<n && ratings[i] == ratings[i-1]){
                sum = sum+1;
                i++;
                continue;
            }
            //up slope
            int peak = 1;
            while(i<n && ratings[i] > ratings[i-1]){
                peak +=1;
                sum+=peak;
                i++;
            }
            //down wards
            int down = 0;
            while(i<n && ratings[i] < ratings[i-1]){
                down +=1;
                sum+=down;
                i++;
            }
            if(down >= peak){
                sum+=(down-peak)+1;
            }
        }
        return sum;
    }
}

//time Complixity:O(n)
//space complixity:O(1)

