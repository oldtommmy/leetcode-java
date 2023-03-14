package FirstExercise.MonotonicStack;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class T739 {
    public int[] dailyTemperatures(int[] temperatures) {

        int length = temperatures.length;
        int[] ans = new int[length];
        Arrays.fill(ans, 0);
        Deque<Integer> stack = new LinkedList<>();
        stack.push(0);
        for (int i = 1; i < length; i++) {
            if (temperatures[i] <= temperatures[stack.peek()]) {
                stack.push(i);
            } else {
                while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                    ans[stack.peek()] = i - stack.peek();
                    stack.pop();
                }
                stack.push(i);
            }
        }
        return ans;
    }
}
