class Solution {
    public static void getPossibleTitles(int start,char[]tiles,int []count){
        Set<Character> set = new HashSet<>(); 
        for(int i = start;i< tiles.length;i++){
            if(set.contains(tiles[i]))continue;
            set.add(tiles[i]);
            count[0]++;
            swap(start,i,tiles);
            getPossibleTitles(start+1,tiles,count);
            swap(start,i,tiles);
        }
    }
    public static void swap(int i,int j,char[]tiles){
        char temp = tiles[i];
        tiles[i] = tiles[j];
        tiles[j] = temp;
    }
    public int numTilePossibilities(String tiles) {
        int [] count = {0};
        char []arr = tiles.toCharArray();
        getPossibleTitles(0,arr,count);
        return count[0];
    }
}