class Solution {
    public static boolean isMcolorPossible(int v,int [][]edges,int m){
        //edges to adj list
        List<List<Integer>>adj = new ArrayList<>();
        for(int i = 0;i< v;i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0;i< edges.length;i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        int [] nodeColor = new int [v];
        //starting with z th node
        if(putcolor(0,adj,m,nodeColor))return true;
        return false;
    }
    public static boolean putcolor(int curr,List<List<Integer>>adj,int m,int []nodecolor){
        //base case
        if (isCollerfilled(nodecolor)) return true;
        // try all possible combimation
                for(int c = 1;c<=m;c++){
                    // check if the neighbour color has the same color
                if(isSafe(curr,adj,c,nodecolor)){
                    nodecolor[curr] = c;
                    if(putcolor(curr+1,adj,m,nodecolor))return true; // got solution
                    nodecolor[curr] = 0; // backtrack
                }
                }
                return false;
    }
    public static boolean isSafe(int curr,List<List<Integer>>adj,int color,int []nodecolor){
        for(int neighbour:adj.get(curr)){
            if(nodecolor[neighbour] == color)return false;
        }
        return true;
    }
    public static boolean isCollerfilled(int []arr){
        for(int i = 0;i< arr.length;i++){
            if(arr[i] == 0)return false;
        }
        return true;
    }
    boolean graphColoring(int v, int[][] edges, int m) {
        // code here
        return isMcolorPossible(v,edges,m);
    }
}