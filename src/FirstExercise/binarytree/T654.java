package FirstExercise.binarytree;

@SuppressWarnings({"all"})
public class T654 {

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return traverse(nums,0,nums.length);
    }

    public TreeNode traverse(int[] nums, int begin, int end) {

        if (begin == end) {
            return null;
        }

        if (begin - end == 1) {
            return new TreeNode(nums[begin]);
        }

        //2.to find the max val
        int maxIndex = begin;
        int maxVal = nums[begin];
        for (int i = begin + 1; i < end; i++) {
            if (nums[i] > maxVal) {
                maxIndex = i;
                maxVal = nums[i];
            }
        }
        TreeNode root = new TreeNode(maxVal);

        //3.to cut off the nums
        //4.traverse to get the root.left and root.right
        root.left = traverse(nums, begin, maxIndex);
        root.right = traverse(nums, maxIndex + 1, end);

        return root;

    }
}
