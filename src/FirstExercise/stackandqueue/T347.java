package FirstExercise.stackandqueue;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

@SuppressWarnings({"all"})
public class T347 {
    public int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        //在优先队列中存储二元组(num,cnt),cnt表示元素值num在数组中的出现次数
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(pair -> pair[1]));
        for (Map.Entry<Integer,Integer> entry :map.entrySet()) {
            if (queue.size() < k) {
                queue.add(new int[]{entry.getKey(),entry.getValue()});
            } else {
                if (entry.getValue() > queue.peek()[1]) {
                    queue.poll();
                    queue.add(new int[]{entry.getKey(), entry.getValue()});
                }
            }
        }

        int[] ans = new int[k];
        for (int i = k - 1; i >= 0 ; i--) {
            ans[i] = queue.poll()[0];
        }
        return ans;
    }
}
