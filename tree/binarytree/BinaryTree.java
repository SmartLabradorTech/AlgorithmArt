package tree.binarytree;

public class BinaryTree {
    public void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        System.out.println(root.val);

        preOrder(root.left);

        preOrder(root.right);
    }

    public void innerOrder(TreeNode root) {

        if (root == null) {
            return;
        }

        innerOrder(root.left);

        System.out.println(root.val);

        innerOrder(root.right);

    }

    public void postOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        postOrder(root.left);
        postOrder(root.right);

        System.out.println(root.val);

    }

    public static void main(String[] args) {

        TreeNode n4 = new TreeNode();
        n4.val = 4;

        TreeNode n5 = new TreeNode();
        n5.val = 5;

        TreeNode n6 = new TreeNode();
        n6.val = 6;

        TreeNode n7 = new TreeNode();
        n7.val = 7;

        TreeNode n2 = new TreeNode();
        n2.val = 2;
        n2.left = n4;
        n2.right = n5;

        TreeNode n3 = new TreeNode();
        n3.val = 3;
        n3.left = n6;
        n3.right = n7;

        TreeNode n1 = new TreeNode();
        n1.val = 1;
        n1.left = n2;
        n1.right = n3;

        BinaryTree bt = new BinaryTree();

        // bt.preOrder(n1);

        // bt.innerOrder(n1);

        bt.postOrder(n1);

    }
}

class TreeNode {

    int val;

    TreeNode left;

    TreeNode right;
}
