package sortingAlgorithms;

public class insertionSort {

    public static void insertionSortAlgo(int[] arr) {
        //We keep comparing the current number to the next one till we get it's right position
        //The left part of the array is sorted while the right part is unsorted
        for (int i = 1; i < arr.length; i++) {
            int k = i - 1;//This marks the index before which the array is sorted
            int curr = arr[i];//This stores the current value which is to be sorted into
            while (k >= 0 && arr[k] > curr) {
                arr[k+1]=arr[k];
                k--;
            }
            arr[k+1] = curr;//Since the array will now have two copies of the last element shifted
            //and to the left will be values lesser than curr we put curr in the index+1 position
        }
    }
}
