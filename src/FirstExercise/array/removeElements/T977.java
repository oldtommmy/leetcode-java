package FirstExercise.array.removeElements;

@SuppressWarnings({"all"})
public class T977 {
    public int[] sortedSquares(int[] nums) {

        int[] ans = new int[nums.length];

        int left = 0, right = nums.length - 1, index = nums.length - 1;
        while (left <= right) {
            if (nums[left] * nums[left] > nums[right] * nums[right]) {
                ans[index--] = nums[left] * nums[left];
                left++;
            } else {
                ans[index--] = nums[right] * nums[right];
                right--;
            }
        }
        return ans;
    }
}
