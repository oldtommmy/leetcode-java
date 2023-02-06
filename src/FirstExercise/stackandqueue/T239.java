package FirstExercise.stackandqueue;

import java.util.ArrayDeque;
import java.util.Deque;

@SuppressWarnings({"all"})
public class T239 {

    class MyQueue{

        Deque<Integer> deque = new ArrayDeque<>();

        void poll(int val) {
            if (!deque.isEmpty() && deque.peek() == val) {
                deque.poll();
            }
        }

        void add(int val) {
            while (!deque.isEmpty() && deque.getLast() < val) {
                deque.removeLast();
            }
            deque.offer(val);
        }

        int getMaxValue() {
            return deque.peek();
        }
    }

    public int[] maxSlidingWindow(int[] nums, int k) {

        if (nums.length == 1) {
            return nums;
        }

        int len = nums.length - k + 1;
        int[] res = new int[len];
        int num = 0;
        MyQueue queue = new MyQueue();

        for (int i = 0; i < k; i++) {
            queue.add(nums[i]);
        }
        res[num++] = queue.getMaxValue();
        for (int i = k; i < nums.length; i++) {
            queue.poll(nums[i - k]);
            queue.add(nums[i]);
            res[num++] = queue.getMaxValue();
        }
        return res;
    }

}

