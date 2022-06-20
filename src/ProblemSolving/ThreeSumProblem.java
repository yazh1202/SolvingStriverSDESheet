package ProblemSolving;

import java.util.*;

public class ThreeSumProblem {
    public static void main(String[] args) {
        int[] ta = {-1, 0, 1, 2, -1, -4};
        int[] b = {0, 0, 0};
        List<List<Integer>> res = threeSumOptimal(ta);
        for (List<Integer> arr : res) {
            for (Integer i : arr) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    /* BruteForce :- (⏲)Works and takes O(n^3)+O(logm) time complexity for looping and insertion to the table
     Time Complexity of O(M) where M is number of triplets, initially sorted the array to avoid duplicates, as hashset considers
     * elements not in same order as duplicates but sorting the triplet works better,Exceeds time limit on LeetCode */
    public static List<List<Integer>> threeSum(int[] nums) {
        HashSet<List<Integer>> hs = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        ArrayList<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                        Collections.sort(temp);
                        hs.add(temp);
                    }
                }
            }
        }
        return new ArrayList<>(hs);
    }

    public static List<List<Integer>> threeSum2(int[] nums) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        HashSet<List<Integer>> hs = new HashSet<>();
        //Adding all elements to the hashmap
        for (int i : nums) {
            if (hm.containsKey(i)) {
                hm.put(i, hm.get(i) + 1);
            } else {
                hm.put(i, 1);
            }
        }
        for (int i = 0; i < nums.length - 1; i++) {
            hm.remove(nums[i + 1]);
            for (int j = i + 1; j < nums.length; j++) {
                if (hm.containsKey(-(nums[i] + nums[j]))) {
                    ArrayList<Integer> arr = new ArrayList<>();
                    arr.add(-nums[i] - nums[j]);
                    arr.add(nums[i]);
                    arr.add(nums[j]);
                    Collections.sort(arr);
                    hs.add(arr);
                }
            }
            hm.put(nums[i], 1);
            hm.put(nums[i + 1], 1);
        }
        return new ArrayList<>(hs);
    }

    /*Optimal Solution using ArrayList to store and using the two pointer technique to find the triplets */
    public static List<List<Integer>> threeSumOptimal(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length - 1; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                int lo = i + 1;
                int hi = nums.length - 1;
                int tgt = -nums[i];
                while (hi > lo) {
                    int sum = nums[hi] + nums[lo];
                    if (sum == tgt) {
                        res.add(Arrays.asList(nums[hi], nums[lo], nums[i]));
                        while (lo < hi && nums[lo + 1] == nums[lo]) {
                            lo++;
                        }
                        while (lo < hi && nums[hi - 1] == nums[hi]) {
                            hi--;
                        }
                        lo++;
                        hi--;
                    } else if (sum < tgt) {
                        lo++;
                    } else {
                        hi--;
                    }
                }
            }
        }
        return res;
    }


}
