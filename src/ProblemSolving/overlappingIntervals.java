package ProblemSolving;

import java.util.*;

public class overlappingIntervals {
    //The bruteforce Approach involves going through each interval
    //and searching for other intervals which can be merged into it
    //T.C = O(N*N) and S.C = O(Size of returning array)

    public int[][] merge(int[][] intervals) {

        //Sorting the intervals array using their starting points
        //Using the comparator interface
        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));

        List<int[]> result = new LinkedList<>();
        for(int[] interval :intervals){
            if (result.isEmpty() || result.get(result.size() - 1)[1] < interval[0]) {
                result.add(interval);
                continue;
            }
            if(result.get(result.size()-1)[1]<interval[1]){
                result.get(result.size()-1)[1] = interval[1];
            }

        }
        return result.toArray(new int[result.size()][]);
    }

}

