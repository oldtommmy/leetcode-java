package secondExercise.binaryTree;

import FirstExercise.binarytree.TreeNode;

public class T701 {

    TreeNode pre = null;
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        reverse(root, val);
        return root;
    }

    public void reverse(TreeNode root, int val) {
        if (root == null) {
            if (pre.val > val) {
                pre.left = new TreeNode(val);
            } else {
                pre.right = new TreeNode(val);
            }
            return;
        }
        pre = root;
        if (root.val > val) {
            reverse(root.left, val);
        }
        if (root.val < val) {
            reverse(root.right, val);
        }
    }
}
