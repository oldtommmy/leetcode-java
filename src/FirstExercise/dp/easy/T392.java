package FirstExercise.dp.easy;

public class T392 {
    public boolean isSubsequence(String s, String t) {
        return byDp(s,t);
    }


    /**
     * 使用动态规划
     * @param s s
     * @param t t
     * @return boolean
     */
    private boolean byDp(String s, String t) {

        int s_len = s.length();
        int t_len = t.length();
        //dp[i][j]表示s[i - 1] s[j - 1]结尾的最长公共子序列的长度
        int[][] dp = new int[s_len + 1][t_len + 1];

        for (int i = 1; i < s_len + 1; i++) {
            for (int j = 1; j < t_len + 1; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }
        return dp[s_len][t_len] == s_len;
    }


    /**
     * 使用双指针
     * @param s s
     * @param t t
     * @return boolean
     */
    private boolean byTwoPoint(String s, String t) {
        int i, j;
        for (i = 0, j = 0; i < s.length() && j < t.length(); ) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
                j++;
            } else {
                j++;
            }
        }
        if (i == s.length() - 1) {
            return true;
        }
        return false;
    }
}
