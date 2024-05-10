package arithmetic.power;

/*
 * 
 * https://leetcode.com/problems/powx-n/
 */

class MyPowerV2 {
    public double myPow(double x, int n) {
        if (n == 0 || x == 1) {
            return 1;
        }

        double result = 1;

        double multipler = x;

        boolean isPositive = n > 0 ? true : false;

        int times = n;

        if (n == Integer.MIN_VALUE) {
            times = Integer.MAX_VALUE;
        } else {
            times = Math.abs(n);
        }

        String binary = Integer.toBinaryString(times);

        for (int i = binary.length() - 1; i >= 0; i--) {

            if (binary.charAt(i) == '1') {
                result *= multipler;
            }

            multipler *= multipler;
        }

        if (isPositive) {
            return result;
        } else {
            if (n == Integer.MIN_VALUE) {
                return 1.0 / (result * x);
            } else {
                return 1.0 / result;
            }
        }
    }

    public static void main(String[] args) {

        MyPowerV2 myPower = new MyPowerV2();

        System.out.println("**");

        // System.out.println(Math.abs(Integer.MIN_VALUE));

        // System.out.println(myPower.myPow(2, -2));

        System.out.println(myPower.myPow(2, -2));

        System.out.println(myPower.myPow(2, 3));

        System.out.println(myPower.myPow(2.00000, -2147483648));

    }
}