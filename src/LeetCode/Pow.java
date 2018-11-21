package LeetCode;

/*
 * LeetCode-50-LeetCode.Pow(x, n)
 *
 *
 * */
public class Pow {

    private double myPow(double x, int m) {
        double temp;
        if (m == 0)
            return 1;
        temp = myPow(x, m / 2);
        if (m % 2 == 0)
            return temp * temp;
        else {
            if (m > 0)
                return x * temp * temp;
            else
                return (temp * temp) / x;
        }
    }
}
