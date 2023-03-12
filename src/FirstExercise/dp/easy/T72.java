package FirstExercise.dp.easy;

public class T72 {
    public int minDistance(String word1, String word2) {
        //dp[i][j]意思是word1以i-1结尾 转化为word2以j-1结尾所需最小步数
        char[] ch1 = word1.toCharArray();
        char[] ch2 = word2.toCharArray();
        int len1 = ch1.length;
        int len2 = ch2.length;
        int[][] dp = new int[len1 + 1][len2 + 1];
        //共三种方式修改：插入、删除、替换
        for (int i = 1; i < len1 + 1; i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i < len2 + 1; i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i < len1 + 1; i++) {
            for (int j = 1; j < len2 + 1; j++) {
                if (ch1[i - 1] == ch2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i - 1][j - 1]), dp[i][j - 1]) + 1;
                }
            }
        }
        return dp[len1][len2];
    }
}
