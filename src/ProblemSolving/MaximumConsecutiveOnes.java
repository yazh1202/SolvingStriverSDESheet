package ProblemSolving;

public class MaximumConsecutiveOnes {
    //Using two variables, one to keep track of number of ones currently in series
    // and another to keep track of overall largest series
    // TC - O(N) SC = O(1)
    static int maxOnes(int[] nums) {
        int max = 0;
        int cmax = 0;
        for (int i = 0; i < nums.length; i++) {
            while (i < nums.length && nums[i] == 1) {
                cmax++;
                i++;
            }
            max = Math.max(cmax, max);
            cmax = 0;
        }
        return max;
    }

    //Using ternary operator
    static int maxOnesTernary(int[] nums) {
        int max = 0;
        int cmax = 0;
        for (int i : nums) {
            //Shorthand if or ternary operator
            max = Math.max(max, cmax = i == 0 ? 0 : cmax + 1);
        }
        return max;
    }
}
