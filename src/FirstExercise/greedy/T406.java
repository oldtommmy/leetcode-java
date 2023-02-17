package FirstExercise.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T406 {

    /**
     * 此题再次涉及两个因素的确定，我们在分发糖果的题目里也有类似的问题，
     * 应先确定一个维度，再去调整另一个因素
     * 1. 先按照身高 由高到低 进行排序
     * 2. 再去按照 k 去调整位置
     */
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1];
            }
            return a[0] - b [0];
        });

        List<int[]> que = new ArrayList<>();
        for (int[] person : people) {
            que.add(person[1], person);
        }
        return que.toArray(new int[people.length][2]);
    }
}
