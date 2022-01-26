package ProblemSolving;

public class CountInversions {
    public static void main(String[] args) {
        long[] arr = {3, 2, 1};
        System.out.println(getAns(arr));
    }

    //Bruteforce Approach checking for each and every element present in the array
    //TC=O(N^2) SC=O(1)
    static long countInversions(long[] arr, int n) {
        long count = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[i]) {
                    count++;
                }
            }
        }
        return count;
    }

    //Using Merge Sort Algorithm and changing it to compare the leftward
    //and the rightward such that we get the inversions from it via comparing
    //the two elements and taking advantage of the fact that the leftward array elements
    //will always be arranged and the elements in the leftward array will always have index
    //lower than that of elements of the rightward array
    //TC=O(Nlog(N)) SC=O(N)
    static long getAns(long[] arr) {
        int n = arr.length;
        return mergeSort(arr, new long[n], 0, n - 1);
    }

    static long mergeSort(long[] arr, long[] temp, int l, int r) {
        int mid = (l + r) / 2;
        long count = 0;
        if (r > l) {
            count += mergeSort(arr, temp, l, mid);
            count += mergeSort(arr, temp, mid + 1, r);
            count += mergeInv(arr, temp, l, r, mid);
        }
        return count;
    }

    private static long mergeInv(long[] arr, long[] temp, int l, int r, int mid) {
        int i = l;
        int j = mid + 1;
        int k = l;
        long inv_count = 0;
        while (i <= mid && j <= r) {
            if (arr[i] > arr[j]) {
                temp[k++] = arr[j++];
                inv_count += (mid - i + 1);
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
        if (r + 1 - l >= 0) System.arraycopy(temp, l, arr, l, r + 1 - l);
        return inv_count;
    }


}
