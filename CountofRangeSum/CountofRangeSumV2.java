package CountofRangeSum;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CountofRangeSumV2 {

    public int countRangeSum(int[] nums, int lower, int upper) {
        int length = nums.length;

        long[] presum = new long[length + 1];

        long sum = 0;

        Set<Long> all = new HashSet<>();

        presum[0] = 0;
        all.add(0l);

        for (int i = 0; i < length; i++) {
            sum += nums[i];
            presum[i + 1] = sum;

            all.add(sum);
            all.add(sum - lower);
            all.add(sum - upper);
        }

        Long[] discrete = all.toArray(new Long[0]);

        Arrays.sort(discrete);

        System.out.println(Arrays.toString(discrete));

        Bits bits = new Bits(length * 3 + 1);

        int result = 0;

        bits.add(Arrays.binarySearch(discrete, 0l), 1);

        for (int i = 1; i <= length; i++) {

            // find index

            int rightIndex = Arrays.binarySearch(discrete, presum[i] - lower);

            int sum1 = bits.presum(rightIndex);

            int leftIndex = Arrays.binarySearch(discrete, presum[i] - upper);

            int sum2 = 0;

            if (leftIndex > 0) {
                sum2 = bits.presum(leftIndex - 1);
            }

            result += (sum1 - sum2);

            int currentIndex = Arrays.binarySearch(discrete, presum[i]);

            bits.add(currentIndex, 1);
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

        int[] nums = { -2, 5, -1 };
        int lower = -2;
        int upper = 2;

        CountofRangeSumV2 cr = new CountofRangeSumV2();

        System.out.println(cr.countRangeSum(nums, lower, upper));
    }
}
