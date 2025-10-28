package Greedy.AvoidFloodInCity;
import java.util.*;
class Solution {
    public int[] avoidFlood(int[] rains) {
        int n = rains.length;
        Map<Integer,Integer> map = new HashMap<>();
        TreeSet<Integer> drydays = new TreeSet<>();
        int []ans = new int[n];
        for(int i = 0;i<n;i++){
            if(rains[i] == 0){
                drydays.add(i);
            }else{
                ans[i] = -1;
                if(map.containsKey(rains[i])){
                    int previousRainDay = map.get(rains[i]);
                    Integer vaildDryday = drydays.higher(previousRainDay);
                    if(vaildDryday != null){
                        map.put(rains[i],i);
                        drydays.remove(vaildDryday);
                        ans[vaildDryday] = rains[i];
                    }else{
                        return new int []{};
                    }
                }else{
                    map.put(rains[i],i);
                }
            }
        }
        for(int i = 0;i<n;i++){
            if(ans[i] == 0)ans[i] = 1;
        }
        return ans;
    }
}
