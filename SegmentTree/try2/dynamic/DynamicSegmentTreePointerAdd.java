package SegmentTree.try2.dynamic;

// learn from https://leetcode.cn/circle/discuss/H4aMOn/

public class DynamicSegmentTreePointerAdd {
    private class Node {
        int lazy, val;
        Node lChild, rChild;
    }

    int n;
    Node root;

    public DynamicSegmentTreePointerAdd(int n) {
        this.n = n;
        this.root = new Node();
    }

    public void add(int l, int r, int x) {
        add(l, r, x, root, 0, n - 1);
    }

    private void add(int l, int r, int x, Node node, int left, int right) {

        if (l <= left && right <= r) {
            node.val += (right - left + 1) * x;
            node.lazy += x;
            return;
        }

        pushDown(left, right, node);

        int mid = left + (right - left) / 2;

        if (l <= mid) {
            add(l, r, x, node.lChild, left, mid);
        }

        if (r > mid) {
            add(l, r, x, node.rChild, mid + 1, right);
        }

        node.val = node.lChild.val + node.rChild.val;
    }

    private void pushDown(int left, int right, Node node) {
        int mid = left + (right - left) / 2;

        if (node.lChild == null) {
            node.lChild = new Node();
        }

        if (node.rChild == null) {
            node.rChild = new Node();
        }

        if (node.lazy != 0) {
            // push down

            node.lChild.val += (mid - left + 1) * node.lazy;
            node.lChild.lazy += node.lazy;

            node.rChild.val += (right - mid) * node.lazy;
            node.rChild.lazy += node.lazy;

            node.lazy = 0;
        }
    }

    public int sum(int l, int r) {
        return sum(l, r, root, 0, n - 1);
    }

    private int sum(int l, int r, Node root, int left, int right) {

        if (l <= left && right <= r) {
            return root.val;
        }

        pushDown(left, right, root);

        int mid = left + (right - left) / 2;

        int result = 0;

        if (l <= mid) {
            result += sum(l, r, root.lChild, left, mid);
        }

        if (r > mid) {
            result += sum(l, r, root.rChild, mid + 1, right);
        }

        return result;
    }

    public static void main(String[] args) {

        DynamicSegmentTreePointerAdd st = new DynamicSegmentTreePointerAdd(5);

        st.add(0, 0, 1);
        st.add(1, 1, 2);
        st.add(2, 2, 3);
        st.add(3, 3, 4);
        st.add(4, 4, 5);

        System.out.println(st.sum(0, 4));
    }
}
