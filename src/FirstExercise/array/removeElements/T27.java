package FirstExercise.array.removeElements;

public class T27 {
    public int removeElement(int[] nums, int val) {
        int slowIndex = 0;
        for (int fastIndex = 0; fastIndex < nums.length; fastIndex++) {
            if (nums[fastIndex] != val) {
                nums[slowIndex++] = nums[fastIndex];
            }
            nums[++slowIndex] = nums[fastIndex];
        }
        return slowIndex;
    }
}
