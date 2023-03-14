package FirstExercise.MonotonicStack;

import java.util.Stack;

public class T84 {
    public int largestRectangleArea(int[] heights) {

        int[] newHeight = new int[heights.length + 2];
        newHeight[0] = 0;
        newHeight[heights.length + 1] = 0;
        for (int i = 1; i < heights.length + 1; i++) {
            newHeight[i] = heights[i - 1];
        }

        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int ans = 0;

        for (int i = 1; i < newHeight.length; i++) {
            if (newHeight[i] > newHeight[stack.peek()]) {
                stack.push(i);
            } else if (newHeight[i] == newHeight[stack.peek()]) {
                stack.pop();
                stack.push(i);
            } else {
                while (!stack.isEmpty() && newHeight[i] < newHeight[stack.peek()]) {
                    Integer mid = stack.peek();
                    stack.pop();
                    Integer left = stack.peek();
                    int temp = (i - left - 1) * newHeight[mid];
                    ans = Math.max(ans, temp);
                }
                stack.push(i);
            }
        }
        return ans;
    }
}
