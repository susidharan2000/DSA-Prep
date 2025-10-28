import java.util.*;
//brute force Approch
class bruteForceSolution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int maxlen = 0;
        for(int i = 0;i<n;i++){
            int [] hashArray = new int [256];
            for(int j = i;j<n;j++){
                char ch = s.charAt(j);
                if(hashArray[ch] == 1)break;
                maxlen = Math.max(maxlen,j-i+1);
                hashArray[ch] = 1;
            }
        }
        return maxlen;
    }
}
// i
//"abcabcbb"
//    j
//time Complixity:O(n^2)
//space Complixity:O(256)

//hashSet Approch
class hashSetSolution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int left = 0;
        int maxlen = 0;
        for(int right =0;right<s.length();right++){
            char ch = s.charAt(right);
            while(set.contains(ch)){
                set.remove(s.charAt(left));
                left++;
            }
            set.add(ch);
            maxlen = Math.max(maxlen,right-left+1);
        }
        return maxlen;
    }
}

//time Complixity:O(n+n) = O(2n);
//space Complixity:O(1)

//hashmap Approch:
class hashmapSolution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> map = new HashMap<>();
        int maxLen = 0;
        int left = 0;
        for(int right= 0;right < s.length();right++){
            char ch = s.charAt(right);
            if(map.containsKey(ch)){
                left = Math.max(map.get(ch)+1,left); // \*** only update the left if is inside the window ***/
            }
            map.put(ch,right);
            maxLen = Math.max(maxLen,right-left+1);
        }
        return maxLen;
    }
}
//Time Complixity:O(n)
//space Complixity:O(n)

//    r
//"abba"
//   l

//map = {a:0,b:2}


//map contains:
//left = Math.max(map.get(ch)+1,left);//only update the left if it's inside the window
//map.put(ch,r);