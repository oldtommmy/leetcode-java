package FirstExercise.greedy;

@SuppressWarnings({"all"})
public class T376 {

    public int wiggleMaxLength(int[] nums) {
        int len = nums.length;
        if (len <= 1) {
            return len;
        }

        int cur = 0; //当前差值
        int pre = 0; //前一个差值
        int result = 1; //假设最右端有一个峰值

        for (int i = 0; i < len - 1; i++) {
            cur = nums[i] - nums[i + 1];
            if ((pre <= 0 && cur > 0) || (pre >= 0 && cur < 0)) {
                result++;
                pre = cur;
            }
        }
        return result;
    }
}
