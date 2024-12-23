package SegmentTree.try2;

// 2nd implement to keep proficiency

import java.util.Arrays;

public class SegmentTree {
    int[] nums, tree, lazy;
    boolean[] updated;
    int n;

    public SegmentTree(int[] nums) {
        this.nums = nums;
        this.n = nums.length;

        this.tree = new int[4 * n];
        this.lazy = new int[4 * n];
        this.updated = new boolean[4 * n];

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

    public int min(int l, int r) {
        return min(l, r, 1, 0, n - 1);
    }

    private int min(int l, int r, int index, int left, int right) {

        if (left == right) {
            return tree[index];
        }

        int mid = left + (right - left) / 2;

        int result = Integer.MAX_VALUE;

        if (l <= mid) {
            result = Math.min(min(l, r, 2 * index, left, mid), result);
        }

        if (r > mid) {
            result = Math.min(min(l, r, 2 * index + 1, mid + 1, right), result);
        }

        return result;
    }

    // range add
    public void add(int l, int r, int x) {
        add(l, r, x, 1, 0, n - 1);
    }

    private void add(int l, int r, int x, int index, int left, int right) {

        if (l <= left && right <= r) {
            // just update and do not push down.
            tree[index] += (right - left + 1) * x;

            lazy[index] += x;
            return;
        }

        int mid = left + (right - left) / 2;

        if (l <= mid) {
            add(l, r, x, 2 * index, left, mid);
        }

        if (r > mid) {
            add(l, r, x, 2 * index + 1, mid + 1, right);
        }

        pushUp(index);

    }

    public int sumWithLazy(int l, int r) {
        return sumWithLazy(l, r, 1, 0, n - 1);
    }

    private int sumWithLazy(int l, int r, int index, int left, int right) {

        if (l <= left && right <= r) {
            return tree[index];
        }

        // need to check further.

        int mid = left + (right - left) / 2;

        if (lazy[index] != 0) {
            pushDownAdd(index, left, right);
        }

        int result = 0;

        if (l <= mid) {
            result += sumWithLazy(l, r, 2 * index, left, mid);
        }

        if (r > mid) {
            result += sumWithLazy(l, r, 2 * index + 1, mid + 1, right);
        }

        return result;
    }

    private void pushDownAdd(int index, int left, int right) {
        int mid = left + (right - left) / 2;

        tree[2 * index] += (mid - left + 1) * lazy[index];
        lazy[2 * index] += lazy[index];

        tree[2 * index + 1] += (right - mid) * lazy[index];
        lazy[2 * index + 1] += lazy[index];

        lazy[index] = 0;
    }

    // change all numbers in the range to be x
    public void update(int l, int r, int x) {
        update(l, r, x, 1, 0, n - 1);
    }

    private void update(int l, int r, int x, int index, int left, int right) {

        if (l <= left && right <= r) {
            tree[index] = (right - left + 1) * x;
            lazy[index] = x;
            updated[index] = true;
            return;
        }

        if (updated[index]) {
            pushDownUpdate(index, left, right);
        }

        int mid = left + (right - left) / 2;

        if (l <= mid) {
            update(l, r, x, 2 * index, left, mid);
        }

        if (r > mid) {
            update(l, r, x, 2 * index + 1, mid + 1, right);
        }

        pushUp(index);
    }

    public int sumUpdated(int l, int r) {
        return sumUpdated(l, r, 1, 0, n - 1);
    }

    private int sumUpdated(int l, int r, int index, int left, int right) {

        if (l <= left && right <= r) {
            return tree[index];
        }

        int mid = left + (right - left) / 2;

        if (updated[index]) {
            pushDownUpdate(index, left, right);
        }

        int result = 0;

        if (l <= mid) {
            result += sumUpdated(l, r, 2 * index, left, mid);
        }

        if (r > mid) {
            result += sumUpdated(l, r, 2 * index + 1, mid + 1, right);
        }

        return result;
    }

    private void pushDownUpdate(int index, int left, int right) {
        int mid = left + (right - left) / 2;

        tree[2 * index] = (mid - left + 1) * lazy[index];
        lazy[2 * index] = lazy[index];
        updated[2 * index] = true;

        tree[2 * index + 1] = (right - mid) * lazy[index];
        lazy[2 * index + 1] = lazy[index];
        updated[2 * index + 1] = true;

        updated[index] = false;
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

        // System.out.println(st.min(1, 4));

        // st.add(0, 1, 100);
        // System.out.println(Arrays.toString(st.tree));
        // System.out.println(Arrays.toString(st.lazy));

        // System.out.println(st.sumWithLazy(0, 4));

        // st.update(0, 1, 3);

        // st.update(1, 1, 4);

        // System.out.println(st.sumUpdated(1, 1));

        st.add(1, 1, 1);

        st.add(0, 0, 1);

        System.out.println(st.sumWithLazy(0, 1));

    }

}
