package Greedy.MinimumPlatforms;
import java.util.*;
// class Solution {
//     static class Pair{
//         int time;
//         char status;
//         Pair(int time,char status){
//             this.time = time;
//             this.status = status;
//         }
//     }
//     public int minPlatform(int arr[], int dep[]) {
//         //  code here
//         int n = arr.length;
//         ArrayList<Pair>list = new ArrayList<>();
//         for(int i = 0;i<n;i++){
//             list.add(new Pair(arr[i],'A'));
//             list.add(new Pair(dep[i],'D'));
//         }
//         Collections.sort(list,(a,b)->{
//             if(a.time == b.time ){
//                 return Integer.compare(a.status,b.status);
//             }else{
//                 return Integer.compare(a.time,b.time);
//             }
//         });
//         int totalPlatformsRequired = 0;
//         int count = 0;
//         for(Pair train:list){
//             int time = train.time;
//             char status = train.status;
//             if(status == 'A'){
//                 count++;
//             }else{
//                 count--;
//             }
//             totalPlatformsRequired = Math.max(totalPlatformsRequired,count);
//         }
//         return totalPlatformsRequired;
//     }
//}
//time complixity:O(n log n) beacuae of sorting
//space Complixity :O(n) for list

class Solution {
    public int minPlatform(int arr[], int dep[]) {
        //  code here
        int i = 0;
        int j = 0;
        int count = 0;
        int totalPlatformsRequired = 0;
        Arrays.sort(arr);
        Arrays.sort(dep);
        while(i<arr.length && j < dep.length){
            if(arr[i] <= dep[j]){
                count++;
                i++;
            }else{
                count--;
                j++;
            }
            totalPlatformsRequired = Math.max(totalPlatformsRequired,count);
        }
        return totalPlatformsRequired;
    }
}
//                 i
//arr = [900,1235,1100]

//             j
//dep = [1000,1240,1200]

// count = 1
//timeComplixity:O(n log n)
//space Complixity:O(1)
