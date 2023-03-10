package FirstExercise.dp.easy;

public class T718 {
    public int findLength(int[] nums1, int[] nums2) {

        int len1 = nums1.length;
        int len2 = nums2.length;
        int result = 0;
        //dp[i][j] 指的是以nums[i-1]和nums[j-1]结尾的公共子序列的长度
        //为了避免数组下标越界故做以上定义
        int[][] dp = new int[len1 + 1][len2 + 1];

        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                result = Math.max(result, dp[i][j]);
            }
        }
        return result;
    }
}
