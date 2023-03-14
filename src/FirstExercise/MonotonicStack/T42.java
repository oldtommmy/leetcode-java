package FirstExercise.MonotonicStack;

import java.util.Deque;
import java.util.LinkedList;

public class T42 {
    public int trap(int[] height) {

        int ans = 0;
        Deque<Integer> stack = new LinkedList<>();
        stack.push(0);
        for (int i = 1; i < height.length; i++) {
            if (height[i] < height[stack.peek()]) {
                stack.push(i);
            } else if (height[i] == height[stack.peek()]){
                stack.pop();
                stack.push(i);
            } else {
                while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                    int mid = stack.peek();
                    stack.pop();
                    if (!stack.isEmpty()) {
                        ans += (Math.min(height[stack.peek()], height[i]) - height[mid]) * (i - stack.peek() - 1);
                    }
                }
                stack.push(i);
            }
        }
        return ans;
    }
}
