package SegmentTree.try2;

import java.util.Arrays;

public class SegmentTreeMax {

    int[] nums, tree;
    int n;

    public SegmentTreeMax(int[] nums) {
        this.nums = nums;
        this.n = nums.length;
        this.tree = new int[4 * n];

        build(1, 0, n - 1);
    }

    private void build(int index, int left, int right) {

        if (left == right) {
            tree[index] = nums[left];
            return;
        }

        int mid = left + (right - left) / 2;

        build(2 * index, left, mid);

        build(2 * index + 1, mid + 1, right);

        tree[index] = Math.max(tree[2 * index], tree[2 * index + 1]);
    }

    public int max(int l, int r) {

        return max(l, r, 1, 0, n - 1);
    }

    private int max(int l, int r, int index, int left, int right) {

        if (l <= left && r >= right) {
            return tree[index];
        }

        int mid = left + (right - left) / 2;

        int result = Integer.MIN_VALUE;

        if (l <= mid) {
            result = Math.max(max(l, r, 2 * index, left, mid), result);
        }

        if (r > mid) {
            result = Math.max(result, max(l, r, 2 * index + 1, mid + 1, right));
        }

        return result;
    }

    public int sum(int l, int r) {

        return sum(l, r, 1, 0, n - 1);
    }

    private int sum(int l, int r, int index, int left, int right) {

        if (left == right) {
            return nums[left];
        }

        int mid = (left + right) / 2;

        int result = 0;

        if (l <= mid) {
            result += sum(l, r, 2 * index, left, mid);
        }

        if (r > mid) {
            result += sum(l, r, 2 * index + 1, mid + 1, right);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4, 5 };

        SegmentTreeMax st = new SegmentTreeMax(nums);

        System.out.println(Arrays.toString(st.tree));

        // System.out.println(st.max(1, 3));
        System.out.println(st.sum(0, 0));

    }

}
