package SegmentTree.RangeSumQueryMutable;

// https://leetcode.com/problems/range-sum-query-mutable/description/

// use segment tree to solve
public class NumArray {

    int[] nums;
    int[] tree;

    public NumArray(int[] nums) {

        this.nums = nums;

        tree = new int[nums.length * 4];

        build(0, nums.length - 1, 0);
    }

    private void build(int left, int right, int target) {

        if (left == right) {
            tree[target] = nums[left];
            return;
        }

        int mid = left + (right - left) / 2;

        build(left, mid, 2 * target + 1);

        build(mid + 1, right, 2 * target + 2);

        tree[target] = tree[2 * target + 1] + tree[2 * target + 2];
    }

    public void update(int index, int val) {
        int diff = val - nums[index];
        nums[index] = val;

        add(index, diff, 0, nums.length - 1, 0);

    }

    private void add(int index, int diff, int left, int right, int target) {

        if (left == right) {
            tree[target] += diff;
            return;
        }

        int mid = left + (right - left) / 2;

        if (index <= mid) {
            add(index, diff, left, mid, 2 * target + 1);
        } else {
            add(index, diff, mid + 1, right, 2 * target + 2);
        }

        tree[target] += diff;
    }

    public int sumRange(int left, int right) {
        return sumRange(left, right, 0, nums.length - 1, 0);
    }

    private int sumRange(int l, int r, int left, int right, int target) {

        if (l <= left && right <= r) {
            return tree[target];
        }

        if (r < left) {
            return 0;
        }

        if (l > right) {
            return 0;
        }

        int mid = left + (right - left) / 2;

        int leftSum = sumRange(l, r, left, mid, 2 * target + 1);
        int rightSum = sumRange(l, r, mid + 1, right, 2 * target + 2);

        return leftSum + rightSum;
    }

    public static void main(String[] args) {
        // int[] nums = { 9, -8 };

        int[] nums = { -28, -39, 53, 65, 11, -56, -65, -39, -43, 97 };
        NumArray na = new NumArray(nums);

        // na.update(0, 3);

        // System.out.println(na.sumRange(1, 1));

        // System.out.println(na.sumRange(0, 1));

    }
}
