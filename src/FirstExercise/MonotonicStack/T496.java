package FirstExercise.MonotonicStack;

import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

class T496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        int len1 = nums1.length;
        int len2 = nums2.length;
        int[] ans = new int[len1];
        Arrays.fill(ans, -1);
        Deque<Integer> stack = new LinkedList<>();

        // key: nums1的值 value: nums2中对应的下标
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len1; i++) {
            map.put(nums1[i], i);
        }

        for (int i = 0; i < len2; i++) {
            while (!stack.isEmpty() && nums2[i] > nums2[stack.peek()]) {
                if (map.containsKey(nums2[stack.peek()])) {
                    ans[map.get(nums2[stack.peek()])] = nums2[i];
                    stack.pop();
                } else {
                    stack.pop();
                }
            }
            stack.push(i);
        }
        return ans;
    }
}