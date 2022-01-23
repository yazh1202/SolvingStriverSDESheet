package ProblemSolving;

import java.util.Arrays;
import java.util.LinkedList;

public class gridUniquePaths {

    public static void main(String[] args) {
        System.out.println(paths(3, 7, 0, 0));
        int[][] arr = new int[3][7];
        fillArr(arr);
        System.out.println(pathsDP(3, 7, 0, 0, arr));

    }

    private static void fillArr(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = -1;
            }
        }
    }

    //Bruteforce recursive approach
    static int paths(int m, int n, int x, int y) {
        if (x >= m || x < 0 || y >= n || y < 0) {
            return 0;
        }
        if (x == m - 1 && y == n - 1) {
            return 1;
        }
        return paths(m, n, x + 1, y) +
                paths(m, n, x, y + 1);

    }

    //Recursion Using Dynamic Programming
    static int pathsDP(int m, int n, int x, int y, int[][] arr) {
        if (x >= m || x < 0 || y >= n || y < 0) {
            return 0;
        }
        if (x == m - 1 && y == n - 1) {
            return 1;
        }
        if (arr[x][y] != -1) {
            return arr[x][y];
        } else {
            return arr[x][y] = pathsDP(m, n, x + 1, y, arr) +
                    pathsDP(m, n, x, y + 1, arr);
        }
    }

    //Most Optimal Solution Using Combinatorics
    /*The idea behind this is that there are always going to be
      certain number of Right Movements and a certain number of Down Movements to
      be chosen from a certain number of choices*/

    static int PathsOP(int m, int n) {
        int r = m - 1;
        int N = m + n - 2;
        int res = 1;
        for (int i = 1; i < r; i++) {
            res = res * (N - r + i) / i;
        }
        return res;
    }

}
