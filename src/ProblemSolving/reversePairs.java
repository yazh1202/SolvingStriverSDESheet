package ProblemSolving;

//Problem Statement
//  You are given an array/list say ‘ARR’ of size ‘N’. We call pair (i, j)
//  a Reverse Pair when i < j and 'ARR[i]' > 2 * 'ARR[j]'.
//  Your task is to find the number of Reverse Pairs present in given 'ARR'.
public class reversePairs {

    /*The bruteforce approach involves searching for each element
      if there exist another number which satisfies reverse pair conditions
      has O(n*n) time complexity.
     */
    static int reversePairsBrute(int[] arr) {
        int res = 0;
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (2 * arr[j] < arr[i]) {
                    System.out.println(arr[j] + " " + arr[i]);
                    res++;
                }
            }
        }
        return res;
    }

    //Using the merge sort algorithm and a bit of improvisation as to check whether
    //it satisfies a particular condition or not, the time complexity is O(n*logn)+O(n)+O(n) for
    //counting and merging steps
    static int reversePairsBetter(int[] arr) {
        int n = arr.length;
        int[] temp = new int[n];
        return countReverse(arr, temp, 0, n - 1);
    }

    static int countReverse(int[] nums, int[] temp, int l, int r) {
        int count = 0;
        if (l < r) {
            int mid = l + (r - l) / 2;
            count += countReverse(nums, temp, l, mid);
            count += countReverse(nums, temp, mid + 1, r);
            count += mergeRev(nums, temp, l, r, mid);
        }
        return count;
    }

    static int mergeRev(int[] arr, int[] temp, int l, int r, int mid) {
        int i = l;
        int j = mid + 1;
        int k = l;
        int j1 = j;
        int count = 0;
        for (int i1 = l; i1 <= mid; i1++) {
            while (j1 <= r && arr[i1] > (arr[j1] * 2L)) {
                j1++;
            }
            count += j1 - (mid + 1);
        }
        while (i <= mid && j <= r) {
            if (arr[i] > arr[j]) {
                temp[k++] = arr[j++];
            } else {
                temp[k++] = arr[i++];
            }
        }
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        while (j <= r) {
            temp[k++] = arr[j++];
        }
        for (int s = l; s <= r; s++) {
            arr[s] = temp[s];
        }
        return count;
    }
}
