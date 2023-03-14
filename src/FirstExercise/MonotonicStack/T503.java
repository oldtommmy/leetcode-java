package FirstExercise.MonotonicStack;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class T503 {
    public int[] nextGreaterElements(int[] nums) {

        int length = nums.length;
        int[] ans = new int[length];
        Arrays.fill(ans, -1);
        Deque<Integer> stack = new LinkedList<>();
        
        stack.push(0);
        for (int i = 1; i < 2 * length; i++) {
            if (nums[i % length] <= nums[stack.peek() % length]) {
                stack.push(i);
            } else {
                while (!stack.isEmpty() && nums[i % length] > nums[stack.peek() % length]) {
                    ans[stack.peek() % length] = nums[i % length];
                    stack.pop();
                }
                stack.push(i);
            }
        }
        return ans;
    }
}
