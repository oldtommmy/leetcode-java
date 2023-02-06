package FirstExercise.hashtable.sum;

import java.util.HashMap;

/**
 *  1 两数之和
 *  https://leetcode.cn/problems/two-sum/
 */

@SuppressWarnings({"all"})
public class T1 {
    public int[] twoSum(int[] nums, int target) {

        int[] ans = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                ans[0] = i;
                ans[1] = map.get(target - nums[i]);
            }
            map.put(nums[i], i);
        }
        return ans;
    }
}
