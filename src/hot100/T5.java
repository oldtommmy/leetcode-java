package hot100;

public class T5 {
    public String longestPalindrome(String s) {

        //dp[i][j]表示[i,j]的子串是否为回文串
        char[] ch = s.toCharArray();
        int len = ch.length;
        int begin = 0, end = len;
        int max = 0;
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        for (int j = 1; j < len; j++) {
            for (int i = j; i >= 0; i--) {
                if (ch[i] != ch[j]) {
                    continue;
                }
                if (j - i + 1 <= 3) {
                    dp[i][j] = true;
                } else if (dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                } else {
                    continue;
                }
                if (j - i + 1 > max) {
                    max = j - i + 1;
                    begin = i;
                    end = j + 1;
                }
            }
        }
        return s.substring(begin, end);
    }
}
