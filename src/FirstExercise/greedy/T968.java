package FirstExercise.greedy;

import FirstExercise.binarytree.TreeNode;

public class T968 {
    int result = 0;
    public int minCameraCover(TreeNode root) {
        int rootVal = traverse(root);
        if (rootVal == 0) {
            result++;
        }
        return result;
    }

    private int traverse(TreeNode cur) {

        if (cur == null) {
            return 2;
        }

        int left = traverse(cur.left);
        int right = traverse(cur.right);

        //左右都有覆盖
        if (left == 2 && right == 2) {
            return 0;
        }

        if (left == 0 || right == 0) {
            result++;
            return 1;
        }

        if (left == 1 || right == 1) {
            return 2;
        }
        return -1;
    }
}
