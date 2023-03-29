package secondExercise.binaryTree;

import FirstExercise.binarytree.TreeNode;

import java.util.ArrayList;

public class T501 {

    ArrayList<Integer> list = new ArrayList<>();
    int max = -1;
    int cnt = 0;
    TreeNode pre = null;
    public int[] findMode(TreeNode root) {
        reverse(root);
        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }

    /**
     * 中序遍历 遍历出来是有序数组
     * @param cur cur
     */
    public void reverse(TreeNode cur) {
        if (cur == null) {
            return;
        }

        reverse(cur.left);
        if (pre == null) {
            cnt = 1;
        } else if (pre.val == cur.val) {
            cnt++;
        } else {
            cnt = 1;
        }

        if (cnt > max) {
            list.clear();
            list.add(cur.val);
            max = cnt;
        } else if (cnt == max) {
            list.add(cur.val);
        }
        pre = cur;
        reverse(cur.right);
    }
}
