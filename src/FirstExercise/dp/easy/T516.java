package FirstExercise.dp.easy;

public class T516 {
    public int longestPalindromeSubseq(String s) {

        char[] ch = s.toCharArray();
        int length = ch.length;
        int max = Integer.MIN_VALUE;
        int[][] dp = new int[length][length];
        //dp i j 表示 以i开头和j结尾的回文子序列长度
        //ch i == ch j
        //1. i == j dp = 1;
        //2. j - i = 1 dp = 2;
        //3. j - i > 1 dp = dp i + 1, j - 1  + 2
        // ch i != ch j dp = max dp i + 1 j , dp i j - 1
        for (int i = length - 1; i >= 0; i--) {
            for (int j = i; j < length; j++) {
                if (ch[i] == ch[j]) {
                    if (j - i <= 1) {
                        dp[i][j] = j - i + 1;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1] + 2;
                    }
                    max = Math.max(max, dp[i][j]);
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }

        return max;
    }
}
