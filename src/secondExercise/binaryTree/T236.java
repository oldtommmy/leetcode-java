package secondExercise.binaryTree;

import FirstExercise.binarytree.TreeNode;

public class T236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return reverse(root, p, q);
    }

    public TreeNode reverse(TreeNode cur, TreeNode p, TreeNode q) {

        if (cur == null || cur == p || cur == q) {
            return cur;
        }

        TreeNode left = reverse(cur.left, p, q);
        TreeNode right = reverse(cur.right, p, q);
        if (left != null && right != null) {
            return cur;
        }
        if (left == null) {
            return right;
        }
        return left;
    }
}
