package FirstExercise.binarytree;

import java.util.Deque;
import java.util.LinkedList;

@SuppressWarnings({"all"})
public class T700 {
    public TreeNode searchBST(TreeNode root, int val) {

        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        while (!deque.isEmpty()) {
            TreeNode poll = deque.poll();
            if (poll == null || poll.val == val) {
                return poll;
            }
            if (val < poll.val) {
                deque.offer(poll.left);
            }
            if (val > poll.val) {
                deque.offer(poll.right);
            }
        }
        return null;
    }

































//    public TreeNode searchBST(TreeNode root, int val) {
//
//        //确定终止条件
//        if (root == null || root.val == val) {
//            return root;
//        }
//
//        //单次递归逻辑
//        if (val > root.val) {
//            return searchBST(root.right, val);
//        }
//
//        return searchBST(root.left, val);
//    }
}
