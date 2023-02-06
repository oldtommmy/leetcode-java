package FirstExercise.binarytree;

@SuppressWarnings({"all"})
public class T110 {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        return getHeight(root) == -1 ? false : true;
    }

    /**
     *
     * @param root root
     * @return -1: false    >=0:height
     */
    public int getHeight(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int left = getHeight(root.left);
        int right = getHeight(root.right);
        if (left == -1 || right == -1) {
            return -1;
        }
        return Math.abs(left - right) > 1 ? -1 : Math.max(left,right) + 1;
    }
}
