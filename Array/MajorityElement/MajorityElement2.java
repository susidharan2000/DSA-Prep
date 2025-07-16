class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int major1 = 0;
        int major2 = 0;
        int count1 = 0;
        int count2 = 0;
        for(int i = 0;i<nums.length;i++){
            if(nums[i] == major1){
                count1++;
            }else if(nums[i] == major2){
                count2++;
            }
            else if(count1 == 0){
                major1 = nums[i];
                count1++;
            }else if(count2 == 0){
                major2 = nums[i];
                count2++;
            }else{
                count1--;
                count2--;
            }
        }
        int m1count = 0;
        int m2count = 0;
        for(int i =0;i<nums.length;i++){
            if(nums[i] == major1)m1count++;
            if(nums[i] == major2)m2count++;
        }
        List<Integer> list = new ArrayList<>();
        if(m1count > nums.length/3){
            list.add(major1);
        }
        if(major1 != major2  && m2count > nums.length/3){
            list.add(major2);
        }
        return list;
    }
}

// n = 10 3.333 
//                    i
// [5,5,5,5,7,7,7,2,7,2]

// m1 = 5
// c1 = 2

// m2 = 7
// c2 = 2

// //do another traversal
// m1count  = 4
// m2count = 4
// if(m1count > n/3){
//     list.add(m1);
// }
// if(m2count > n/3){
//     list.add(m2);
// }





