package FirstExercise.hashtable.sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *   18. 四数之和
 *   https://leetcode.cn/problems/4sum/
 */
@SuppressWarnings({"all"})
public class T18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {

        ArrayList<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        int len = nums.length;

        for (int i = 0; i < len; i++) {
            if (nums[i] > target && target > 0) { //剪枝
                return ans;
            }

            if (i > 0 && nums[i] == nums[i - 1]) { //去重
                continue;
            }

            for (int j = i + 1; j < len; j++) {

                if (j > i + 1 && nums[j] == nums[j - 1]) {//剪枝
                    continue;
                }

                int left = j + 1;
                int right = len - 1;
                while (left < right) {
                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum < target) {
                        left++;
                    } else if (sum > target) {
                        right--;
                    } else {
                        ans.add(Arrays.asList(nums[i] , nums[j], nums[left], nums[right]));
                        while (right > left && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        while (right > left &&nums[left] == nums[left + 1]) {
                            left++;
                        }
                        right--;
                        left++;
                    }
                }
            }
        }
        return ans;
    }
}
