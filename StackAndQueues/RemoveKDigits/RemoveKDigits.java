package StackAndQueues.RemoveKDigits;
public class RemoveKDigits {
    public static void main(String[] args) {
        String str = "1432219";
        int k = 3;
        long []minVal = {Long.MAX_VALUE};
        getSmallDigit(0,minVal,str,new StringBuilder(),k);
        System.out.print(Long.toString(minVal[0]));
    }
    public static void getSmallDigit(int index,long []minVal,String str,StringBuilder sb,int k){
        if(index >= str.length()){
            if(sb.length() == str.length()-k){
                String Sval = sb.toString();
                long val = Integer.parseInt(Sval);
                minVal[0] = Math.min(val,minVal[0]);
            }
            return;
        }
        sb.append(str.charAt(index));
        getSmallDigit(index+1,minVal,str,sb,k);
        sb.deleteCharAt(sb.length()-1);
        getSmallDigit(index+1,minVal,str,sb,k);
    }
}

