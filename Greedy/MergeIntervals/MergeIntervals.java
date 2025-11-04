package Greedy.MergeIntervals;

import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
        List<int []> list = new ArrayList<>();
        list.add(intervals[0]);
        for(int i = 1;i<n;i++){
            int [] prevInterval = list.get(list.size()-1);
            int [] currInterval = intervals[i];
            if(prevInterval[1] >= currInterval[0]){
                //overlap mean merge 
                prevInterval[0] = Math.min(prevInterval[0],currInterval[0]);
                prevInterval[1] = Math.max(prevInterval[1],currInterval[1]);
            }else{
                //else add to the list
                list.add(currInterval);
            }
        }
        int [][]result = new int [list.size()][2];
        int i = 0;
        for(int []interval : list){
            result[i++] = interval;
        }
        return result;
    }
}
