package ProblemSolving;

import java.util.ArrayList;
import java.util.HashMap;

public class SubarraysWithXORk {
    public static void main(String[] args) {
        int[] arr = {4, 2, 2, 6, 4};
        int[] arr2 = {5, 6, 7, 8, 9};
//        bruteForceSubarray(arr, 6);
//        bruteForceSubarray(arr2, 5);
        System.out.println(subarrayOptimal(arr2, 5));
//        getXor(arr);
    }

    static void bruteForceSubarray(int[] arr, int b) {
        int xor;
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            xor = arr[i];
            if (xor == b) {
                count++;
            }
            for (int j = i + 1; j < arr.length; j++) {
                xor = xor ^ arr[j];
                if (xor == b) {
                    count++;
                }
                System.out.println(xor);
            }
        }
        System.out.println(count);
    }

    static void getXor(int[] arr) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        int xor = 0;
        for (int i : arr) {
            xor = xor ^ i;
            arrayList.add(xor);
        }
        System.out.println(arrayList);
    }
//Similar to Maximum Subarray with Zero Sum
    static int subarrayOptimal(int[] arr, int b) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int xor = 0;
        int count = 0;
        for (int j : arr) {
            xor = xor ^ j;
            if (hashMap.containsKey(xor ^ b)) {
                count += hashMap.get(xor ^ b);
            }
            if (xor == b) {
                count++;
            }
            if (hashMap.containsKey(xor)) {
                hashMap.replace(xor, hashMap.get(xor) + 1);
            } else {
                hashMap.put(xor, 1);
            }

        }
        return count;
    }

}
