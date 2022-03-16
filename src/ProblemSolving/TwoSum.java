package ProblemSolving;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
    //Bruteforcing the way to find the pair of indices of the two numbers
    static int[] twoSum(int[] arr, int target) {
        int[] res = new int[2];
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == target) {
                    res[0] = i;
                    res[1] = j;
                    return res;
                }
            }
        }
        return res;
    }

    /*Using Two Pointer approach and creating a copy of the array to
     * get the index and the sorted array to get the numbers for the target*/
    static int[] twoSumIntuitive(int[] arr, int target) {
        int[] values = new int[2];
        int[] res = new int[2];
        int[] copy = new int[arr.length];
        for (int j = 0; j < arr.length; j++) {
            copy[j] = arr[j];
        }
        Arrays.sort(arr);
        int i = 0, j = arr.length - 1;
        while (i < j) {
            int sum = arr[i] + arr[j];
            if (sum == target) {
                values[0] = arr[i];
                values[1] = arr[j];
                break;
            }
            if (sum < target) {
                i++;
            }
            if (sum > target) {
                j--;
            }

        }
        res[0] = -1;
        res[1] = -1;
        for (int k = 0; k < arr.length; k++) {
            if (copy[k] == values[0]) {
                if (res[0] == -1) {
                    res[0] = k;
                }
            }
            if (copy[k] == values[1]) {
                res[1] = k;
            }
        }
        return res;
    }

    //Using HashMaps to store the target value for a particular number
    static int[] twoSumBest(int[] arr, int target) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int[] res = new int[2];
        for (int i = 0; i < arr.length; i++) {
            if (hm.containsKey(target - arr[i])) {
                res[0] = hm.get(target - arr[i]);
                res[1] = i;
                break;
            }
            hm.put(arr[i], i);
        }
        return res;
    }
}
