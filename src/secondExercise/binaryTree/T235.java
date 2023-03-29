package secondExercise.binaryTree;

import FirstExercise.binarytree.TreeNode;

public class T235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int value = root.val;
        if (value < p.val && value < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        } else if (value > p.val && value > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        return root;
    }
}
