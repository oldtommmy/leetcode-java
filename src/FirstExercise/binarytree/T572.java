package FirstExercise.binarytree;


public class T572 {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {

        if (subRoot == null) {
            return true;
        }
        if (root == null) {
            return false;
        }
        return isSubtree(root.left,subRoot) || isSubtree(root.right,subRoot) || isSameTree(root,subRoot);

    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return false;
        }
        if (p == null || q == null || q.val != p.val) {
            return false;
        }
        boolean b1 = isSameTree(p.left,q.left);
        boolean b2 = isSameTree(p.right,q.right);
        return b1 && b2;
    }
}
