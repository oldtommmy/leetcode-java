package secondExercise.binaryTree;

import FirstExercise.binarytree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class T145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        reverse(list, root);
        return list;
    }

    public void reverse(List<Integer> list, TreeNode cur) {
        if (cur == null) {
            return;
        }
        reverse(list,cur.left);
        reverse(list,cur.right);
        list.add(cur.val);
    }
}
