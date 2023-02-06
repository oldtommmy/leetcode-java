package FirstExercise.binarytree.traversal;

import FirstExercise.binarytree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"all"})
public class T144 {

//    public List<Integer> preorderTraversal(TreeNode root) {
//        ArrayList<Integer> res = new ArrayList<>();
//        preorder(root,res);
//        return res;
//    }
//
//    public void preorder(TreeNode treeNode, List<Integer> res) {
//        if (treeNode == null) {
//            return;
//        }
//        res.add(treeNode.val);
//        preorder(treeNode.left,res);
//        preorder(treeNode.right,res);
//    }
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList();
        }
        ArrayList<Integer> list = new ArrayList<>();
        preorderByStack(root,list);
        return list;
    }

    public void preorderByStack(TreeNode root, List<Integer> res) {

        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);  //先将root加入栈中
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node != null) { //若node不为空 则加入到结果中
                res.add(node.val);
            } else {
                continue;
            }
            if (node.right!= null) {  //分别将 right 和 left 入栈 且需要注意空节点不入栈
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
    }
}
