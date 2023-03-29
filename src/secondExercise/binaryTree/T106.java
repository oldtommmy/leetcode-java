package secondExercise.binaryTree;

import FirstExercise.binarytree.TreeNode;

import java.util.HashMap;

public class T106 {

    HashMap<Integer, Integer> map;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return reverse(inorder, 0, inorder.length, postorder, 0, postorder.length);
    }

    public TreeNode reverse(int[] inorder, int inLeft, int inRight, int[] postorder, int postLeft, int postRight) {

        //区间遵循左闭右开
        if (inLeft >= inRight || postLeft >= postRight) {
            return null;
        }

        //找到后序遍历的最后一个 即 根
        int val = postorder[postRight - 1];
        TreeNode root = new TreeNode(val);
        int indexOfInorder = map.get(val);
        int lenOfLeft = indexOfInorder - inLeft;
        root.left = reverse(inorder, inLeft, indexOfInorder, postorder, postLeft, postLeft + lenOfLeft);
        root.right = reverse(inorder, indexOfInorder + 1, inorder.length, postorder, postLeft + lenOfLeft, postRight - 1);
        return root;
    }
}
