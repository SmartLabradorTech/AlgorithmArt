package SegmentTree.try2;

import java.util.Arrays;

public class SegmentTree {
    int[] nums, tree;
    int n;

    public SegmentTree(int[] nums) {
        this.nums = nums;
        this.n = nums.length;

        this.tree = new int[4 * n];

        build(1, 0, n - 1);
    }

    private void build(int target, int left, int right) {

        if (left == right) {
            // leave node

            tree[target] = nums[left];

            return;
        }

        int mid = (left + right) / 2;

        build(2 * target, left, mid);

        build(2 * target + 1, mid + 1, right);

        tree[target] = tree[2 * target] + tree[2 * target + 1];
    }

    public static void main(String[] args) {

        int[] nums = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 };

        SegmentTree st = new SegmentTree(nums);

        System.out.println(Arrays.toString(st.tree));

    }

}
