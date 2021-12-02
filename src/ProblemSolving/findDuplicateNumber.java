package ProblemSolving;

import java.util.Arrays;

public class findDuplicateNumber {
    //The most intuitive approach which uses TC(O(logn)+O(N))
    static int findDuplicate(int[] arr) {
        //BruteForce
        //Sorting the array and looking for duplicates

        Arrays.sort(arr);
        int stored = 0;
        for (int i = 0; i < arr.length - 1; i++) {

            if (arr[i] == arr[i + 1]) {
                stored = arr[i];
                break;
            }
        }
        return stored;
    }
    //Using Extra space to store frequency of occurrence of a particular Number

    static int findDuplicateBetter(int[] arr) {

        //Initializing the array to store the frequencies
        int[] frq = new int[arr.length];

        //Traversing the array to store the frequency

        for (int j : arr) {
            frq[j]++;
        }
        int store = 0;
        for (int i = 0; i < arr.length; i++) {
            if (frq[i] >= 2) {
                store = arr[frq[i]];
            }
        }
        return store;
    }

    //Using the LinkedList Cycle Detection Method (Tortoise and Hare)
    static int findDuplicateOptimal(int[] arr) {

        //Initializing the two pointers fast and slow
        int fast = arr[0];
        int slow = arr[0];

        //First Cycle Detection

        do {
            slow = arr[slow];
            fast = arr[arr[fast]];
        } while (fast != slow);

        //Second Occurrence Detection
        fast = arr[0];
        while (slow != fast) {
            slow = arr[fast];
            fast = arr[fast];
        }
        return arr[slow];
    }
}
