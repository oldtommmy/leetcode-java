package secondExercise.array;

public class T704 {
    public int search(int[] nums, int target) {

        //数组为升序 可采用二分查找
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else{
                return mid;
            }
        }
        return -1;
    }
}
