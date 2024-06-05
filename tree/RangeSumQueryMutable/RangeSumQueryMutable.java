package tree.RangeSumQueryMutable;

import java.util.Arrays;

// https://leetcode.com/problems/range-sum-query-mutable/description/

public class RangeSumQueryMutable {

    private int[] tree;

    private int[] nums;

    public RangeSumQueryMutable(int[] nums) {
        this.nums = nums;
        this.tree = new int[nums.length];

        // initialize
        for (int i = 0; i < nums.length; i++) {
            add(i, nums[i]);
        }
    }

    private int lowbit(int i) {
        return i & -i;
    }

    public void update(int index, int val) {
        add(index, val - nums[index]);

        nums[index] = val;

        // print the sum tree

        System.out.println(Arrays.toString(tree));
    }

    public void add(int index, int delta) {
        for (int i = index + 1; i <= nums.length; i += lowbit(i)) {
            tree[i - 1] += delta;
        }
    }

    // calcuate the sum from index zero to input index.
    public int presum(int index) {
        int sum = 0;

        for (int i = index + 1; i >= 1; i -= lowbit(i)) {
            sum += tree[i - 1];
        }

        return sum;
    }

    public int sumRange(int left, int right) {

        return presum(right) - presum(left - 1);
    }

    public static void main(String[] args) {

        int[] input = { 15, 4, 2, -2, 7, 2, 4, 13, -4, -10, 1, 2, -9, 1, 10, 20 };

        System.out.println(input.length);

        RangeSumQueryMutable rs = new RangeSumQueryMutable(input);

        // rs.update(2, 1);

        System.out.println(Arrays.toString(input));

        System.out.println(rs.sumRange(1, 3));

    }
}
