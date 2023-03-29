package secondExercise.binaryTree;

import FirstExercise.binarytree.TreeNode;

public class T654 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return reverse(nums, 0, nums.length);
    }

    public TreeNode reverse(int[] nums, int left, int right) {

        if (left >= right){
            return null;
        }
        int index = 0;
        int maxValue = -1;
        for (int i = left; i < right; i++) {
            if (maxValue < nums[i]) {
                index = i;
                maxValue = nums[i];
            }
        }
        TreeNode root = new TreeNode(maxValue);
        root.left = reverse(nums, left, index);
        root.right = reverse(nums, index + 1, right);
        return root;
    }
}
