package FirstExercise.array.binary;

@SuppressWarnings({"all"})
public class T34 {
    public int[] searchRange(int[] nums, int target) {
        int leftBorder = getLeftBorder(nums, target);
        int rightBorder = getRightBorder(nums, target);

        //1.target 在数组范围中，数组中不存在target
        if (leftBorder == -2 || rightBorder == -2) {
            return new int[]{-1, -1};
        }
        //2.target 在数组范围中，且数组中存在target
        if (rightBorder - leftBorder > 1) {
            return new int[]{leftBorder + 1, rightBorder - 1};
        }
        //3.target 在数组范围中，且数组中存在target
        return new int[]{-1, -1};

    }

    int getRightBorder(int[] nums, int target) {

        int left = 0, right = nums.length - 1;
        int rightBorder = -2;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target < nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
                rightBorder = left;
            }
        }
        return rightBorder;
    }

    int getLeftBorder(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int leftBorder = -2;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
                leftBorder = right;
            }
        }
        return leftBorder;
    }
}
