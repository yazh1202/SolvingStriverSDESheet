package ProblemSolving;

import java.util.Arrays;

public class TrappingRainWater {
    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int[] arr2 = {4, 2, 0, 3, 2, 5};
        findTrappedWaterOptimal(arr);
    }

    //Bruteforce algorithm to find the maximums for both the sides by searching for both
    //the sides and then finding the rainwater trapped by subtracting the array element from the minimum of
    //lh and rh
    //TC:O(N*N)   SC:O(1)
    private static void findTrappedWater(int[] arr) {
        int lh = 0;
        int rh = 0;
        long sum = 0;
        for (int i = 0; i < arr.length; i++) {
            lh = 0;
            rh = 0;
            for (int j = i; j < arr.length; j++) {
                rh = Math.max(rh, arr[j]);
            }
            for (int k = i; k >= 0; k--) {
                lh = Math.max(lh, arr[k]);
            }
            sum += Math.min(lh, rh) - arr[i];
        }
        System.out.println(sum);
    }

    //Pre computing the left max and right max for each index and then storing it
    //in two new arrays of same size to store the maximums
    //Then finally using them to calculate the rainwater trapped

    /**
     * Time Complexity is O(3N)
     * Space Complexity is O(N)+O(N)
     **/
    private static void findTrappedWaterBetter(int[] arr) {
        int n = arr.length;
        int[] lr = new int[n];
        int[] rs = new int[n];
        int max = Integer.MIN_VALUE;
        long sum = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, arr[i]);
            lr[i] = max;
        }
        max = Integer.MIN_VALUE;
        for (int i = arr.length - 1; i >= 0; i--) {
            max = Math.max(arr[i], max);
            rs[i] = max;
        }
        for (int s = 0; s < arr.length; s++) {
            //Calculating the sum here
            sum += Math.min(lr[s], rs[s]) - arr[s];
        }
        System.out.println(sum);
    }

    //Optimal Solution using two pointer method, partially understood(needs revisiting)
    public static void findTrappedWaterOptimal(int[] arr) {
        int n = arr.length;
        int lm = 0;
        int rm = 0;
        int i = 0;
        int j = n - 1;
        int sum = 0;
        while (i < j) {
            if (arr[i] < arr[j]) {
                if (lm < arr[i]) {
                    lm = arr[i];
                } else {
                    sum += lm - arr[i];
                }
                i++;
            } else {
                if (rm < arr[j]) {
                    rm = arr[j];
                } else {
                    sum += rm - arr[j];
                }
                j--;
            }
        }
        System.out.println(sum);
    }
}
