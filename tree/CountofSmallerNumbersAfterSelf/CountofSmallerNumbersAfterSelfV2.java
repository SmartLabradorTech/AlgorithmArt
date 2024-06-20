package tree.CountofSmallerNumbersAfterSelf;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CountofSmallerNumbersAfterSelfV2 {

    public List<Integer> countSmaller(int[] nums) {

        List<Integer> result = new ArrayList<>(Collections.nCopies(nums.length, 0));

        discrete(nums);

        Bit bit = new Bit(nums.length);

        for (int i = nums.length - 1; i >= 0; i--) {
            // start with right most element. Its index in the sorted array is nums[i]
            int count = 0;

            if (nums[i] > 0) {
                count = bit.presum(nums[i] - 1);
            }

            result.set(i, count);
            bit.add(nums[i], 1);
        }

        return result;
    }

    public void discrete(int[] nums) {

        int[] copy = Arrays.copyOf(nums, nums.length);

        Arrays.sort(copy);

        for (int i = 0; i < nums.length; i++) {
            nums[i] = Arrays.binarySearch(copy, nums[i]);
        }

    }

    class Bit {

        private int[] data;

        Bit(int size) {
            this.data = new int[size];
        }

        public void add(int index, int delta) {

            for (int i = index + 1; i <= data.length; i += lowbit(i)) {
                data[i - 1] += delta;
            }
        }

        public int presum(int index) {
            int result = 0;

            for (int i = index + 1; i > 0; i -= lowbit(i)) {
                result += data[i - 1];
            }

            return result;
        }

        private int lowbit(int number) {
            return number & (-number);
        }
    }

    public static void main(String[] args) {

        CountofSmallerNumbersAfterSelfV2 cs = new CountofSmallerNumbersAfterSelfV2();

        int[] nums = { 5, 2, 6, 1 };

        // cs.discrete(nums);

        // System.out.println(Arrays.toString(nums));

        System.out.println(cs.countSmaller(nums));

    }
}
