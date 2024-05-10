package arithmetic.power;

/*
 * 
 * https://leetcode.com/problems/powx-n/
 */

class MyPowerV5 {
    public double myPow(double x, int n) {
        if (x == 0) {
            return 0;
        }

        if (x == 1 || n == 0) {
            return 1;
        }

        if (n < 0) {
            if (n == Integer.MIN_VALUE) {
                return 1 / (myPow(x, Integer.MAX_VALUE) * x);
            } else {
                return 1 / myPow(x, -n);
            }
        }

        double result = 1;

        double base = x;

        while (n > 0) {

            if (n % 2 == 0) {
                base *= base;

                n = n / 2;
            } else {
                result *= base;

                n = n - 1;
            }
        }

        return result;
    }

    public static void main(String[] args) {

        MyPowerV5 myPower = new MyPowerV5();

        System.out.println("**");

        // System.out.println(Math.abs(Integer.MIN_VALUE));

        System.out.println(myPower.myPow(2, -2));

        System.out.println(myPower.myPow(2, 1));

        System.out.println(myPower.myPow(2, 3));

        System.out.println(myPower.myPow(2.00000, -2147483648));

    }
}