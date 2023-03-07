package FirstExercise.dp.easy;

import FirstExercise.binarytree.TreeNode;

public class T337 {
    public int rob(TreeNode root) {
        int[] dp = reverse(root);
        return Math.max(dp[0], dp[1]);
    }

    public int[] reverse(TreeNode node) {

        if (node == null) {
            return new int[]{0,0};
        }
        //后序遍历
        //left[0]:偷当前节点所得到的最大价值
        //left[1]:不偷当前节点所得到的最大价值
        int[] left = reverse(node.left);
        int[] right = reverse(node.right);

        //偷node节点
        int[] dp = new int[2];
        dp[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);

        //不偷node节点
        dp[1] = node.val + left[1] + right[1];
        return dp;
    }
}
