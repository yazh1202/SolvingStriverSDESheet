package ProblemSolving;

import java.io.Console;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class pascalsTriangle {
    //Intuitive Solution which used two LinkedLists,one for initialising the result set
    //Another one for saving the next row to the result set
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> total = new LinkedList<List<Integer>>();
        List<Integer> curr = new LinkedList<Integer>();//To initialize the solution with row 1 having one entry
        List<Integer> next =null;
        curr.add(1);
        total.add(curr);
        int k = 2;
        for (int x = 0; x < numRows+1; x++) {
            next = new LinkedList<>();
            for (int i = 0; i < k; i++) {
                if (i == 0 || i == k - 1) {
                    next.add(1);
                }else {
                    next.add(total.get(x).get(i) + total.get(x).get(i - 1));
                }
            }
            ++k;
            total.add(next);
        }
        return total;
    }
    //Striver's Solution using ArrayLists and initialising two of them,
    //One for storing the previous row(used in generation of next row) and the next row
    public List<List<Integer>> generatetwo(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> row, pre = null;
        for (int i = 0; i < numRows; ++i) {
            row = new ArrayList<>();
            for (int j = 0; j <= i; ++j)
                if (j == 0 || j == i)
                    row.add(1);
                else
                    row.add(pre.get(j - 1) + pre.get(j));
            pre = row;
            res.add(row);
        }
        return res;
    }
}
