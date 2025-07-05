class Solution {
    static class Pair{
        int node;
        int time;
        Pair(int node,int time){
            this.node = node;
            this.time = time;
        }
    }
    public static int getMinTime(int n,int [][]edges){
        //converting edges to list
        List<List<int[]>> adj = new ArrayList<>();
        for(int i = 0;i< n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0;i< edges.length;i++){
            adj.get(edges[i][0]).add(new int []{edges[i][1],edges[i][2],edges[i][3]});
        }
        int [] time = new int [n];
        Arrays.fill(time,Integer.MAX_VALUE);
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->a.time-b.time);
        pq.offer(new Pair(0,0));
        //bfs
        while(!pq.isEmpty()){
            Pair curr = pq.poll();
            int currNode = curr.node;
            int currTime = curr.time;
            for(int []neighbour:adj.get(currNode)){
                int adjnode = neighbour[0];
                int adjStart = neighbour[1];
                int adjend = neighbour[2];
                int waitTime = Math.max(0,adjStart-currTime); //calculate the wait time 
                int arrivalTime = currTime+waitTime; //calculate arrival time
                if(arrivalTime <= adjend && arrivalTime < time[adjnode]){
                    time[adjnode]= arrivalTime+1;
                    pq.offer(new Pair(adjnode,arrivalTime+1));
                }
            }
        }
        return time[n-1] == Integer.MAX_VALUE?-1:time[n-1];
    }
    public int minTime(int n, int[][] edges) {
        if (n == 1) return 0;
        return getMinTime(n,edges);
    }
}