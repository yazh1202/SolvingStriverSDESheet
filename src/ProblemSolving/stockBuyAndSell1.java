package ProblemSolving;

public class stockBuyAndSell1 {
    //First Problem which asks to
    // maximize the profit and only make one transaction
    //Key- You cannot travel back in time to buy stock
    //Think of buying every stock and finding the best option later
    static int sbas1(int[] arr) {

        //Initializing two variables to store the minimum buying price and profit
        int min_val = Integer.MAX_VALUE;
        int profit = 0;
        //Traversing the array
        for(int i:arr){
            min_val = Math.min(min_val,i);//Minimum price of buying
            profit = Math.max(profit,i-min_val);//Maximum profit
        }
        return profit;
    }


}
