package FirstExercise.binarytree;

import java.util.ArrayList;

@SuppressWarnings({"all"})
public class T501 {

    private int cnt = 0;
    private int maxCnt = 0;
    private ArrayList<Integer> ans = new ArrayList<>();
    private int pre = -1;
    public int[] findMode(TreeNode root) {
        reverse(root);
        int[] res = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            res[i] = ans.get(i);
        }
        return res;
    }


    public void reverse(TreeNode root) {

        if (root == null) {
            return;
        }

        reverse(root.left);
        if (pre == -1) {
            cnt = 1;
        } else if (pre == root.val) {
            cnt++;
        } else {
            cnt = 1;
        }

        if (cnt == maxCnt) {
            ans.add(root.val);
        }
        if (cnt > maxCnt) {
            ans.clear();
            ans.add(root.val);
            maxCnt = cnt;
        }
        pre = root.val;
        reverse(root.right);
    }
}
