package secondExercise.binaryTree;

import FirstExercise.binarytree.TreeNode;

public class T450 {

    public TreeNode deleteNode(TreeNode root, int key) {
        return reverse(root, key);
    }

    public TreeNode reverse(TreeNode root, int key) {

        if (root == null) {
            return null;
        }

        if (root.val == key) {
            if (root.left == null && root.right == null) {
                return null;
            }

            if (root.left == null) {
                return root.right;
            }

            if (root.right == null) {
                return root.left;
            }

            TreeNode cur = root.right;
            while (cur.left != null) {
                cur = cur.left;
            }
            cur.left = root.left;
            return root.right;
        }

        root.left = reverse(root.left, key);
        root.right = reverse(root.right, key);
        return root;
    }
}
