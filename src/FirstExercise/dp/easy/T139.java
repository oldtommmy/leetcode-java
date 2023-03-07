package FirstExercise.dp.easy;

import java.util.HashSet;
import java.util.List;

public class T139 {
    public boolean wordBreak(String s, List<String> wordDict) {

        HashSet<String> set = new HashSet<>(wordDict);
        int length = s.length();
        boolean[] dp = new boolean[length + 1];
        dp[0] = true;
        for (int i = 0; i <= length; i++) {
            for (int j = 0; j + i <= length; j++) {
                if (dp[i] && set.contains(s.substring(i,i + j))) {
                    dp[i + j] = true;
                }
            }
        }
        return dp[length];
    }
}
