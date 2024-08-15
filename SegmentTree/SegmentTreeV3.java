package SegmentTree;

import java.util.Arrays;

// support range update.

public class SegmentTreeV3 {

    int[] nums;
    int[] tree;
    int[] lazy;

    SegmentTreeV3(int[] nums) {
        this.nums = nums;

        int length = nums.length;

        tree = new int[4 * length];

        lazy = new int[4 * length];

        build(0, length - 1, 0);
    }

    private void build(int left, int right, int target) {

        if (left == right) {
            tree[target] = nums[left];
            return;
        }

        int mid = (left + right) / 2;

        build(left, mid, 2 * target + 1);

        build(mid + 1, right, 2 * target + 2);

        tree[target] = tree[2 * target + 1] + tree[2 * target + 2];
    }

    public void add(int l, int r, int x) {
        add(l, r, x, 0, nums.length - 1, 0);
    }

    private void add(int l, int r, int x, int start, int end, int target) {

        if (l <= start && end <= r) {
            tree[target] += (end - start + 1) * x;

            if (start != end) {
                // non leaf node
                lazy[target] += x;
            }

            return;
        }

        if (r < start || l > end) {
            return;
        }

        int mid = (start + end) / 2;

        add(l, r, x, start, mid, 2 * target + 1);

        add(l, r, x, mid + 1, end, 2 * target + 2);
    }

    private void pushDown(int x, int start, int end, int target) {

    }

    public static void main(String[] args) {

        int[] nums = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 };

        SegmentTreeV3 st = new SegmentTreeV3(nums);

        System.out.println(Arrays.toString(st.tree));
    }

}
