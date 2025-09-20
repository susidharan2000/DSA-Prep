package BinarySearch.Mimimize_The_Maximum_distance_Gas_Station;

import java.util.PriorityQueue;

//Brute Force Solution
class Solution1 {
    public double minMaxDist(int[] stations, int K) {
        // code here
        int n = stations.length;
        // traks the new station position
        int []position = new int [n];
        // placing k number of stations
        for(int s = 1;s<=K;s++){
            double maxDistance = -1;
            int maxIndex = 0;
            // finds the maximum distance between the stations
            for(int i = 1;i<n;i++){
                double currDistance = ((double)stations[i]-(double)stations[i-1])/((double)position[i]+1.0);
                if(currDistance > maxDistance){
                    maxDistance = currDistance;
                    maxIndex = i;
                }
            }
            position[maxIndex]++; //putting the station i between that index
        }
        double result = 0.0;
        //finding the maximum distance between the stations
        for(int i = 1;i<n;i++){
             double currDistance = ((double)stations[i]-(double)stations[i-1])/((double)position[i]+1.0);
            result = Math.max(currDistance,result);
        }
        return result;
    }
}
//Time complixity : O(K*n)
//space complixity : O(n)


// Heap based solution
class Solution2 {
    static class Pair{
        double distance;
        int NumOfStations;
        Pair(double distance,int NumOfStations){
            this.distance = distance;
            this.NumOfStations = NumOfStations;
        }
    }
    public double minMaxDist(int[] stations, int K) {
        // code here
        int n = stations.length;
        // initializing the priority Queue to store the distance and station position
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> 
            Double.compare(
                b.distance/(b.NumOfStations+1.0),
                a.distance/(a.NumOfStations+1.0)
            ));
        // putting all the gashStation data in to the heap
        for(int i = 1;i<n;i++){
            double distance = stations[i] - stations[i-1];
            pq.offer(new Pair(distance,0));
        }
        //placing the  k stations in the position
        for(int i = 0;i<K;i++){
            if(pq.isEmpty())continue;
            Pair CurrDistance = pq.poll();
            CurrDistance.NumOfStations++;
            pq.offer(CurrDistance);
        }
        // get the maximum distance
        if(!pq.isEmpty()){
        Pair Currdistance = pq.poll();
        return Currdistance.distance/(double)(Currdistance.NumOfStations+1.0);
        }
        return 0.0;
    }
}
// Time Complixity:O(k log n)
// space complixity :O(n)



// Binary Search Solution
class Solution3 {
    public static int numberOfStationsCanPlace(int [] arr,double distance){
        int stations = 0;
        int n = arr.length;
        for(int i = 1;i<n;i++){
            int diff = arr[i] - arr[i-1];
            stations+=(int)Math.ceil((double)diff/distance)-1;
        }
        return stations;
    }
    public double minMaxDist(int[] stations, int K) {
        // code here
        int n = stations.length;
        int maxDistance = 0;
        for(int i = 1;i<n;i++){
            maxDistance = Math.max(stations[i] - stations[i-1],maxDistance);
        }
        //declaring range
        double low = 0;
        double high = maxDistance;
        //brute force
        // for(double i = 0.01;i<=high;i+=1e-2){
        //     if(numberOfStationsCanPlace(stations,i)<=K)return i;
        // }
        //binary search
        while(high-low > 1e-6){
            double mid = (low+high)/2.0;
            if(numberOfStationsCanPlace(stations,mid)<=K){
                high = mid;
            }else{
                low = mid;
            }
        }
        return low;
    }
}
//time complixioty:O(n log (max Gap))
//space complixity:O(1)