package FirstExercise.binarytree;

@SuppressWarnings({"all"})
public class T236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null || root == p || root == q) {
            return root;
        }

        //后序遍历
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left == null && right == null) {
            return null;
        }
        if (left == null && right != null) {
            return right;
        }
        if (left != null && right == null) {
            return left;
        }
        return root;
    }
}
