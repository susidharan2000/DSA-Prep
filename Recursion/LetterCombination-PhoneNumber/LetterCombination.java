/**
 * This Java class generates all possible letter combinations corresponding to a given string of digits
 * using a recursive approach.
 */
class Solution {
    public static void getCombination(int i,String digits,StringBuilder sb,List<String>res,Map<Character,String> map){
        if(digits.length() == 0)return ;
        if(i>=digits.length()){ // it reaches to digits then hits the basecase
        //base case
         res.add(sb.toString());
         return;
        }
        String letters = map.get(digits.charAt(i));
        //put all combination of letters
        for(int j = 0;j< letters.length();j++){
            sb.append(letters.charAt(j));  // add and check combination
            getCombination(i+1,digits,sb,res,map);
            sb.deleteCharAt(sb.length() - 1); // back track to find all pissibilities
        }
    }
    public List<String> letterCombinations(String digits) {
        Map<Character,String> map = new HashMap<>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        StringBuilder sb = new StringBuilder();
        List<String> res = new ArrayList<>();
        getCombination(0,digits,sb,res,map);
        return res;
    }
}