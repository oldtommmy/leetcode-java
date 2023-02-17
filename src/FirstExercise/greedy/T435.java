package FirstExercise.greedy;

import java.util.Arrays;

public class T435 {
    public int eraseOverlapIntervals(int[][] intervals) {

        if (intervals.length == 1) {
            return 0;
        }
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int cnt = 0;
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < end) {
                cnt++;
                end = Math.min(end, intervals[i][1]);
            } else {
                end = intervals[i][1];
            }
        }
        return cnt;
    }
}
