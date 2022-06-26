package ProblemSolving;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class majorityElement2 {
    /*The bruteforce approach involves checking for each element if it is
    occurring more than n/3 times and this takes O(n) time complexity*/


    /*Sorting the array does give the right answer and using merge sort takes
    O(nlogn) time complexity which is still optimisable */


    /*Third approach uses a map to store the numbers as the keys and
    their occurring frequencies as values, this takes one pass to check for
    the elements and store their frequencies and another pass to confirm if
    it is the majority element. The time complexity is o(n) and space complexity
    is O(n) to actually store the values and their frequencies*/
    static List<Integer> majority2Map(int[] arr) {
        int n = arr.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int el : arr) {
            if (map.containsKey(el)) {
                int freq = map.get(el);
                map.put(el, ++freq);
            } else {
                map.put(el, 1);
            }
        }
        List<Integer> res = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > (n / 3)) {
                res.add(entry.getKey());
            }
        }
        return res;
    }
    /*The approach which is the best uses Boyer Moore Voting algorithm
     * and makes use of two containers for the two possible majority elements
     * also requiring two passes having tc-O(n) and sc-O(1)*/
    public static List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        List<Integer> res = new ArrayList<>();
        int n1 = -1222, n2 = -1222;
        int c1 = 0, c2 = 0;
        for (int el : nums) {
            if (el == n1) {
                c1++;
            } else if (el == n2) {
                c2++;
            } else if (c1 == 0) {
                n1 = el;
                c1 = 1;
            } else if (c2 == 0) {
                n2 = el;
                c2 = 1;
            } else {
                c1--;
                c2--;
            }
        }
        c1 = 0;
        c2 = 0;
        for (int num : nums) {
            if (num == n1) {
                c1++;
            }
            if (num == n2) {
                c2++;
            }
        }
        if (c1 > (n / 3)) {
            res.add(n1);
        }
        if (c2 > (n / 3)) {
            res.add(n2);
        }
        return res;
    }

}
