package FirstExercise.binarytree.traversal;

import FirstExercise.binarytree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"all"})
public class T102 {
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();
        levelOrder(root,result);
        return result;
    }

    public void levelOrder(TreeNode root, List<List<Integer>> result) {

        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        if (root != null) {
            queue.offer(root);
        }

        while (!queue.isEmpty()) {
            ArrayList<Integer> list = new ArrayList<>();
            int size = queue.size();

            while (size-- > 0){
                TreeNode poll = queue.poll();
                list.add(poll.val);

                if (poll.left != null) {
                    queue.offer(poll.left);
                }

                if (poll.right != null) {
                    queue.offer(poll.right);
                }
            }
            result.add(list);
        }
    }
}
