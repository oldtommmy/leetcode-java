package secondExercise.twoPointers;

public class T26 {
    public int removeDuplicates(int[] nums) {
        int quick, slow = 0;
        for (quick = 0; quick < nums.length; quick++) {
            if (nums[quick] != nums[slow]) {
                nums[++slow] = nums[quick];
            }
        }
        return slow + 1;
    }
}
