package ProblemSolving;

import java.util.HashMap;

public class LargestSubarrayWithZeroSum {
    public static void main(String[] args) {
        int[] arr = {15, -2, 2, -8, 1, 7, 10, 23};
        System.out.println(maxLen(arr, arr.length));
    }

    static int maxLen(int[] arr, int n) {
            HashMap<Integer, Integer> hm = new HashMap<>();
            //Generating the prefix sum
            int prSum = 0;
            int mlength = 0;
            int ind = 0;
            for (ind = 0; ind < n; ind++) {
                prSum += arr[ind];
                if (prSum == 0) {
                    mlength = ind + 1;
                } else {
                    if (hm.get(prSum) != null) {
                        mlength = Math.max(mlength, ind - hm.get(prSum));
                    } else {
                        hm.put(prSum, ind);
                    }
                }
            }
            return mlength;
    }
}
