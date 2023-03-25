package secondExercise.binaryTree;

import FirstExercise.binarytree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class T94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        reverse(list, root);
        return list;
    }

    public void reverse(List<Integer> list, TreeNode cur) {
        if (cur == null) {
            return;
        }
        reverse(list,cur.left);
        list.add(cur.val);
        reverse(list,cur.right);
    }
}
