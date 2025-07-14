class Solution {
    int missingNum(int arr[]) {
        // code here
        int n = arr.length+1;
        int res = 0;
        for(int i = 1;i<=n;i++){
            res = res ^ i;
        }
        for(int j = 0;j<arr.length;j++){
            res = res ^ arr[j];
        }
        return res;
    }
}
// time complixity - O(n)+O(n+1) - O(n)



class Solution {
    int missingNum(int arr[]) {
        // code here
        int n = arr.length+1;
        int sum = 0;
        int totalSum = 0;
        for(int i = 0;i< arr.length;i++){
            sum+=arr[i];
        }
        totalSum = (n*(n+1))/2;
        return totalSum - sum;
    }
}

// [1,2,3,5]

// n = 4+1
// sum = 11
// 1+2+3+4+5.....+N
//n*(n+1)/2
// 5*(5+1)/2
// 5*3
// 15

// WITH MISSING ELEMENT SUM = 15
//  without missing element = 11
//  result = 15-11
// resut = 4