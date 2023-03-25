package secondExercise.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class T491 {

    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        backtracking(0, nums);
        return ans;
    }

    public void backtracking(int index, int[] nums) {

        if (index == nums.length) {
            return;
        }

        boolean[] set = new boolean[201];
        for (int i = index; i < nums.length; i++) {

            if (set[nums[i] + 100]) {
                continue;
            }
            if (path.size() > 0 && nums[i] < path.get(path.size() - 1)) {
                continue;
            }
            set[nums[i] + 100] = true;
            path.add(nums[i]);

            if (path.size() > 1) {
                ans.add(new ArrayList<>(path));
            }
            backtracking(i + 1, nums);
            path.remove(path.size() - 1);
        }
    }
}
