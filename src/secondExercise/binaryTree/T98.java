package secondExercise.binaryTree;

import FirstExercise.binarytree.TreeNode;

import java.util.ArrayList;

public class T98 {
    public boolean isValidBST(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        reverse(root, list);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) <= list.get(i - 1)) {
                return false;
            }
        }
        return true;
    }

    public void reverse(TreeNode cur, ArrayList<Integer> list) {

        if (cur == null) {
            return;
        }
        reverse(cur.left, list);
        list.add(cur.val);
        reverse(cur.right, list);
    }
}
