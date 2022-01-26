package ProblemSolving;

import java.util.ArrayList;
import java.util.Collections;

//Problem Statement
//  You are given an array/list say ‘ARR’ of size ‘N’. We call pair (i, j)
//  a Reverse Pair when i < j and 'ARR[i]' > 2 * 'ARR[j]'.
//  Your task is to find the number of Reverse Pairs present in given 'ARR'.
public class reversePairs {
    public static void main(String[] args) {
        int[] arr2 = {1, 2, 3, 2, 3, 1};
        int[] arr3 = {50, 21, 9};
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i : arr3) {
            arr.add(i);
        }
        System.out.println(reversePairsBrute(arr));
    }

    /*The bruteforce approach involves searching for each element
      if there exist another number which satisfies reverse pair conditions
      has O(n*n) time complexity.
     */
    static int reversePairsBrute(ArrayList<Integer> arr) {
        int res = 0;
        int n = arr.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (2 * arr.get(j) < arr.get(i)) {
                    res++;
                }
            }
        }
        return res;
    }

//    static int reversePairsBetter(ArrayList<Integer> arr) {
//
//    }
}
