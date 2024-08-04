package SegmentTree;

import java.util.Arrays;

public class SegmentTree {

    int[] tree;
    int[] nums;

    public SegmentTree(int[] nums) {

        this.nums = nums;

        tree = new int[2 * nums.length];

        build(0, nums.length - 1, 0);
    }

    private int build(int left, int right, int target) {
        if (left == right) {
            tree[target] = nums[left];
            return tree[target];
        }

        int mid = (left + right) / 2;

        int leftSum = build(left, mid, 2 * target + 1);

        int rightSum = build(mid + 1, right, 2 * target + 2);

        tree[target] = leftSum + rightSum;

        return tree[target];
    }

    public static void main(String[] args) {

        int[] nums = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 };

        SegmentTree st = new SegmentTree(nums);

        System.out.println(Arrays.toString(st.tree));
    }

}
