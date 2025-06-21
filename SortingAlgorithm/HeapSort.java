/**
 * The given Java class implements the heapsort algorithm to sort an array of integers using a min-heap
 * data structure.
 */
import java.util.*;
class Main {
    public static void heapsort(int [] arr){
        List<Integer> heap = new ArrayList<>();
        for(int i =0;i< arr.length;i++){
            insert(arr[i],heap);
        }
        int i = 0;
        while(!heap.isEmpty()){
            arr[i++] = pop(heap);
        }
    }
    //insertion
    public static void insert(int val,List<Integer> heap){
        heap.add(val);
        upheap(heap.size()-1,heap);
    }
    public static void upheap(int index,List<Integer>heap){
        if(index == 0)return;
        int parent = (index-1)/2;
        if(heap.get(index).compareTo(heap.get(parent))<0){
            swap(index,parent,heap);
            upheap(parent,heap);
        }
    }
    //pop
    public static int pop(List<Integer>heap){
      int popVal = heap.get(0);
      swap(0,heap.size()-1,heap);
      heap.remove(heap.size()-1);
      hepify(0,heap);
      return popVal;
    }
    public static void hepify(int index,List<Integer> heap){
        int leftChild = (2*index)+1;
        int rightChild = (2*index)+2;
        int smallest = index;
        if(leftChild < heap.size() && heap.get(leftChild).compareTo(heap.get(smallest))<0){
            smallest = leftChild;
        }
        if(rightChild < heap.size() && heap.get(rightChild).compareTo(heap.get(smallest))<0){
            smallest = rightChild;
        }
        if(smallest != index){
            swap(smallest,index,heap);
            hepify(smallest,heap);
        }
    }
    //swap
    public static void swap(int i,int j,List<Integer> heap){
        int temp = heap.get(i);
        heap.set(i,heap.get(j));
        heap.set(j,temp);
    }
    public static void main(String[] args) {
        int [] arr = {1,6,8,2,3,4,9,0};
        heapsort(arr);
        System.out.print(Arrays.toString(arr));
    }
}

//.   Insertion
//.         0
//.    . /    \
//.     1.       4
//    /.  \.    / \
//   2     3.  8   9
//  /
// 6 

//        pop.
// res = {0,1,2,3,4,6,8,9};
//smallest = 0
//.         0
//.    . /    \
//.     1.       4
//    /.  \.    / \
//   2     3.  8   9
//  /
// 6         .  
 