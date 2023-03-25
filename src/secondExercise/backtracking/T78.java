package secondExercise.backtracking;

import java.util.ArrayList;
import java.util.List;

public class T78 {

    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        ans.add(new ArrayList<>());
        backtracking(0, nums);
        return ans;
    }

    public void backtracking(int index, int[] nums) {

        if (index == nums.length) {
            return;
        }

        for (int i = index; i < nums.length; i++) {
            path.add(nums[i]);
            ans.add(new ArrayList<>(path));
            backtracking(i + 1, nums);
            path.remove(path.size() - 1);
        }
    }
}
