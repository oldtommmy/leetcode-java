package FirstExercise.greedy;


import java.util.stream.IntStream;

public class T1005 {

    public int largestSumAfterKNegations(int[] nums, int k) {
        nums = IntStream.of(nums)
                .boxed()
                .sorted((o1, o2) -> Math.abs(o2) - Math.abs(o1))
                .mapToInt(Integer::intValue).toArray();
        int sum = 0;
        for (int i = 0; i < nums.length && k > 0; i++) {
            if (nums[i] < 0) {
                nums[i] = - nums[i];
                k--;
            } else {
                if (k % 2 == 1) {
                    nums[0] = -nums[0];
                    break;
                }
                break;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        
        return sum;
    }
}
