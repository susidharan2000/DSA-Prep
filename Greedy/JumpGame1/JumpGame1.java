package Greedy.JumpGame1;

//bfs approch
// class Solution {
//     public boolean canJump(int[] nums) {
//         int n = nums.length;
//         boolean []visited = new boolean[n];
//         Queue<int []> queue = new LinkedList<>();//0:jump  //1:position
//         //source to the queue
//         queue.offer(new int []{nums[0],0});
//         visited[0] = true;
//         //process
//         while(!queue.isEmpty()){
//             int []curr = queue.poll();
//             int jump = curr[0];
//             int position = curr[1];
//             if(position == n-1)return true;
//             //add jump values to the queue
//             for(int i = position+1;i<=position+jump;i++){
//                 if(!visited[i]){
//                     visited[i] = true;
//                     if(i == n-1)return true;
//                     queue.offer(new int []{nums[i],i});
//                 }
//             }
//         }
//         return false;
//     }
// }
//time Complixity:O(n^2)
//space Complixity:O(n)+O(n)


class Solution {
    public boolean canJump(int[] nums) {
        int range = 0;
        int n = nums.length;
        if(n == 1)return true;
        for(int i = 0;i < n-1;i++){
            if(nums[i] == 0 && range == i)return false;
            range = Math.max(nums[i]+i,range);
            if(range >= n-1)return true;
        }
        return false;
    }
}
//n-1  = 4
//              i
//nums = [3,2,1,0,4]

//range = 3
//if(range >= n-1)return true;


