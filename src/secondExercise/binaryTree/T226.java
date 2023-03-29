package secondExercise.binaryTree;

import FirstExercise.binarytree.TreeNode;

public class T226 {
    public TreeNode invertTree(TreeNode root) {
        reverse(root);
        return root;
    }

    public void reverse(TreeNode cur) {
        if (cur == null) {
            return;
        }

        TreeNode tmp = cur.left;
        cur.left = cur.right;
        cur.right = tmp;
        reverse(tmp.left);
        reverse(tmp.right);
    }
}
