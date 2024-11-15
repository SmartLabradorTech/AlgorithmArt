package tree.binarytree.BinaryTreeInorderTraversal;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/binary-tree-inorder-traversal/description/

// recursive

public class BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> result = new ArrayList<>();

        inorderTraversal(result, root);

        return result;
    }

    private void inorderTraversal(List<Integer> result, TreeNode root) {

        if (root == null) {
            return;
        }

        inorderTraversal(result, root.left);

        result.add(root.val);

        inorderTraversal(result, root.right);

    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
