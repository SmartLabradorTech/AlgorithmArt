package arithmetic.power;

/*
 * 
 * https://leetcode.com/problems/powx-n/
 */

class MyPowerV4 {
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

        if (n % 2 == 0) {
            return myPow(x * x, n / 2);
        } else {
            return x * myPow(x * x, (n - 1) / 2);
        }
    }

    public static void main(String[] args) {

        MyPowerV4 myPower = new MyPowerV4();

        System.out.println("**");

        // System.out.println(Math.abs(Integer.MIN_VALUE));

        System.out.println(myPower.myPow(2, -2));

        System.out.println(myPower.myPow(2, 1));

        System.out.println(myPower.myPow(2, 3));

        System.out.println(myPower.myPow(2.00000, -2147483648));

    }
}