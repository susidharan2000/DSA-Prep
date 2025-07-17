// Kadane’s Algorithm – Optimal (O(n))
class Main {
    public static void main(String[] args) {
        int [] nums ={-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int start = 0;
        int tempStart = 0;
        int end = 0;
        int sum =0;
        int maxsum = Integer.MIN_VALUE;
        for(int i = 0;i< nums.length;i++){
            if(nums[i] > nums[i]+sum){
    tempStart = i;//3
    sum = nums[i];
}else{
    sum = nums[i]+sum;
}
if(sum > maxsum){
    maxsum = sum;
    start = tempStart;
    end = i;
}
        }
        System.out.println(start);
    System.out.println(end);
    }
}


// sum = -1
// maxsum = 6
// start = 0;
// end = 0;
//                            i
//-2, 1, -3, 4, -1, 2, 1, -5, 4
//temp start = 
// if(nums[i] > nums[i]+sum){
//     tempStart = i;//3
//     sum = nums[i];
// }else{
//     sum = nums[i]+sum;
// }
// if(sum > maxsum){
//     maxsum = sum;
//     start = tempStart;
//     end = i;
// }