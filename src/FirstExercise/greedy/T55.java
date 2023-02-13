package FirstExercise.greedy;

public class T55 {

    public boolean canJump(int[] nums) {
        int maxCover = 0;
        if (nums.length == 0) {
            return true;
        }
        for (int i = 0; i <= maxCover; i++) {
            maxCover = Math.max(nums[i] + i, maxCover);
            if (maxCover >= nums.length) {
                return true;
            }
        }
        return false;
    }
}
