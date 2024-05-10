package arithmetic.power;

/*
 * 
 * https://leetcode.com/problems/powx-n/
 */

class MyPower {
    public double myPow(double x, int n) {
        if (n == 0 || x == 1) {
            return 1;
        }

        double result = 1;

        boolean isPositive = n > 0 ? true : false;

        double times = n > 0 ? n : (-1.0 * n);

        System.out.println(times);

        for (double i = 0; i < times; i++) {
            result *= x;
        }

        return isPositive ? result : 1.0 / result;
    }

    public static void main(String[] args) {

        MyPower myPower = new MyPower();

        System.out.println("**");

        // System.out.println(Math.abs(Integer.MIN_VALUE));

        // System.out.println(myPower.myPow(2, -2));

        // System.out.println(myPower.myPow(2, -2));

        // System.out.println(myPower.myPow(2.00000, -2147483648));

        Integer s = 9;

        System.out.println(Integer.toBinaryString(9));

        System.out.println(Integer.lowestOneBit(8));
        System.out.println(Integer.highestOneBit(8));

    }
}