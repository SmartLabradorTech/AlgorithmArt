package ReversePairs;

import java.util.Arrays;

public class ReversePairsV2 {

    // this version solves the reverse pair where nums[i] > nums[j] but the original
    // problem is to nums[i] > 2 * nums[j].
    // We will solve the real problem in V3.

    public int reversePairs(int[] nums) {

        int result = 0;

        Bit bits = new Bit(nums.length);

        discrete(nums);
        // after discreate, every number is represented by its index at the sorted
        // array.

        for (int i = nums.length - 1; i >= 0; i--) {

            if (nums[i] > 0) {
                // find how many small numbers have show up.
                result += bits.presum(nums[i] - 1);
            }

            // mark the location as shown up.
            bits.add(nums[i], 1);
        }

        return result;
    }

    public int reversePairsForce(int[] nums) {
        int count = 0;

        for (int i = 0; i < nums.length; i++) {

            for (int j = i + 1; j < nums.length; j++) {

                if (nums[i] > nums[j]) {
                    count++;
                }

            }
        }

        return count;
    }

    // discrete an array
    public void discrete(int[] nums) {

        int[] temp = Arrays.copyOf(nums, nums.length);

        Arrays.sort(temp);

        for (int i = 0; i < nums.length; i++) {

            nums[i] = Arrays.binarySearch(temp, nums[i]);
        }

        System.out.println("After discrete, input is " + Arrays.toString(nums));
    }

    public static void main(String[] args) {

        ReversePairsV2 rp = new ReversePairsV2();

        int[] nums = { 2, 1, 3, 6, 4 };

        // System.out.println(Arrays.toString(nums));

        // rp.discrete(nums);

        // System.out.println(Arrays.toString(nums));

        System.out.println("smart is " + rp.reversePairs(nums));

        System.out.println("brute force is " + rp.reversePairsForce(nums));

        // test Bit

        // Bit tBit = new Bit(10);

        // tBit.add(1, 2);
        // tBit.add(5, 4);

        // System.out.println(tBit.presum(9));

    }

}

class Bit {

    private int[] data;

    Bit(int n) {
        this.data = new int[n];
    }

    private int lowbit(int i) {
        return i & (-i);
    }

    public void add(int index, int delta) {

        for (int i = index + 1; i <= this.data.length; i += lowbit(i)) {
            data[i - 1] += delta;
        }
    }

    public int presum(int index) {

        int sum = 0;
        for (int i = index + 1; i > 0; i -= lowbit(i)) {
            sum += this.data[i - 1];
        }

        return sum;
    }

}
