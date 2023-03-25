package secondExercise.twoPointers;

public class T27 {
    public int removeElement(int[] nums, int val) {
        int cnt = nums.length;
        int quick, slow = 0;
        for (quick = 0; quick < nums.length; quick++) {
            if (nums[quick] != val) {
                nums[slow] = nums[quick];
                slow++;
            }

            cnt--;
        }
        return cnt;
    }
}
