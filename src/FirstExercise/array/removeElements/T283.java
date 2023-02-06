package FirstExercise.array.removeElements;

public class T283 {
    public void moveZeroes(int[] nums) { // nums = [0,1,0,3,12]

        if (nums.length == 1) {
            return;
        }

        int slowIndex = 0;
        for (int fastIndex = 0; fastIndex < nums.length; fastIndex++){
            if (nums[fastIndex] == 0) {
                continue;
            }
            int temp = nums[fastIndex];
            nums[fastIndex] = nums[slowIndex];
            nums[slowIndex] = temp;
            slowIndex++;
        }

    }
}
