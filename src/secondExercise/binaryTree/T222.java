package secondExercise.binaryTree;

import FirstExercise.binarytree.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class T222 {
    public int countNodes(TreeNode root) {
        return byQueue(root);
    }

    public int reverse(TreeNode node) {

        if (node == null) {
            return 0;
        }

        int left = reverse(node.left);
        int right = reverse(node.right);
        return left + right + 1;
    }

    public int byQueue(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int sum = 0;
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        sum++;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode peek = queue.peek();
                if (peek.left != null) {
                    queue.add(peek.left);
                    sum++;
                }
                if (peek.right != null) {
                    queue.add(peek.right);
                    sum++;
                }
                queue.poll();
            }
        }
        return sum;
    }
}
