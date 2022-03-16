package ProblemSolving;

import java.util.*;

public class FourSumProblem {
    public static void main(String[] args) {

    }



    //Optimal Approach for the problem
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList<>();
        for (int i = 0; i < n - 3; i++) {
            for (int j = i + 1; j < n - 2; j++) {
                int front = j + 1;
                int back = n - 1;
                int tgt2 = target - nums[i] - nums[j];
                while (front < back) {
                    if (nums[front] + nums[back] < target) {
                        front++;
                    } else if (nums[front] + nums[back] > target) {
                        back--;
                    } else {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[front]);
                        temp.add(nums[back]);
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        res.add(temp);
                        while (front < back && nums[front] == temp.get(0)) ++front;
                        while (front < back && nums[back] == temp.get(1)) --back;
                    }
                }
                while (j + 1 < n && nums[j + 1] == nums[j]) j++;
            }
            while (i + 1 < n && nums[i + 1] == nums[i]) i++;

        }
        return res;
    }
}
