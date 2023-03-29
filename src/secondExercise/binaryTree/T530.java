package secondExercise.binaryTree;

import FirstExercise.binarytree.TreeNode;

public class T530 {

    int min = Integer.MAX_VALUE;
    TreeNode pre = null;
    public int getMinimumDifference(TreeNode root) {

        //中序遍历 为递增序列
        reverse(root);
        return min;
    }

    public void reverse(TreeNode cur) {
        if (cur == null) {
            return;
        }
        reverse(cur.left);
        if (pre != null) {
            min = Math.min(min, cur.val - pre.val);
        }
        pre = cur;
        reverse(cur.right);
    }
}
