package ProblemSolving;

import java.util.*;


public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
//        int[] arr = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int[] arr = {1, 2, 3, 4, 3, 3, 2, 4};
        int[] arr2 = {-3, -1, 0, 0, 0, 3, 3};
        findDuplicatesBest(arr2);
    }

    //Bruteforcing using sorting and hashset
    private static void findDuplicates(int[] arr) {
        HashSet<Integer> hs = new HashSet<>();
        int j = 1;
        for (int i : arr) {
            hs.add(i);
        }
        ArrayList<Integer> res = new ArrayList<>(hs);
        Collections.sort(res);
        for (int i = 0; i < hs.size(); i++) {
            arr[i] = res.get(i);
        }
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
//Optimal Way using one pass to find the elements
    private static void findDuplicatesBest(int[] arr) {
        int j = 0;
        int i = 0;
        int n = arr.length;
        while (j < n) {
            int temp = arr[j];
            while (j < n && arr[j] == temp) {
                j++;
            }
            arr[i++] = arr[j - 1];
        }
        for (int a : arr) {
            System.out.print(a + " ");
        }
        System.out.println();
        System.out.println(i);
    }
}
