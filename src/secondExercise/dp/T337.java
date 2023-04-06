package secondExercise.dp;

import FirstExercise.binarytree.TreeNode;

public class T337 {
    public int rob(TreeNode root) {
        int[] dp = traversal(root);
        return Math.max(dp[0], dp[1]);
    }

    public int[] traversal(TreeNode cur) {

        // 0 -> steal
        int[] dp = new int[2];
        if (cur == null) {
            return dp;
        }

        int[] left = traversal(cur.left);
        int[] right = traversal(cur.right);
        dp[0] = left[1] + right[1] + cur.val;
        dp[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return dp;
    }
}
