package secondExercise.binaryTree;

import FirstExercise.binarytree.TreeNode;

import java.util.Deque;
import java.util.LinkedList;


public class T101 {
    public boolean isSymmetric(TreeNode root) {
        return byQueue(root);
    }

    public boolean byQueue(TreeNode root) {

        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root.left);
        deque.add(root.right);
        while (!deque.isEmpty()) {
            TreeNode left = deque.pop();
            TreeNode right = deque.pop();
            if (left == null && right == null) {
                continue;
            }
            if (left == null || right == null) {
                return false;
            }
            if (left.val != right.val) {
                return false;
            }
            deque.add(left.left);
            deque.add(right.right);
            deque.add(left.right);
            deque.add(right.left);
        }
        return true;
    }

    public boolean reverse(TreeNode left, TreeNode right) {

        //处理当层
        if (left == null && right == null) {
            return true;
        }

        if (left == null || right == null) {
            return false;
        }


        if (left.val != right.val) {
            return false;
        }

        boolean r1 = reverse(left.left, right.right);
        boolean r2 = reverse(left.right, right.left);
        return r1 & r2;
    }


}
