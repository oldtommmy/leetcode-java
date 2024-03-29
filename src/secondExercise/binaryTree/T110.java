package secondExercise.binaryTree;

import FirstExercise.binarytree.TreeNode;

public class T110 {

    boolean ans = true;
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int left = getHeight(root.left);
        int right = getHeight(root.right);
        if (Math.abs(left - right) > 1) {
            return false;
        }
        return ans;
    }

    public int getHeight(TreeNode node) {

        if (node == null) {
            return 0;
        }

        int left = getHeight(node.left);
        int right = getHeight(node.right);
        if (Math.abs(left - right) > 1) {
            ans = false;
        }
        return Math.max(left, right) + 1;
    }
}
