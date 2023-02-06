package FirstExercise.binarytree;

public class T98 {
    private long max = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        return traverse(root);
    }

    public boolean traverse(TreeNode root) {
        if (root == null) {
            return true;
        }

        boolean left = traverse(root.left);
        if (max < root.val) {
            max = root.val;
        } else {
            return false;
        }
        boolean right = traverse(root.right);
        return left && right;
    }
}
