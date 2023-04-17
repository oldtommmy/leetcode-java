package secondExercise.dp;

public class T392 {
    public boolean isSubsequence(String s, String t) {

        char[] s_ch = s.toCharArray();
        char[] t_ch = t.toCharArray();
        int sLen = s_ch.length;
        int tLen = t_ch.length;

        //结尾的最长子序列长度
        int[][] dp = new int[sLen + 1][tLen + 1];
        for (int i = 1; i <= sLen; i++) {
            for (int j = 1; j <= tLen; j++) {
                if (s_ch[i] == t_ch[j]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }
        return dp[sLen][tLen] == sLen;
    }
}
