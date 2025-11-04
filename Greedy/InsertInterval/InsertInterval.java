package Greedy.InsertInterval;

import java.util.*;

class Solution {
    public ArrayList<int[]> insertInterval(int[][] intervals, int[] newInterval) {
        // code here
        int n = intervals.length;
        ArrayList<int [] >list = new ArrayList<>();
        list.add(intervals[0]);
        int i = 1;
        while(i<n){
            if(intervals[i][0] > newInterval[0])break;
            list.add(intervals[i]);
            i++;
        }
        //merge the new interval
        int []prevInterval = list.get(list.size()-1);
        if(prevInterval[1] >= newInterval[0]){
            //merge
            prevInterval[0] = Math.min(newInterval[0],prevInterval[0]);
            prevInterval[1] = Math.max(newInterval[1],prevInterval[1]);
        }else{
            //add it the list
            list.add(newInterval);
        }
        // // process the remaning intervals
        while(i<n){
            prevInterval = list.get(list.size()-1);
            int [] currInterval = intervals[i];
            if(prevInterval[1] >= currInterval[0]){
                //merge if overlap
                prevInterval[0] = Math.min(currInterval[0],prevInterval[0]);
                prevInterval[1] = Math.max(currInterval[1],prevInterval[1]);
            }else{
                //add it the list
                list.add(currInterval);
            }
            i++;
        }
        return list;
    }
}
