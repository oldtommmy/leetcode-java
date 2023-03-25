package secondExercise.array;

public class T34 {
    //数组为非递减序列 可以使用两次二分查找
    //分别找到left 和 right的border
    //此时 有三种情况
    //情况一：target 在数组范围的右边或者左边，例如数组{3, 4, 5}，target为2或者数组{3, 4, 5},target为6，此时应该返回{-1, -1}
    //情况二：target 在数组范围中，且数组中不存在target，例如数组{3,6,7},target为5，此时应该返回{-1, -1}
    //情况三：target 在数组范围中，且数组中存在target，例如数组{3,6,7},target为6，此时应该返回{1, 1}
    public int[] searchRange(int[] nums, int target) {
        int right = findRight(nums, target);
        int left = findLeft(nums, target);
        if (right == -2 || left == -2) {
            return new int[]{-1,-1};
        }
        if (right - left > 1) return new int[]{left + 1, right - 1};
        return new int[]{-1,-1};
    }
    private int findLeft(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int border = -2;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] >= target) {
                right = mid - 1;
                border = right;
            } else {
                left = mid + 1;
            }
        }
        return border;
    }

    private int findRight(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int border = -2;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] <= target) {
                left = mid + 1;
                border = left;
            } else {
                right = mid - 1;
            }
        }
        return border;
    }
}
