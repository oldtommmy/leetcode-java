package FirstExercise.binarytree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

@SuppressWarnings({"all"})
public class T617 {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {

        if (root1 == null) {
            return root2;
        }

        if (root2 == null) {
            return root1;
        }

        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root1);
        deque.offer(root2);
        while (!deque.isEmpty()) {
            TreeNode node1 = deque.poll();
            TreeNode node2 = deque.poll();
            node1.val = node1.val + node2.val;

            if (node1.left != null && node2.left != null) {
                deque.offer(node1.left);
                deque.offer(node2.left);
            }

            if (node1.right != null && node2.right != null) {
                deque.offer(node1.right);
                deque.offer(node2.right);
            }

            if (node1.left == null && node2.left != null) {
                node1.left = node2.left;
            }

            if (node1.right == null && node2.right != null) {
                node1.right = node2.right;
            }
        }
        return root1;
    }

































//    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
//
//        //终止条件
//        if (root1 == null) {
//            return root2;
//        }
//
//        if (root2 == null) {
//            return root1;
//        }
//
//        //单层递归逻辑
//        root1.val += root2.val; //根
//        root1.left = mergeTrees(root1.left,root2.left); //左
//        root1.right = mergeTrees(root1.right, root2.right);//右
//        return root1;
//    }
}
