package FirstExercise.binarytree;


import java.util.Deque;
import java.util.LinkedList;

@SuppressWarnings({"all"})
public class T101 {
    public boolean isSymmetric(TreeNode root) {
        return isSymmetricByQueue(root);
    }


    /**
     *
     * @param left 左子树的比较结点
     * @param right 右子树的比较结点
     * @return
     */
    public boolean compare(TreeNode left, TreeNode right) {

        if (left == null && right == null) {
            return true;
        } else if (left != null && right == null) {
            return false;
        } else if (left == null && right !=null) {
            return false;
        } else if (left.val != right.val) {
            return false;
        } // else的情况即为判断相等时 继续向下递归比较

        boolean b1 = compare(left.left,right.right); //左孩子的左孩子 与右孩子的右孩子比较
        boolean b2 = compare(left.right,right.left);
        return b1 && b2;
    }

    /**
     *
     * @param left 左子树的比较结点
     * @param right 右子树的比较结点
     * @return
     */
    public boolean isSymmetricByQueue(TreeNode root){

        Deque<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.offer(root.left);
            queue.offer(root.right);
        }

        while (!queue.isEmpty()) {
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();

            if (left == null && right == null) {
                continue;
            }

            if (left == null || right == null || left.val != right.val) {
                return false;
            }
            queue.offer(left.left);
            queue.offer(right.right);
            queue.offer(left.right);
            queue.offer(right.left);
        }
        return true;
    }
}
