// User function Template for Java

//optimal approch
class Solution {
    // Function to return a list containing the intersection of two arrays.
    static ArrayList<Integer> intersection(int arr1[], int arr2[]) {
        ArrayList<Integer> list = new ArrayList<>();
        int i = 0;
        int j = 0;
        while(i<arr1.length && j<arr2.length){
            if(arr1[i] > arr2[j]){
                j++;
            }
            else if(arr1[i] < arr2[j]){
                i++;
            }else if(arr1[i] == arr2[j]){
                if(!list.isEmpty() && list.get(list.size()-1) == arr1[i]){
                    i++;
                    j++;
                    continue;
                }
                list.add(arr1[i]);
                i++;
                j++;
            }
        }
        return list;
    }
}
// Time complexity: O(n + m)
// Space complexity: O(1) (excluding output list)




 //brute force approch
class Solution {
    // Function to return a list containing the intersection of two arrays.
    static ArrayList<Integer> intersection(int arr1[], int arr2[]) {
        int [] visited = new int [arr2.length];
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0;i< arr1.length;i++){
            for(int j = 0;j<arr2.length;j++){
                if(arr1[i] == arr2[j] && visited[j] == 0){
                    list.add(arr2[j]);
                    visited[j] =1;
                    break;
                }
            }
        }
        return list;
    }
}

//time complixity - O(m*n)