package FirstExercise.dp.easy;

public class T115 {
    public int numDistinct(String s, String t) {
        char[] s_ch = s.toCharArray();
        char[] t_ch = t.toCharArray();
        int s_len = s_ch.length;
        int t_len = t_ch.length;
        int[][] dp = new int[s_len + 1][t_len + 1];
        //dp[i][j]：以i-1为结尾的s子序列中出现以j-1为结尾的t的个数为dp[i][j]
        for (int i = 0; i < s_len + 1; i++) {
            dp[i][0] = 1;
        }


        for (int i = 1; i < s_len + 1; i++) {
            for (int j = 1; j < t_len + 1; j++) {
                if (s_ch[i - 1] == t_ch[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                    //这个地方需要好好理解
                    //以bag 和 bagg为例
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }
        return dp[s_len][t_len];
    }
}
