package secondExercise.binaryTree;

import FirstExercise.binarytree.TreeNode;

public class T111 {

    public int minDepth(TreeNode root) {
        return getMinDepth(root);
    }

    public int getMinDepth(TreeNode cur) {

        if (cur == null) {
            return 0;
        }
        int leftLen = getMinDepth(cur.left);
        int rightLen = getMinDepth(cur.right);

        if (cur.left == null) {
            return leftLen + 1;
        }

        if (cur.right == null) {
            return rightLen + 1;
        }

        return Math.min(leftLen, rightLen);
    }
}
