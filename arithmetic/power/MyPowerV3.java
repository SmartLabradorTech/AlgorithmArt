package arithmetic.power;

/*
 * 
 * https://leetcode.com/problems/powx-n/
 */

class MyPowerV3 {
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

        return x * myPow(x, n - 1);
    }

    public static void main(String[] args) {

        MyPowerV3 myPower = new MyPowerV3();

        System.out.println("**");

        // System.out.println(Math.abs(Integer.MIN_VALUE));

        // System.out.println(myPower.myPow(2, -2));

        // System.out.println(myPower.myPow(2, -2));

        // System.out.println(myPower.myPow(2, 3));

        System.out.println(myPower.myPow(2.00000, -2147483648));

    }
}