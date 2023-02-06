package FirstExercise.binarytree;

public class T530 {

    private int min = Integer.MAX_VALUE;
    private int pre = -1;
    public int getMinimumDifference(TreeNode root) {
        reverse(root);
        return min;
    }

    public void reverse(TreeNode root) {

        if (root == null) {
            return;
        }
        reverse(root.left);
        if (pre!=-1) {
            min = Math.min(Math.abs(pre - root.val),min);
        }
        pre = root.val;
        reverse(root.right);

    }
}
