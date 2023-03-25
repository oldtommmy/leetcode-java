package secondExercise.queueAndStack;

import java.util.ArrayDeque;
import java.util.Deque;

public class T239 {

    class MyQueue{
        Deque<Integer> queue = new ArrayDeque<>();

        void add(int i) {
            while (!queue.isEmpty() && i > queue.peekLast()) {
                queue.removeLast();
            }
            queue.addLast(i);
        }

        void poll(int val) {
            if (!queue.isEmpty() && queue.peekFirst() == val) {
                queue.poll();
            }
        }

        int peek() {
           return queue.peekFirst();
        }
    }

    public int[] maxSlidingWindow(int[] nums, int k) {

        int[] ans = new int[nums.length - k + 1];
        MyQueue queue = new MyQueue();

        for (int i = 0; i < k; i++) {
            queue.add(nums[i]);
        }
        ans[0] = queue.peek();

        for (int i = k; i < nums.length; i++) {
            queue.poll(nums[i - k]);
            queue.add(nums[i]);
            ans[i - k + 1] = queue.peek();
        }
        return ans;
    }
}
