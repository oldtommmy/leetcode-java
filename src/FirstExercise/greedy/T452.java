package FirstExercise.greedy;

import java.util.Arrays;

public class T452 {

    public int findMinArrowShots(int[][] points) {
        int cnt = 0;
        Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));
        int end = points[0][1];

        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > end) {
                cnt++;
                end = points[i][1];
                continue;
            }
            end = Math.min(end, points[i][1]);
        }
        return cnt;
    }
}
