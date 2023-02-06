package FirstExercise.binarytree;

import java.util.Deque;
import java.util.LinkedList;

public class T100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {

        if (p == null && q == null) {
            return true;
        }

        if (p == null && q != null || p != null && q == null || p.val != q.val) {
            return false;
        }

        Deque<TreeNode> queue = new LinkedList<>();
        if (p != null && q != null) {
            queue.offer(p.left);
            queue.offer(q.left);
            queue.offer(p.right);
            queue.offer(q.right);
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
            queue.offer(right.left);
            queue.offer(left.right);
            queue.offer(right.right);

        }
        return true;
    }
}
