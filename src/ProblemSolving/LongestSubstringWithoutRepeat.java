package ProblemSolving;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeat {
    public static void main(String[] args) {
    }

    /*Using HashMap to keep track of elements already in the current substring
      and restarting one step ahead from the point where the repeated character
      lies.*/
    static int solution(String s) {
        HashMap<Character, Integer> hm = new HashMap<>();
        char[] cr = s.toCharArray();
        int length = 0;
        int maxLength = 0;
        for (int i = 0; i < cr.length; i++) {
            if (hm.containsKey(cr[i])) {
                i = hm.get(cr[i]) + 1;
                hm.clear();
                length = 0;
            }
            hm.put(cr[i], i);
            length++;
            maxLength = Math.max(maxLength, length);
        }
        System.out.println(hm);
        return maxLength;
    }

}
