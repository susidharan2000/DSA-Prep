class Solution {
    public static void getPartiation(int index,String s,List<String>list,List<List<String>>res){
        if(index >= s.length()){
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i = index;i< s.length();i++){
            String str = s.substring(index,i+1);
            if(isPalindrome(str)){ // chaeck if the sub string is palindrime or not 
                list.add(str); 
                getPartiation(i+1,s,list,res);
                list.remove(list.size()-1); //back track
            } 
        }
    }
    //logic to check if the string is palindrome or not
    public static boolean isPalindrome(String str){
        int i = 0;
        int j = str.length()-1;
        while(i<j){
            if(str.charAt(i) != str.charAt(j))return false;
            i++;
            j--;
        }
        return true;
    }
    public List<List<String>> partition(String s) {
        List<String> list = new ArrayList<>();
        List<List<String>> res= new ArrayList<>();
        getPartiation(0,s,list,res);
        return res;
    }
}