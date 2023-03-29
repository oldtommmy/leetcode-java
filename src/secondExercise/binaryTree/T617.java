package secondExercise.binaryTree;

import FirstExercise.binarytree.TreeNode;

public class T617 {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {

        if (root1 == null && root2 == null) {
            return null;
        }

        TreeNode root;
        if (root1 == null) {
            root = new TreeNode(root2.val);
            root.left = mergeTrees(null, root2.left);
            root.right = mergeTrees(null, root2.right);
        } else if (root2 == null) {
            root = new TreeNode(root1.val);
            root.left = mergeTrees(root1.left, null);
            root.right = mergeTrees(root1.right, null);
        } else {
            root = new TreeNode(root1.val + root2.val);
            root.left = mergeTrees(root1.left, root2.left);
            root.right = mergeTrees(root1.right, root2.right);
        }

        return root;
    }


}
