// boyer-moore majority voting algorithm
import java.util.*;
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int m1 = 0;
        int m2 = 0;
        int c1 = 0;
        int c2 = 0;
        int n = nums.length;
        List<Integer> list = new ArrayList<>();
        for(int i = 0;i< n;i++){
            if(m1 == nums[i]){
                c1++;
            }else if(m2 == nums[i]){
                c2++;
            }else if(c1 == 0){
                m1 = nums[i];
                c1 =1;
            }else if(c2 == 0){
                m2 = nums[i];
                c2 = 1;
            }
            else{
                c1--;
                c2--;
            }
        }
        int count1 = 0;
        int count2 = 0;
        for(int i = 0;i< n;i++){
            if(nums[i] == m1){
                count1++;
            }else if(nums[i] == m2){
                count2++;
            }
        }
        if(count1 > n/3){
            list.add(m1);
        }
        if(count2 > n/3){
            list.add(m2);
        }
        return list;
    }
}

// n = 10
//           i
//[3,4,3,2,4,3,3,4,4,2]

// m1 = 3;  c1 = 2
// m2 = 4;  c2 = 2

// if(m1 == nums[i]){
//     c1++;
//}
// else if(m2 == nums[i]){
//     c2++;
// }
// }else if(c1 == 0){
//     m1 = nums[i];
// }
//else if(c2 == 0){
//     m2 = nums[i];
// }else{
//     c1--;
//     c2--;
// }
//.                  i
//[3,4,3,2,4,3,3,4,4,2]
// m1 = 3 = count1 = 4
// m2 = 4 = cout2 = 4
// if(count1 > n/3){
//     list.add(m1);
// }
// if(count2 > n/3){
//     list.add(m2);
// } return list;

//tc : O(n)+O(n)= O(2n)
//sc : O(1)

//************   Oder matters */
// Phase 1: Candidate Selection (Voting Phase)

// We maintain two variables to store potential majority candidates (m1 and m2), and two counters (c1 and c2) for their respective frequencies.

// For each number in the array:

// If the number matches the first candidate (m1), increment c1.
// Else if the number matches the second candidate (m2), increment c2.
// Else if c1 is 0, assign the number to m1 and set c1 = 1.
// Else if c2 is 0, assign the number to m2 and set c2 = 1.
// Else, decrement both c1 and c2.
