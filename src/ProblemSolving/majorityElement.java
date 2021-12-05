package ProblemSolving;

public class majorityElement {


    //The bruteforce method involves traversing the whole array n*n times and checking
    //for each element if it is majority or not
    public static int majorElement(int[] arr) {
        //Boyer-Moore Majority Voting Algorithm
        int stored = 0;
        int occurrence = 0;

        for (int j : arr) {//Traversing the array
            if (occurrence == 0) {//If the occurrence reaches zero
                //it means that  the number of elements different from current candidate is equal
                //to current length/2 so it cannot be the majority element
                stored = j;//Selecting the new candidate
                occurrence = 1;//Setting occurence to one
                continue;
            }
            if (j == stored) {//Increasing if same as stored candidate
                occurrence++;
            } else {
                occurrence--;//Decreasing if not the same as stored candidate
            }

        }
        return stored;
    }
}
