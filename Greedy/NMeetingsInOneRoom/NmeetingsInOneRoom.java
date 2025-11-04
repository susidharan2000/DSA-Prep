package Greedy.NMeetingsInOneRoom;
import java.util.*;
class Solution {
    // Function to find the maximum number of meetings that can
    // be performed in a meeting room.
    public static class Meeting{
        int start;
        int end;
        Meeting(int start,int end){
            this.start = start;
            this.end = end;
        }
    }
    public int maxMeetings(int start[], int end[]) {
        // add your code here
        int totalMeeting = 1;
        int n = start.length;
        List<Meeting> meetings = new ArrayList<>();
        for(int i = 0;i<n;i++){
            meetings.add(new Meeting(start[i],end[i]));
        }
        Collections.sort(meetings,(a,b)->Integer.compare(a.end, b.end));
        Meeting prev = meetings.get(0);
        for(int i = 1;i<meetings.size();i++){
            Meeting curr = meetings.get(i);
            if(curr.start > prev.end){
                prev = meetings.get(i);
                totalMeeting++;
            }
        }
        return totalMeeting;
    }
}


//Meeitng = {(1,2),(3,4),(0,6),(5,7),(8,9),(5,9)}
