package FirstExercise.binarytree;

public class T112 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null){
            return false;
        }
        return traverse(root,targetSum - root.val);
    }

    public boolean traverse(TreeNode root, int count) {

        if (root.left == null && root.right == null && count == 0) {
            return true;
        }
        if (root.left == null && root.right == null) {
            return false;
        }

        if (root.left != null) {
            count -= root.left.val;
            if (traverse(root.left,count)){
                return true;
            }
            count += root.left.val;
        }
        if (root.right != null) {
            count -= root.right.val;
            if (traverse(root.right,count)){
                return true;
            }
            count += root.right.val;
        }
        return false;
    }
}
