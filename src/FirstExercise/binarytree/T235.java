package FirstExercise.binarytree;

public class T235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return traverse(root, p, q);
    }

    public TreeNode traverse(TreeNode cur, TreeNode p, TreeNode q) {

        if (cur == null) {
            return null;
        }

        if (cur.val > p.val && cur.val > q.val) {
            TreeNode left = traverse(cur.left, p, q);
            if (left != null) {
                return left;
            }
        }

        if (cur.val < p.val && cur.val < q.val) {
            TreeNode right = traverse(cur.right, p, q);
            if (right != null) {
                return right;
            }
        }

        return cur;
    }

    public TreeNode lowestCommonAncestorByQueue(TreeNode root, TreeNode p, TreeNode q) {

        while (true) {
            if (root.val > p.val && root.val > q.val) {
                root = root.left;
            } else if (root.val < p.val && root.val < q.val) {
                root = root.right;
            } else {
                break;
            }
        }
        return root;
    }
}
