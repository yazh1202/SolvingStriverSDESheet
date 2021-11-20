package ProblemSolving;

import java.util.ArrayList;

public class kadaneAlgorithm {
    //For finding the subarray having the largest sum
    static void kadane(int[] arr) {

        int sum_till_now = 0;
        int max_sum = 0;
        ArrayList<Integer> max_sub = new ArrayList<>();
        //Traversing the array
        for (int i : arr) {
            //Adding to the array if the sum is higher than before
            sum_till_now = Math.max(sum_till_now, sum_till_now + i);
            //Resetting the array if the sum goes below zero
            if (sum_till_now < 0) {
                sum_till_now = 0;
            }
            //Adding to the array if the sum increases
            if (sum_till_now > max_sum) {
                max_sum = sum_till_now;
                max_sub.add(i);
            }
        }
        //In case all values are negative
        // zeroes max_sum or sum_till_now
        // will be not updated and will have zero as value
        //The largest subarray will have only one element being the largest
        if (max_sum == 0) {
            //Finding the largest element then adding it to the subarray
            max_sum = Integer.MIN_VALUE;
            for (int i : arr) {
                max_sum =  Math.max(max_sum,i);
            }
            max_sub.add(max_sum);
        }


        //Printing the arraylist and the sum
        System.out.println(max_sub + " " + max_sum);
    }
}
