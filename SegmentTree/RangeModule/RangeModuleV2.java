package SegmentTree.RangeModule;

public class RangeModuleV2 {

    class Tree {

        class Node {
            int value, lazy;
            boolean updated;
            Node leftNode;
            Node rightNode;
        }

        Node root;
        int n;

        Tree(int n) {
            this.n = n;
            root = new Node();
        }

        public void update(int l, int r, int x) {
            update(l, r, x, root, 1, n);
        }

        private void update(int l, int r, int x, Node node, int left, int right) {

            if (l <= left && right <= r) {
                node.value = (right - left + 1) * x;
                node.lazy = x;
                node.updated = true;
                return;
            }

            pushDown(node, left, right);

            int mid = left + (right - left) / 2;

            if (l <= mid) {
                update(l, r, x, node.leftNode, left, mid);
            }

            if (r > mid) {
                update(l, r, x, node.rightNode, mid + 1, right);
            }

            node.value = node.leftNode.value + node.rightNode.value;
        }

        private void pushDown(Node node, int left, int right) {
            if (node.leftNode == null) {
                node.leftNode = new Node();
            }

            if (node.rightNode == null) {
                node.rightNode = new Node();
            }

            int mid = left + (right - left) / 2;

            if (node.updated) {

                node.leftNode.value = (mid - left + 1) * node.lazy;
                node.leftNode.lazy = node.lazy;
                node.leftNode.updated = true;

                node.rightNode.value = (right - mid) * node.lazy;
                node.rightNode.lazy = node.lazy;
                node.rightNode.updated = true;

                node.updated = false;
            }
        }

        public int sum(int l, int r) {
            return sum(l, r, root, 1, n);
        }

        private int sum(int l, int r, Node node, int left, int right) {

            if (l <= left && right <= r) {
                return node.value;
            }

            pushDown(node, left, right);

            int mid = left + (right - left) / 2;

            int result = 0;

            if (l <= mid) {
                result += sum(l, r, node.leftNode, left, mid);
            }

            if (r > mid) {
                result += sum(l, r, node.rightNode, mid + 1, right);
            }

            return result;
        }

    }

    private Tree sTree;

    public RangeModuleV2() {
        sTree = new Tree(1000000000);
    }

    public void addRange(int left, int right) {

        sTree.update(left, right - 1, 1);
    }

    public boolean queryRange(int left, int right) {
        int sum = sTree.sum(left, right - 1);

        return sum == right - left;
    }

    public void removeRange(int left, int right) {
        sTree.update(left, right - 1, 0);
    }

    public static void main(String[] args) {

        RangeModuleV2 rm = new RangeModuleV2();

        rm.addRange(10, 20);
        rm.removeRange(14, 16);

        System.out.println(rm.queryRange(10, 14));

        // rm.addRange(1, 2);
        // System.out.println(rm.queryRange(1, 4));

    }
}
