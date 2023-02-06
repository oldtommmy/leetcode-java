package FirstExercise.hashtable.sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *  15. 三数之和
 *  https://leetcode.cn/problems/3sum/
 *  不适合使用 hash 法 使用双指针
 */
@SuppressWarnings({"all"})
public class T15 {
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return ans;
        }

        int sum = 0;
        int len = nums.length;

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                break;
            }

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = len - 1;
            while (left < right) {
                sum = nums[left] + nums[i] + nums[right];
                if (sum > 0) {
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    ans.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[right] == nums[right-1]) {
                        right--;
                    }
                    while (left < right && nums[left] == nums[left+1]) {
                        left++;
                    }
                    left++;
                    right--;
                }
            }
        }
        return ans;
    }
}
