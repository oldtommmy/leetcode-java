package FirstExercise.extra.array;

import java.util.Arrays;

public class T1365 {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        return byHash(nums);
    }

    private int[] violent(int[] nums) {
        int length = nums.length;
        int[] ans = new int[length];

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (nums[j] < nums[i]) {
                    ans[i]++;
                }
            }
        }
        return ans;
    }

    private int[] byHash(int[] nums) {

        int[] ans = Arrays.copyOf(nums, nums.length);
        Arrays.sort(ans);
        int[] hash = new int[101];
        Arrays.fill(hash, -1);

        for (int i = 0; i < ans.length; i++) {
            if (hash[ans[i]] == -1) {
                hash[ans[i]] = i;
            }
        }

        for (int i = 0; i < ans.length; i++) {
            ans[i] = hash[nums[i]];
        }
        return ans;
    }
}
