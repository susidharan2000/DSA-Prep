import java.util.*;

//better solution
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i< nums.length;i++){
            if(map.containsKey(target-nums[i])){
                return new int []{map.get(target-nums[i]),i};
            }
            if(!map.containsKey(target-nums[i])){
                map.put(nums[i],i);
            }
    }
    return new int []{-1};
    }
}
//brute force solution
//   i
// 3,2,4
//     j
//sum = 6
//taget = 6

//[ i, j]
//tc = o(n^2)
// sc: O(1)

//better solution
//target= 6
//   i
// 3,2,4
//map = {
//  3:0 
//  2:1   
//  returned new int []{current index and map.get(target-nums[i])}
// }

//if(map.containsKey(target - nums[i])){
//     return new int []{i,map.get(target - nums[i])};
// }
//if(!map.contains(target - nums[i])){
//    map.put(nums[i],i);
//}

// tc = O(nlog m) = O(n log m)
// sc = O(m) 


//optimal solution
//target = 9
// i 
// 2,7,11,15
//   j
//sum = 9
// if(sum == target)return new int [] {i,j};
// else if(sum > target){
// j--;
// }
// else{
//     i++
// }


// //optimal solution
// class Solution {
//     public int[] twoSum(int[] nums, int target) {
//        Arrays.sort(nums);
//        int sum = 0;
//        int i = 0;
//        int j = nums.length-1;
//        while(i<j){
//         sum = nums[i]+nums[j];
//         if(sum == target)return new int []{i,j};
//         if(sum > target){
//             j--;
//         }else if(sum < target){
//             i++;
//         }
//        } 
//        return new int[]{-1};
//     }
// }

//dry run
//target = 6;
// i
// 2,3,4
//     j


//tc = O(n log n) + o(n) //it will loose its order when sorted so cant return correct index
// sc = O(1);

//so the optimal approch is not possible for this approch
