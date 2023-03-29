package secondExercise.binaryTree;

import FirstExercise.binarytree.TreeNode;

public class T108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return traversal(nums, 0, nums.length);
    }

    public TreeNode traversal(int[] nums, int left, int right) {

        if (left >= right) {
            return null;
        }

        int mid = (right - left) / 2 + left;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = traversal(nums, left, mid);
        root.right = traversal(nums, mid + 1, right);
        return root;
    }
}
