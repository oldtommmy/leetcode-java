package FirstExercise.binarytree.traversal;

import FirstExercise.binarytree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"all"})
public class T94 {
//    public List<Integer> inorderTraversal(TreeNode root) {
//        ArrayList<Integer> res = new ArrayList<>();
//        inorder(root,res);
//        return res;
//    }
//
//    public void inorder(TreeNode treeNode, List<Integer> res) {
//        if (treeNode == null) {
//            return;
//        }
//        inorder(treeNode.left,res);
//        res.add(treeNode.val);
//        inorder(treeNode.right,res);
//    }

    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        inorderByStack(root, res);
        return res;
    }

    /**
     * 迭代法
     * @param treeNode
     * @param res
     */
    public void inorderByStack(TreeNode root, List<Integer> res) {

        ArrayDeque<TreeNode> stack = new ArrayDeque<>();

        if (root != null) {
            stack.push(root);
        }

        while (!stack.isEmpty()) {
            TreeNode node = stack.peek();
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                node = stack.pop();
                res.add(node.val);
                node = node.right;
            }
        }
    }
}
