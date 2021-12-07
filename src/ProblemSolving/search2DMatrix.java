package ProblemSolving;

public class search2DMatrix {
    static boolean Search(int[][] arr, int tgt) {
        for (int[] a : arr) {
            if(bSearch(a, tgt)){
                return true;
            }
        }
        return false;
    }

    static boolean bSearch(int[] arr, int tgt) {
        boolean pres = false;
        int start = 0, end = arr.length-1;
        int mid = (start+end)/2;
        while (end>=start) {
            mid = (start + end) / 2;

            //Smaller
            if (arr[mid] < tgt) {
                start = mid+1;

            }
            if (arr[mid] > tgt) {
                end = mid-1;
            }
            if (arr[mid] == tgt) {
               pres = true;
               return pres;
            }
        }
        return false;
    }
}
