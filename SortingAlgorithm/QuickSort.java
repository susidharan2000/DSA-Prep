/**
 * The Main class contains a quickSort method that implements the quicksort algorithm to sort an array
 * of integers in Java.
 */
// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.*;
class Main {
    public static void quickSort(int low,int high,int []arr){
        //base case
        if(low >= high) return;

        int pi = getPivotIndex(low,high,arr); //this method puts the main method in right position  and return the povit index position
        quickSort(low,pi-1,arr); //recursively do the same thig for left arr until array length 1 which is base case
        quickSort(pi+1,high,arr);//recursively do the same thig for right arr until array length 1 which is base case
    }
    public static int getPivotIndex(int low,int high,int []arr){
        int i = low;
        int j = high;
        int pivot = arr[low];
        while(i < j){// do untill i cross j
            while(i <= high &&  arr[i] <= pivot){  //when current ele arr[i] <= pivot move the pointer
                i++;
            }
            while(j >= low && arr[j] > pivot){  //when current ele arr[j] >= pivot move the pointer
                j--;
            }
            if(i<j)swap(i,j,arr); //if i and j dose not cross the swap i with j
        }
        swap(j,low,arr); //after i and j cross each other swap j with low  
        return j; // j is the position of the pivot
    }
    //swap logic
    public static void swap(int i,int j,int [] arr){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    public static void main(String[] args) {
        int [] arr = {6,5,7,4,8,3,9,2,1};
        quickSort(0,arr.length-1,arr);
        System.out.print(Arrays.toString(arr));
    }
}
// pivoit = arr[low]
// pivot=0. 6
// i = 6     arr[i] =. 9
// j = 5     arr[j] = 3
 
//  6,5,1,4,8,3,9,2,7
//  6,5,1,4,2,3,9,8,7
 
//  3,5,1,4,2,6,9,8,7
 
 
//  3,5,1,4,2
 
//  9,2,1
 
 
 
// while (i<j)
// while arr[i] <= pivit i++;
// while arr[j] > pivot j--;
// if(i < j)swap(i,j)
// swap(j,low)
// return j