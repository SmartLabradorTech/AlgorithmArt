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

        if (lazy[target] != 0) {
            pushDown(x, start, end, target);
        }

        int mid = (start + end) / 2;

        add(l, r, x, start, mid, 2 * target + 1);

        add(l, r, x, mid + 1, end, 2 * target + 2);
    }

    private void pushDown(int x, int start, int end, int target) {

        int mid = (start + end) / 2;

        tree[2 * target + 1] += (mid - start + 1) * x;

        lazy[2 * target + 1] += x;

        tree[2 * target + 2] += (end - mid - 1 + 1) * x;

        lazy[2 * target + 2] += x;

        lazy[target] = 0;
    }

    public int query(int i) {
        return query(i, 0, nums.length - 1, 1);
    }

    private int query(int i, int start, int end, int target) {

        // if(start == end){
        // return tree[]
        // }

        return 0;
    }

    public int sum(int l, int r) {
        return sum(l, r, 0, nums.length - 1, 0);
    }

    private int sum(int l, int r, int start, int end, int target) {

        if (l <= start && end <= r) {
            return tree[target];
        }

        if (end < l || start > r) {
            return 0;
        }

        if (lazy[target] != 0) {
            pushDown(lazy[target], start, end, target);
        }

        int mid = (start + end) / 2;

        int leftSum = sum(l, r, start, mid, 2 * target + 1);

        int rightSum = sum(l, r, mid + 1, end, 2 * target + 2);

        return leftSum + rightSum;
    }

    public static void main(String[] args) {

        int[] nums = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 };

        SegmentTreeV3 st = new SegmentTreeV3(nums);

        System.out.println(Arrays.toString(st.tree));

        st.add(0, 0, 1);

        System.out.println(st.sum(0, 1));

    }

}
