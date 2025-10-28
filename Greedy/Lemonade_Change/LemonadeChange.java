package Greedy.Lemonade_Change;

class Solution {
    public boolean lemonadeChange(int[] bills) {
        int fives = 0;
        int tens = 0;
        for(int bill:bills){
            if(bill == 5){
                fives++;
            }else if(bill == 10){
                //return change 5
                if(fives == 0)return false;
                fives--;
                tens++;
            }else{
                //return change of 15
                //1)case 1: 1*10 && 1*5
                //2)case 2: 3*5
                if(tens >= 1 && fives >= 1){
                   fives--; 
                   tens--;
                }else if(fives >= 3){
                    fives-=3;
                }else{
                    return false;
                }
            }
        }
        return true;
    }
}
