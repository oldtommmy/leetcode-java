package FirstExercise.binarytree;

import java.util.ArrayDeque;

@SuppressWarnings({"all"})
public class T226 {
//    public TreeNode invertTree(TreeNode root) {
//        preorder(root);
//        return root;
//    }
//
//    public void preorder(TreeNode root) {
//        if (root == null) {
//            return;
//        }
//
//        前序遍历位置 交换root的左右子节点
//        TreeNode node = root.right;
//        root.right = root.left;
//        root.left = node;
//
//        让左右子节点继续旋转他们的子节点
//        preorder(root.left);
//        preorder(root.right);
//    }

    public TreeNode invertTree(TreeNode root) {
        preorder(root);
        return root;
    }

    public void preorder(TreeNode root) {
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        if (root != null) {
            stack.push(root);
        }
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node != null) {
                TreeNode tmp = node.left;
                node.left = node.right;
                node.right = tmp;
            } else {
                continue;
            }
            if (node.right!= null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
    }
}
