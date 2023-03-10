package weekly.w335;

import FirstExercise.binarytree.TreeNode;

import java.util.*;


public class T2583 {
    public long kthLargestLevelSum(TreeNode root, int k) {
        ArrayList<Long> list = new ArrayList<>();
        level(root, list);
        list.sort(Comparator.reverseOrder());
        return list.size() < k ? -1 : list.get(k - 1);
    }

    private void level(TreeNode root, ArrayList<Long> list) {
        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);
        while (deque.size() > 0) {
            long levelSum = 0L;
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = deque.pollFirst();
                levelSum += cur.val;
                if (cur.left != null) {
                    deque.addLast(cur.left);
                }
                if (cur.right != null) {
                    deque.addLast(cur.right);
                }
            }
            list.add(levelSum);
        }
    }
}
