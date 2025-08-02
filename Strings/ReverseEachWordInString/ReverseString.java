package Strings.ReverseEachWordInString;

class Solution {
    public static String reversed(String str){
        char []arr = str.toCharArray();
        int  i= 0;
        int j = str.length()-1;
        while(i<j){
            //swap
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
        return new String(arr);
    }
    public String reverseWords(String s) {
        // Code here
        StringBuilder res = new StringBuilder();
        
        int i = 0;
        while(i<s.length()){
            //skip the space
            while(i<s.length() && s.charAt(i) == ' '){
                i++;
            }
            int start = i;
            //get the word
            while(i<s.length() && s.charAt(i) != ' '){
                i++;
            }
            String str = s.substring(start,i);
            res.append(reversed(str));
            
            // only allow to add space in mid of the sentance
            int temp = i;
            while(temp < s.length() && s.charAt(temp) == ' ')temp++;
            if(temp < s.length()){
            res.append(" ");
            }
        }
        return res.toString();
    }
}

