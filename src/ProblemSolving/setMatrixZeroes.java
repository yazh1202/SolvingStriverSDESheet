package ProblemSolving;


import javafx.util.Pair;

import java.util.ArrayList;

class setMatrixZeroes {
    //BruteForce Approaches

    //One TC = O(n*m + n+m + n*m)
    public static void setZeroesBruteForce(int[][] matrix) {
        int[][] matrix2 = new int[matrix.length][matrix[0].length];
        copyDeep(matrix, matrix2);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    movingAround(i, j, matrix2);
                }
            }
        }
        System.arraycopy(matrix2, 0, matrix, 0, matrix.length);
    }

    //To set the rows and columns corresponding to zero
    public static void movingAround(int i, int j, int[][] arr) {

        //For Going Up
        int r = i, c = j;
        while (r > 0) {
            r--;
            arr[r][c] = 0;
        }
        r = i;
        //For Going Down
        while (r < arr.length - 1) {
            r++;
            arr[r][c] = 0;
        }
        r = i;
        //For going left
        while (c > 0) {
            c--;
            arr[r][c] = 0;
        }
        c = j;
        //For going right
        while (c < arr[0].length - 1) {
            c++;
            arr[r][c] = 0;
        }
    }

    //To copy the matrix for traversal
    static void copyDeep(int[][] arr1, int[][] arr2) {
        for (int x = 0; x < arr1.length; x++) {
            for (int y = 0; y < arr1[0].length; y++) {
                arr2[x][y] = arr1[x][y];
            }
        }
    }

    //BruteForce Second
    public static void setZeroesBruteTwo(int[][] matrix) {
        for (int x = 0; x < matrix.length; x++) {
            for (int y = 0; y < matrix[0].length; y++) {
                if (matrix[x][y] == 0) {
                    movingAround2(x, y, matrix);
                }
            }
        }
        for (int x = 0; x < matrix.length; x++) {
            for (int y = 0; y < matrix[0].length; y++) {
                if (matrix[x][y] == -1) {
                    matrix[x][y] = 0;
                }
            }
        }
    }
    //Setting to Zeroes

    //Two TC = O(n*m + n+m + n*m)
    public static void movingAround2(int i, int j, int[][] arr) {

        //For Going Up
        int r = i, c = j;
        while (r > 0) {
            r--;
            if (arr[r][c] != 0) {
                arr[r][c] = -1;
            }
        }
        r = i;
        //For Going Down
        while (r < arr.length - 1) {
            r++;
            if (arr[r][c] != 0) {
                arr[r][c] = -1;
            }
        }
        r = i;
        //For going left
        while (c > 0) {
            c--;
            if (arr[r][c] != 0) {
                arr[r][c] = -1;
            }
        }
        c = j;
        //For going right
        while (c < arr[0].length - 1) {
            c++;
            if (arr[r][c] != 0) {
                arr[r][c] = -1;
            }
        }
    }


    //Optimising

    //One: Using Pair Class to save the zeroes TC = O(n*m+n*m)
    public static void setZeroesOpPair(int[][] matrix) {
        //Matrix to save the zeroes for the matrix
        ArrayList<Pair<Integer, Integer>> zeroes = new ArrayList<>();
        //Traversing for the zeroes i.e Array Preprocessing
        int z = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    Pair<Integer, Integer> p = new Pair<>(i, j);
                    zeroes.add(p);
                }
            }
        }
        //Making it zero
        for (Pair<Integer, Integer> zeroe : zeroes) {
            movingAround(zeroe.getKey(), zeroe.getValue(), matrix);
        }
    }

    //Two: Using two arrays of sizes equal to column and row TC = O(n*m+n*m)
    public static void setZeroesOpArray(int[][] matrix) {
        int[] rows = new int[matrix.length];
        int[] cols = new int[matrix[0].length];
        for (int x = 0; x < matrix.length; x++) {
            for (int y = 0; y < matrix[0].length; y++) {
                if (matrix[x][y] == 0) {
                    rows[x] = -1;
                    cols[y] = -1;
                }
            }
        }
        for (int x = 0; x < matrix.length; x++) {
            for (int y = 0; y < matrix[0].length; y++) {
                if (rows[x] == -1 || cols[y] == -1) {
                    matrix[x][y] = 0;
                }
            }
        }
    }


    //Best and In-Place
    public void setZeroesBest(int[][] matrix) {
        int col0 = 1, rows = matrix.length, cols = matrix[0].length;

        for (int i = 0; i < rows; i++) {
            if (matrix[i][0] == 0) col0 = 0;
            for (int j = 1; j < cols; j++)
                if (matrix[i][j] == 0)
                    matrix[i][0] = matrix[0][j] = 0;
        }

        for (int i = rows - 1; i >= 0; i--) {
            for (int j = cols - 1; j >= 1; j--)
                if (matrix[i][0] == 0 || matrix[0][j] == 0)
                    matrix[i][j] = 0;
            if (col0 == 0) matrix[i][0] = 0;
        }
    }
}
