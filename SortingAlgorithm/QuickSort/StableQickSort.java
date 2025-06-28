import java.util.*;

class StableQuickSort {
    public static List<Integer> stableQuickSort(List<Integer> arr) {
        if (arr.size() <= 1) return arr;

        int pivot = arr.get(arr.size() - 1);
        List<Integer> less = new ArrayList<>();
        List<Integer> equal = new ArrayList<>();
        List<Integer> greater = new ArrayList<>();

        for (int num : arr) {
            if (num < pivot) {
                less.add(num);
            } else if (num == pivot) {
                equal.add(num);
            } else {
                greater.add(num);
            }
        }

        List<Integer> sorted = new ArrayList<>();
        sorted.addAll(stableQuickSort(less));
        sorted.addAll(equal);
        sorted.addAll(stableQuickSort(greater));
        return sorted;
    }

    public static void main(String[] args) {
        List<Integer> input = Arrays.asList(4, 2, 4, 1, 3, 2);
        List<Integer> sorted = stableQuickSort(input);
        System.out.println(sorted);  // Output will preserve order of duplicate 2s and 4s
    }
}