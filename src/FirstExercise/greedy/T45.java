package FirstExercise.greedy;

public class T45 {
    public int jump(int[] nums) {
        int curDistance = 0;
        int nextDistance = 0;
        int step = 0;
        for (int i = 0; i < nums.length; i++) {
            nextDistance = Math.max(nums[i] + i, nextDistance);
            if (i == curDistance) {
                if (curDistance < nums.length - 1) {
                    curDistance = nextDistance;
                    step++;
                    if (curDistance >= nums.length - 1) {
                        break;
                    }
                }
            }
        }
        return step;
    }
}
