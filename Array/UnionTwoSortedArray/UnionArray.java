import java.util.ArrayList;

// a,b : the arrays
class Solution {
    // Function to return a list containing the union of the two arrays.
    public static ArrayList<Integer> findUnion(int a[], int b[]) {
        // add your code here
        ArrayList<Integer> res = new ArrayList<>();
        int i = 0;
        int j = 0;
        while(i < a.length && j< b.length){ // min(n,m)
            if(a[i] < b[j]){
                if(!res.isEmpty() && res.get(res.size()-1) == a[i]){i++;continue;}
                res.add(a[i]);
                i++;
            }else{
                if(!res.isEmpty() && res.get(res.size()-1) == b[j]){j++;continue;}
                res.add(b[j]);
                j++;
            }
        }
        while(i<a.length) // o(n) - min(n,m)
        { 
        if(!res.isEmpty() && res.get(res.size()-1) == a[i]){i++;continue;}
        res.add(a[i++]);
        }
        while(j<b.length){ // (m) - min(n,m)
            if(!res.isEmpty() && res.get(res.size()-1) == b[j]){j++;continue;}
            res.add(b[j++]);
        }
       return res; 
    }
}

// time comnplixity : min(n,m) + n + m - 2min(n,m)
//                  : n + m - min(n,m)
//                  : O(n+m)   

// space complixity :O(1);



// 1,2,3,4,5.  i = 4
// 1,2,3,6,7.  j = 3

// 1 ,2 ,3 ,4,5,