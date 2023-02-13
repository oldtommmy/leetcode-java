package FirstExercise.greedy;

import java.util.Arrays;

public class T455 {

    public int findContentChildren(int[] g, int[] s) {
        if (s.length == 0) {
            return 0;
        }
        int count = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        // i 遍历饼干s
        // j 遍历胃口g
        for (int i = 0, j = 0; i < s.length && j < g.length; i++) {
            if (s[i] >= g[j]) {
                count++;
                j++;
            }
        }
        return count;
    }
}
