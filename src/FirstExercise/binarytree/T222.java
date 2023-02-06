package FirstExercise.binarytree;

import java.util.ArrayDeque;
import java.util.Deque;

@SuppressWarnings({"all"})
public class T222 {
    public int countNodes(TreeNode root) {

        if (root == null) {
            return 0;
        }

        return count(root);
    }

    public int count(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = count(root.left);
        int right = count(root.right);
        return left + right + 1;
    }

    public int countByQueue(TreeNode root) {

        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int count = 1;

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                count++;
            } else {
                continue;
            }

            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        return count;
    }
}
