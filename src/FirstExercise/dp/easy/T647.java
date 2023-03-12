package FirstExercise.dp.easy;

public class T647 {
    public int countSubstrings(String s) {

        char[] ch = s.toCharArray();
        int length = ch.length;
        boolean[][] dp = new boolean[length][length];
        int sum = 0;
        //dp[i][j]表示的是ch[i] 到 ch[j]的串是否是回文串

        for (int i = length - 1; i >= 0; i--) {
            for (int j = i; j < length; j++) {
                if (ch[i] == ch[j]) {
                    if (j - i <= 1) {
                        sum++;
                        dp[i][j] = true;
                    } else {
                        if (dp[i + 1][j - 1]) {
                            sum++;
                            dp[i][j] = true;
                        }
                    }
                }
            }
        }

        return sum;
    }
}
