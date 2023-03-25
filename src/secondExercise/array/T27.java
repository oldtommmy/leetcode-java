package secondExercise.array;

public class T27 {
    public int removeElement(int[] nums, int val) {

        int fast = 0;
        int slow = 0;
        int len = nums.length;
        while (fast < nums.length) {
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                fast++;
                slow++;
                continue;
            }
            len--;
            fast++;
        }
        return len;
    }
}
