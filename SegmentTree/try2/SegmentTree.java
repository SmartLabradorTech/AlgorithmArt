package SegmentTree.try2;

// 2nd implement to keep proficiency

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

        pushUp(target);
    }

    private void pushUp(int i) {
        tree[i] = tree[2 * i] + tree[2 * i + 1];
    }

    public void add(int i, int x) {
        addV2(i, x, 1, 0, n - 1);
        nums[i] += x;
    }

    // use the pushup function which is similar to build logic.
    private void addV2(int i, int x, int index, int left, int right) {
        if (left == right) {
            // reach a leaf node
            tree[index] += x;
            return;
        }

        int mid = left + (right - left) / 2;

        if (i <= mid) {
            addV2(i, x, 2 * index, left, mid);
        } else {
            addV2(i, x, 2 * index + 1, mid + 1, right);
        }

        pushUp(index);
    }

    // this version does not use pushUp logic.
    private void addV1(int i, int x, int index, int left, int right) {
        tree[index] += x;

        if (left == right) {
            return;
        }

        int mid = (left + right) / 2;

        if (i <= mid) {
            addV1(i, x, 2 * index, left, mid);
        } else {
            addV1(i, x, 2 * index + 1, mid + 1, right);
        }
    }

    public void update(int i, int x) {

        update(i, x, 1, 0, n - 1);
    }

    private void update(int i, int x, int index, int left, int right) {

        if (left == right) {
            tree[index] = x;
            return;
        }

        int mid = left + (right - left) / 2;

        if (i <= mid) {
            update(i, x, 2 * index, left, mid);
        } else {
            update(i, x, 2 * index + 1, mid + 1, right);
        }

        pushUp(index);
    }

    public int query(int i) {
        return query(i, 1, 0, n - 1);
    }

    // need to explictly check out of range.
    private int query(int i, int index, int left, int right) {

        if (left == right) {
            return tree[index];
        }

        int mid = left + (right - left) / 2;

        if (i <= mid) {
            return query(i, 2 * index, left, mid);
        } else {
            return query(i, 2 * index + 1, mid + 1, right);
        }
    }

    public int sum(int l, int r) {

        return sum(l, r, 1, 0, n - 1);
    }

    // need to explictly check out of range.
    private int sumV1(int l, int r, int index, int left, int right) {

        if (l <= left && r >= right) {
            return tree[index];
        }

        if (r < left || l > right) {
            return 0;
        }

        int mid = left + (right - left) / 2;

        int leftSum = sumV1(l, r, 2 * index, left, mid);

        int rightSum = sumV1(l, r, 2 * index + 1, mid + 1, right);

        return leftSum + rightSum;

    }

    private int sum(int l, int r, int index, int left, int right) {

        if (l <= left && r >= right) {
            return tree[index];
        }

        int mid = left + (right - left) / 2;

        int result = 0;

        if (l <= mid) {
            result += sum(l, r, 2 * index, left, mid);
        }

        if (r >= mid + 1) {
            result += sum(l, r, 2 * index + 1, mid + 1, right);
        }

        return result;
    }

    public static void main(String[] args) {

        // int[] nums = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 };

        int[] nums = { 1, 2, 3, 4, 5 };

        SegmentTree st = new SegmentTree(nums);

        System.out.println(Arrays.toString(st.tree));

        // st.add(0, 1);

        // System.out.println(Arrays.toString(st.tree));

        // st.update(0, 2);
        // System.out.println(Arrays.toString(st.tree));

        // System.out.println(st.query(2));

        System.out.println(st.sum(1, 1));
    }

}
