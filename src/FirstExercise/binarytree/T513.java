package FirstExercise.binarytree;

@SuppressWarnings({"all"})
public class T513 {

    private int maxDepth = Integer.MIN_VALUE;
    private int ans;

    public int findBottomLeftValue(TreeNode root) {
        if (root == null) {
            return root.val;
        }
        reverse(root,0);
        return ans;
    }

    //先序遍历
    public void reverse(TreeNode root, int depth) {

        //叶子结点
        if (root.left == null && root.right == null) {
            if (depth > maxDepth) {
                maxDepth = depth;
                ans = root.val;
            }
            return;
        }
        if (root.left != null) {
            depth++;
            reverse(root.left,depth);
            depth--;//回溯
        }
        if (root.right != null) {
            depth++;
            reverse(root.right, depth);
            depth--;
        }
        return;
    }
//    public int findBottomLeftValue(TreeNode root) {
//
//        Deque<TreeNode> queue = new ArrayDeque<>();
//        queue.add(root);
//        int result = 0;
//        while (!queue.isEmpty()) {
//            int size = queue.size();
//            for (int i = 0; i < size; i++) {
//                TreeNode poll = queue.poll();
//                if (i == 0) {
//                    result = poll.val;
//                }
//                if (poll.left != null) {
//                    queue.offer(poll.left);
//                }
//                if (poll.right != null) {
//                    queue.offer(poll.right);
//                }
//            }
//        }
//        return result;
//    }
}
