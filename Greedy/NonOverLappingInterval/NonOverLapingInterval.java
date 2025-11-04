package Greedy.NonOverLappingInterval;

import java.util.Arrays;

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        int overlap = 0;
        Arrays.sort(intervals,(a,b)->Integer.compare(a[1],b[1]));
        int [] prev = intervals[0];
        for(int i = 1;i<n;i++){
            int [] curr = intervals[i];
            if(prev[1] <= curr[0]){
                prev = intervals[i];
            }else{
            overlap++;
            }
        }
        return overlap;
    }
}
 //                   p   
//[[1,11],[2,12],[11,22],[1,100]]
//.                       c         
//o = 2
