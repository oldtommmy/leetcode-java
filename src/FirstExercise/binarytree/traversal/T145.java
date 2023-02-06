package FirstExercise.binarytree.traversal;

import FirstExercise.binarytree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SuppressWarnings({"all"})
public class T145 {
//    public List<Integer> postorderTraversal(TreeNode root) {
//        ArrayList<Integer> res = new ArrayList<>();
//        postorder(root,res);
//        return res;
//    }
//
//    public void postorder(TreeNode treeNode, List<Integer> res) {
//        if (treeNode == null) {
//            return;
//        }
//        postorder(treeNode.left,res);
//        postorder(treeNode.right,res);
//        res.add(treeNode.val);
//    }

    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList();
        }
        ArrayList<Integer> list = new ArrayList<>();
        postorderByStack(root,list);
        Collections.reverse(list);
        return list;
    }

    public void postorderByStack(TreeNode root, List<Integer> res) {

        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);  //先将root加入栈中
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node != null) { //若node不为空 则加入到结果中
                res.add(node.val);
            } else {
                continue;
            }
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right!= null) {
                stack.push(node.right);
            }
        }
    }

}
