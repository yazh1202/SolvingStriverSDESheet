package ProblemSolving;

public class missingAndRepeated {

    static int[] repeatedNumber(final int[] A) {
        //Works in O(n) time complexity
        int[] arr =  new int[A.length+1];
        //Array to store frequency of elements
        for (int j : A) {
            if (arr[j] <= 1) {
                arr[j]++;
                //Increasing if frequency found
            }
        }
        int rep = -1;
        int miss = -1;

        for(int i = 1;i<A.length;i++){
            if(arr[i]==2){
                rep = i;
                //Repeated element
            }
            if(arr[i]==0){
                miss = i;
                //Missing Element
            }
        }
        return new int[]{rep,miss};
    }


}
