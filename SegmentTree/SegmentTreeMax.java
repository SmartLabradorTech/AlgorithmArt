package SegmentTree;

import java.util.Arrays;

// the segment tree tracks the max value in the range.
public class SegmentTreeMax {

    int[] tree;

    int[] nums;

    SegmentTreeMax(int[] nums) {
        this.nums = nums;
        tree = new int[2 * nums.length];

        build(0, nums.length - 1, 0);
    }

    private void build(int left, int right, int target) {

        if (left == right) {
            tree[target] = nums[left];
            return;
        }

        int mid = (left + right) / 2;

        build(left, mid, 2 * target + 1);

        build(mid + 1, right, 2 * target + 2);

        tree[target] = Math.max(tree[2 * target + 1], tree[2 * target + 2]);
    }

    public int max(int l, int r) {
        return max(l, r, 0, nums.length - 1, 0);
    }

    private int max(int l, int r, int left, int right, int target) {

        if (l <= left && r >= right) {
            return tree[target];
        }

        if (r < left) {
            return Integer.MIN_VALUE;
        }

        if (l > right) {
            return Integer.MIN_VALUE;
        }

        int mid = (left + right) / 2;

        int leftMax = max(l, r, left, mid, 2 * target + 1);

        int rightMax = max(l, r, mid + 1, right, 2 * target + 2);

        tree[target] = Math.max(leftMax, rightMax);

        return tree[target];
    }

    public static void main(String[] args) {

        int[] nums = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 };

        SegmentTreeMax st = new SegmentTreeMax(nums);

        System.out.println(Arrays.toString(st.tree));

        System.out.println(st.max(1, 3));

    }
}
