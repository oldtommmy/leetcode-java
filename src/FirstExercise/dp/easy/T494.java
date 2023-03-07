package FirstExercise.dp.easy;

@SuppressWarnings({"all"})
public class T494 {
    public int findTargetSumWays(int[] nums, int target) {

        //推导：
        //每个数字可以为正也可以为负，我们将nums中的数字分为正数和负数两个集合left和right
        //则有
        //left + right = sum
        //left - right = target
        //可推导出 left = (sum + target) / 2
        //我们只需负责计算出有多少种凑成left集合的个数

        //dp[j] 含义为容量为j的背包填满有多少种方法
        //如何确定递推公式：
        //此处用例left = 4
        //当物品为nums[i] = 1时，若想凑成dp[4]，则有dp[3]种方式
        //当物品为nums[j] = 2时，若想凑成dp[4]，则有dp[2]种方式
        //当物品为nums[j] = 3时，若想凑成dp[4]，则有dp[1]种方式
        //可确定递推公式即为 dp[j] += dp[j - nums[i]] 进行累加

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (Math.abs(target) > sum || (target + sum) % 2 != 0) {
            return 0;
        }

        int left = (sum + target) / 2;
        int[] dp = new int[left + 1];
        dp[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = left; j >= nums[i]; j--) {
                dp[j] += dp[j - nums[i]];
            }
        }
        return dp[left];
    }
}
