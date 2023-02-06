package FirstExercise.array.removeElements;

@SuppressWarnings({"all"})
public class T26 {
    public int removeDuplicates(int[] nums) {

        if (nums.length == 0 || nums.length == 1) {
            return nums.length;
        }

        int slowIndex = 0, fastIndex = 1;
        while (fastIndex < nums.length) {
            if (nums[fastIndex] == nums[slowIndex]) {
                fastIndex++;
            } else {
                nums[++slowIndex] = nums[fastIndex];
            }
        }
        return slowIndex + 1;
    }

}

