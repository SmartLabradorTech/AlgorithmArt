package ReversePairs;

import java.util.Arrays;

public class ReversePairsV4 {

    // https://leetcode.com/problems/reverse-pairs/
    // scan the input from left to right

    public int reversePairs(int[] nums) {

        long[] merged = new long[2 * nums.length];

        for (int i = 0; i < nums.length; i++) {
            merged[i] = (long) 2 * nums[i];
        }

        for (int i = nums.length; i < merged.length; i++) {
            merged[i] = nums[i - nums.length];
        }

        Arrays.sort(merged);

        // System.out.println(Arrays.toString(merged));

        Bits bits = new Bits(nums.length * 2);

        int result = 0;

        for (int i = 0; i < nums.length; i++) {

            int doubledIndex = Arrays.binarySearch(merged, (long) 2 * nums[i]);

            int small = bits.presum(doubledIndex); // all numbers which <= current value
            result += (i - small);

            int singleIndex = Arrays.binarySearch(merged, nums[i]);

            bits.add(singleIndex, 1);
        }

        return result;
    }

    class Bits {

        int[] nums;

        Bits(int size) {
            nums = new int[size];
        }

        public void add(int index, int value) {

            for (int i = index + 1; i <= nums.length; i += lowbit(i)) {
                nums[i - 1] += value;
            }

        }

        public int presum(int index) {

            int sum = 0;

            for (int i = index + 1; i > 0; i -= lowbit(i)) {

                sum += nums[i - 1];
            }

            return sum;
        }

        private int lowbit(int number) {
            return number & (-number);
        }
    }

    public static void main(String[] args) {

        ReversePairsV4 rp = new ReversePairsV4();

        int[] nums = { 1, 3, 2, 3, 1 };

        // int[] nums = { 2147483647, 2147483647, 2147483647, 2147483647, 2147483647,
        // 2147483647 };

        System.out.println(rp.reversePairs(nums));
    }

}
