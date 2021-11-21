package ProblemSolving;

public class rotateMatrix {
    //Given a matrix of n*m rotate the matrix in place

    static void rotate(int[][] arr){
        //Transposing the matrix
        for(int i = 0;i<=arr.length;i++){
            for(int j = i+1;j< arr[0].length;j++){
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }
        //Swapping the two arrays
        for(int i = 0;i<arr.length;i++){
            for(int j = 0;j< arr[0].length/2;j++){
                int temp = arr[i][j];
                arr[i][j] = arr[i][arr.length-j-1];
                arr[i][arr.length-j-1] = temp;
            }
        }
    }
}
