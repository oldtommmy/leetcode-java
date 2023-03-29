package secondExercise.binaryTree;

import FirstExercise.binarytree.TreeNode;

public class T538 {

    TreeNode pre = null;
    public TreeNode convertBST(TreeNode root) {
        traversal(root);
        return root;
    }

    public void traversal(TreeNode root) {

        if (root == null) {
            return;
        }
        traversal(root.right);
        if (pre != null) {
            root.val += pre.val;
        }
        pre = root;
        traversal(root.left);
    }
}
