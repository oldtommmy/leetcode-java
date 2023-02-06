package FirstExercise.binarytree;

public class T104 {
    public int maxDepth(TreeNode root) {
        return getHeight(root);
    }

    public int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        return 1 + Math.max(leftHeight,rightHeight);
    }
}
