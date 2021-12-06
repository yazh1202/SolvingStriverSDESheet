package ProblemSolving;

public class fastPow {

    static double fspow(double x, int n) {
        //using the property that x^n  = (x*x)^n/2 for even and x^n  = x*((x*x)^n/2)
        if (n == 0) {//Base case if the power reaches 0
            return 1;
        }//If the power is negative then we change the number
        if (n < 0) {
            n = -n;
            x = 1 / x;
        }
        if (n % 2 == 0) {
            // If the power is even
            return fspow(x * x, n / 2);
        }
        //If the power is odd
        return x * fspow(x * x, n / 2);
    }

}
