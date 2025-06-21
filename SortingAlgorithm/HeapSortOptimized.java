/**
 * The Main class contains a Java implementation of the heapsort algorithm to sort an array of
 * integers.
 */
// heap sort without extra space
import java.util.*;
class Main {
    public static void heapsort(int [] arr){
        int n = arr.length;
        for(int i = n/2-1;i>=0;i--){
            heapify(i,n,arr);
        }
        for(int i =n-1;i>=0;i--){
            swap(0,i,arr);
            heapify(0,i,arr);
        }
    }
    public static void heapify(int index,int size,int [] arr){
        int leftChild = (2*index)+1;
        int rightChild = (2*index)+2;
        int smallest = index;
        if(leftChild < size && arr[leftChild]>arr[smallest]){
            smallest = leftChild;
        }
        if(rightChild < size && arr[rightChild] > arr[smallest]){
            smallest = rightChild;
        }
        if(smallest != index){
            swap(smallest,index,arr);
            heapify(smallest,size,arr);
        }
    }
    public static void swap(int i,int j,int []arr){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void main(String[] args) {
        int [] arr = {1,6,8,2,3,4,9,0};
        heapsort(arr);
        System.out.print(Arrays.toString(arr));
    }
}

//  [1,6,8,2,3,4,9,0]

//                  9,8,6,4,3,2,1,0
 
 //.      1
 //.    /   \
 //.   6.     8
 //.  /. \.  /. \ 
 //. 2.   3. 4.  9
 // /
 //0
//  .   Insertion
//.         0
//.    . /    \
//.     1.       4
//    /.  \.    / \
//   2     3.  8   9
//  /
// 6 