package FirstExercise.binarytree.utils;

import FirstExercise.binarytree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

@SuppressWarnings({"all"})
public final class BinaryTreeUtils {

    public static TreeNode CreateBinaryTreeByLevelOrder(int[] data) {

        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(data[0]);
        int i = 1;

        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                continue;
            }
            if (i < data.length) {
                TreeNode left = new TreeNode(data[i++]);
                queue.offer(left);
                node.left = left;
            }
            if (i < data.length) {
                TreeNode right = new TreeNode(data[i++]);
                queue.offer(right);
                node.right = right;
            }
        }
        return root;
    }

}
