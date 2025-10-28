 class Solution {
    public int characterReplacement(String s, int k) {
        int maxLength = 0;
        int maxCharCount = Integer.MIN_VALUE;
        for(int i = 0;i<s.length();i++){
            int [] hashArray = new int [26];
            for(int j = i;j<s.length();j++){
                char ch = s.charAt(j);
                hashArray[ch-'A']++;
                maxCharCount = Math.max(maxCharCount,hashArray[ch-'A']);
                int subStringLength = j-i+1;
                if((subStringLength - maxCharCount) > k)break;
                maxLength = Math.max(subStringLength,maxLength);
            }
        }
        return maxLength;
    }
}
//k = 1
//.  i
// "AABABBA"
//   j

//maxCount = 1
//[3,2]

//maxLength: 4
//Time Complixity : O(n^2)
//Space Complixity:O(26)



//optimized approch
class Solution2 {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int maxLength = 0;
        int [] hashArray = new int [26];
        int maxCharCount = 0;
        int left = 0;
        for(int right = 0;right<n;right++){

            char rightChar = s.charAt(right);
            hashArray[rightChar-'A']++;
            maxCharCount = Math.max(maxCharCount,hashArray[rightChar-'A']);

            // check the substring is valid
            if(left < n && (right-left+1)- maxCharCount > k){ // while loop is safe
                char leftChar = s.charAt(left);
                hashArray[leftChar-'A']--;
                left++;
                //update the maxCharCount
                //maxCharCount = getMaxChar(hashArray);
            }
            //updation the maxLength of the substirng
            maxLength = Math.max(maxLength,right-left+1);
        }
        return maxLength;
    }
    public static int getMaxChar(int [] arr){
        int maxCount = 0;
        for(int i = 0;i<26;i++){
            maxCount = Math.max(arr[i],maxCount);
        }
        return maxCount;
    }
}


//k = 1
//        r
// "AABABBA"
//     l

//[1,3]
//maxCount = 3
//minCount = 1 <= k:1
//maxLen = 4

//Time Complixity:O(n)
//Space Complixity:O(26)


