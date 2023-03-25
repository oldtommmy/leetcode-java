package secondExercise.greedy;

import java.util.Arrays;

public class T455 {
    // g 胃口
    public int findContentChildren(int[] g, int[] s) {
        int cnt = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        for (int i = 0, j = 0; i < s.length && j < g.length; i++) {
            if (s[i] >= g[j]) {
                cnt++;
                j++;
            }
        }
        return cnt;
    }
}
