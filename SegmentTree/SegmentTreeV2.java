package SegmentTree;

import java.util.Arrays;

// there is no need for build function to return.
// // the segment tree tracks the sum value in the range.

public class SegmentTreeV2 {
    int[] tree;
    int[] nums;

    public SegmentTreeV2(int[] nums) {

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

        tree[target] = tree[2 * target + 1] + tree[2 * target + 2];
    }

    public void add(int i, int x) {
        // do not maintain original nums array. Thus we need a query function.
        // nums[i] += x;
        add(i, x, 0, nums.length - 1, 0);
    }

    private void add(int i, int x, int left, int right, int targetIndex) {
        if (left == right) {
            tree[targetIndex] += x;
            return;
        }

        int mid = (left + right) / 2;

        if (i <= mid) {
            add(i, x, left, mid, 2 * targetIndex + 1);
        } else {
            add(i, x, mid + 1, right, 2 * targetIndex + 2);
        }

        tree[targetIndex] += x;
    }

    public int query(int i) {

        return query(i, 0, nums.length - 1, 0);
    }

    private int query(int i, int left, int right, int target) {

        if (left == right) {
            return tree[target];
        }

        int mid = (left + right) / 2;

        if (i <= mid) {
            return query(i, left, mid, 2 * target + 1);
        } else {
            return query(i, mid + 1, right, 2 * target + 2);
        }
    }

    public int sum(int l, int r) {

        return sum(l, r, 0, nums.length - 1, 0);
    }

    private int sum(int l, int r, int left, int right, int target) {

        if (l <= left && right <= r) {
            return tree[target];
        }

        if (r < left) {
            return 0;
        }

        if (l > right) {
            return 0;
        }

        int mid = (left + right) / 2;

        int leftSum = sum(l, r, left, mid, 2 * target + 1);

        int rightSum = sum(l, r, mid + 1, right, 2 * target + 2);

        return leftSum + rightSum;
    }

    public int min(int l, int r) {

        return min(l, r, 0, nums.length - 1, 0);
    }

    private int min(int l, int r, int left, int right, int target) {
        if (r < left) {
            return Integer.MAX_VALUE;
        }

        if (l > right) {
            return Integer.MAX_VALUE;
        }

        if (left == right) {
            return tree[target];
        }

        int mid = (left + right) / 2;

        int minLeft = min(l, r, left, mid, 2 * target + 1);

        int minRight = min(l, r, mid + 1, right, 2 * target + 2);

        return Math.min(minLeft, minRight);
    }

    public static void main(String[] args) {

        int[] nums = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 };

        SegmentTreeV2 st = new SegmentTreeV2(nums);

        System.out.println(Arrays.toString(st.tree));

        st.add(3, 10);

        System.out.println(Arrays.toString(st.tree));

        System.out.println(st.query(0));

        System.out.println(st.query(3));

        System.out.println(st.sum(1, 4));
        System.out.println(st.min(1, 4));

        System.out.println(st.min(0, 14));

    }

}
