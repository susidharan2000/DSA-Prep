class Solution {
    public static void getIp(int start,String s,List<String>list,List<String>res){
        //base case
        if(list.size() >= 4){
            if(start == s.length()){// means all characters in the string s is taken
                String ans = String.join(".",list);
                res.add(ans);
            }
            return;
        }
        for(int i = start;i< Math.min(s.length(),start+3);i++){
            String str = s.substring(start,i+1);
            if(str.length() > 1 && str.startsWith("0"))continue; // constraint if str atarts with 0 it in not valid
            if(Integer.parseInt(str) <= 255){
                list.add(str);
                getIp(i+1,s,list,res);
                list.remove(list.size()-1);
            } 
        }
    }
    public List<String> restoreIpAddresses(String s) {
        List<String> list = new ArrayList<>();
        List<String> res = new ArrayList<>();
        getIp(0,s,list,res);
        return res;
    }
}