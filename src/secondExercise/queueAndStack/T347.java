package secondExercise.queueAndStack;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class T347 {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num,0) + 1);
        }

        PriorityQueue<int[]> queue = new PriorityQueue<>((item1, item2) -> item1[1] - item2[1]);
        Set<Map.Entry<Integer, Integer>> set = map.entrySet();
        for (Map.Entry<Integer, Integer> entry : set) {
            if (queue.size() < k) {
                queue.add(new int[]{entry.getKey(), entry.getValue()});
            } else {
                if (queue.peek()[1] < entry.getValue()) {
                    queue.remove();
                    queue.add(new int[]{entry.getKey(), entry.getValue()});
                }
            }
        }

        int[] ans = new int[k];
        while (!queue.isEmpty()) {
            ans[--k] = queue.poll()[0];
        }
        return ans;

    }
}
