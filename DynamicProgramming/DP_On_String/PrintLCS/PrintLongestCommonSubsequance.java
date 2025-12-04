package DynamicProgramming.DP_On_String.PrintLCS;
import java.util.*;
// User function Template for Java

class Solution {
    public List<String> allLCS(String s1, String s2) {
        // Code here
        int n = s1.length();
        int m = s2.length();
        int [][]dp = new int [n+1][m+1];
        for(int i = 1;i<=n;i++){
            for(int j = 1;j<=m;j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = 1+dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        int len = dp[n][m];
        //get the list of the strings
        Set<String> list = new HashSet<>();
        Map<String, Boolean> memo = new HashMap<>();
        generateLCS(n,m,s1,s2,len ,new StringBuilder(),list,dp,memo);
        List<String> res = new ArrayList<>(list);
        Collections.sort(res);
        return res;
    }
    public static void generateLCS(int i,int j,String s1,String s2,int len,StringBuilder sb,Set<String> list,int [][]dp, Map<String, Boolean> memo){
        if(i == 0 || j == 0){
            if(sb.length() == len){
                list.add(sb.reverse().toString());
                sb.reverse();
            }
            return;
        }
        String key = i+"|"+j+"|"+sb.toString();
        if(memo.containsKey(key))return;
        memo.put(key,true);
        
        if(s1.charAt(i-1) == s2.charAt(j-1)){
            sb.append(s1.charAt(i-1));
            generateLCS(i-1,j-1,s1,s2,len,sb,list,dp,memo);
            sb.deleteCharAt(sb.length()-1);
        }else{
            if(dp[i][j] == dp[i-1][j]){
                generateLCS(i-1,j,s1,s2,len,sb,list,dp,memo);
            }
            if(dp[i][j] == dp[i][j-1]){
                generateLCS(i,j-1,s1,s2,len,sb,list,dp,memo);
            }
        }
    }
}
