package FirstExercise.array.binary;

public class T704 {
    public int search(int[] nums, int target) {

        if (target < nums[0] || target > nums[nums.length - 1]) {
            return -1;
        }

        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}