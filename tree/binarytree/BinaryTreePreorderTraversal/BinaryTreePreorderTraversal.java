package tree.binarytree.BinaryTreePreorderTraversal;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/binary-tree-preorder-traversal/description/

// recursive
public class BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        preorderTraversal(result, root);

        return result;
    }

    private void preorderTraversal(List<Integer> result, TreeNode root) {

        if (root == null) {
            return;
        }

        result.add(root.val);

        preorderTraversal(result, root.left);
        preorderTraversal(result, root.right);

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
