package ProblemSolving;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class longestConsecutiveSequence {
    public static void main(String[] args) {
        int[] arr = {
                0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        int[] arr2 = {0, 0, -1};
        System.out.println(longestSubSequence(arr2));
    }

    //Using Sorting to find the longest subsequence
    static int longestSequence(int[] arr) {
        Arrays.sort(arr);
        int count = 0;
        int prev = -1;
        int mcount = 0;
        for (int i : arr) {
            if (prev + 1 == i) {
                count++;
                mcount = Math.max(count, mcount);
            } else {
                count = 1;
            }
            prev = i;
        }
        return mcount;
    }

    //Using HashMaps to keep track of continuity and HashSets to keep it unique
    static int longestSubSequence(int[] arr) {
        int count = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        HashSet<Integer> hs = new HashSet<>();
        for (int i : arr) {
            hm.put(i, 1);
            hs.add(i);
        }
        for (int j : hs) {
            int k = j - 1;
            while (hm.containsKey(k--)) {
                int value = hm.get(j);
                hm.replace(j, value + 1);
            }
        }
        for (int i : hm.values()) {
            count = Math.max(count, i);
        }

        return count;
    }

    static int longestSequenceOptimal(int[] arr) {
        int count = 0;

        HashSet<Integer> hs = new HashSet<>();
        for (int i : arr) {
            hs.add(i);
        }
        for (int i : arr) {
            if (hs.contains(i - 1)) {
                continue;
            } else {
                int k = i + 1;
                while (hs.contains(k++)) {
                    count++;
                }
            }
        }

        return count;
    }
}
