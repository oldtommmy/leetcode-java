package secondExercise.binaryTree;

import FirstExercise.binarytree.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class T204 {

    int maxDepth = 0;
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        byQueue(root);
        return maxDepth;
    }

    public void reverse(TreeNode cur, int depth) {

        if (cur == null) {
            return;
        }
        depth++;
        maxDepth = Math.max(maxDepth, depth);
        reverse(cur.left, depth);
        reverse(cur.right, depth);
    }

    public void byQueue(TreeNode cur) {

        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.add(cur);
        while (!deque.isEmpty()) {
            int size = deque.size();
            maxDepth++;
            for (int i = 0; i < size; i++) {
                TreeNode peek = deque.peek();
                if (peek.left != null) {
                    deque.add(peek.left);
                }
                if (peek.right != null) {
                    deque.add(peek.right);
                }
            }
            deque.poll();
        }
    }
}
