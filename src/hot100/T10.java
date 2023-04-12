package hot100;

public class T10 {
    public boolean isMatch(String s, String p) {

        char[] s_ch = s.toCharArray();
        char[] p_ch = p.toCharArray();
        int s_len = s_ch.length;
        int p_len = p_ch.length;
        //dp[i][j]指的是s的前i个字符 和 p前j个字符是否可以匹配
        boolean[][] dp = new boolean[s_len + 1][p_len + 1];

        //base case
        //s为空 p不为空
        //此时只有p的右侧为 * 才可能匹配
        dp[0][0] = true;
        for (int i = 1; i <= p_len; i++) {
            if (p_ch[i - 1] == '*') {
                dp[0][i] = dp[0][i - 2];
            }
        }

        for (int i = 1; i <= s_len; i++) {
            for (int j = 1; j <= p_len; j++) {

                //s[i - 1] == p[j - 1]
                if (s_ch[i - 1] == p_ch[j - 1] || p_ch[j - 1] == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p_ch[j - 1] == '*'){
                    if (s_ch[i - 1] == p_ch[j - 2] || p_ch[j - 2] == '.') {
                        //1. * 重复前面的字符0次
                        //2.重复1次
                        //3.重复>=2次
                        dp[i][j] = dp[i][j - 2] || dp[i - 1][j - 2] || dp[i - 1][j];
                    } else {
                        dp[i][j] = dp[i][j - 2];
                    }
                }
            }
        }
        return dp[s_len][p_len];
    }
}
