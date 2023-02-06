package FirstExercise.binarytree;

import java.util.Deque;
import java.util.LinkedList;

public class T111 {
//    public int minDepth(TreeNode root) {
//        return getHeight(root);
//    }
//
//    public int getHeight(TreeNode root) {
//        if (root == null) {
//            return 0;
//        }
//        int leftHeight = getHeight(root.left);
//        int rightHeight = getHeight(root.right);
//
//        if (root.left == null && root.right != null) {
//            return 1 + rightHeight;
//        } else if (root.right == null && root.left != null) {
//            return 1 + leftHeight;
//        } else {
//            return 1 + Math.min(leftHeight, rightHeight);
//        }
//    }

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        int depth = 0;
        while (!deque.isEmpty()) {
            int size = deque.size();
            depth++;
            for (int i = 0; i < size; i++) {
                TreeNode poll = deque.poll();
                if (poll.left == null && poll.right == null) {
                    // 是叶子结点，直接返回depth，因为从上往下遍历，所以该值就是最小值
                    return depth;
                }
                if (poll.left != null) {
                    deque.offer(poll.left);
                }
                if (poll.right != null) {
                    deque.offer(poll.right);
                }
            }
        }
        return depth;
    }
}
