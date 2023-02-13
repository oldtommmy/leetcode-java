package FirstExercise.greedy;

public class T53 {

    public int maxSubArray(int[] nums) {

        int count = 0;
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            count += nums[i];
            result = Math.max(count, result); //取区间的最大值为 result
            if (count < 0) {
                count = 0; //此时 count 为负数 对于后面的累加是一个负效应 故重置
            }
        }
        return result;
    }
}
