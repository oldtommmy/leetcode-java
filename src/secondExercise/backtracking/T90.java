package secondExercise.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T90 {

    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    boolean[] isVisited;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        ans.add(new ArrayList<>());
        isVisited = new boolean[nums.length];
        Arrays.sort(nums);
        backtracking(0, nums);
        return ans;
    }

    public void backtracking(int index, int[] nums) {

        if (index == nums.length) {
            return;
        }

        for (int i = index; i < nums.length; i++) {
            if (i > 0 && !isVisited[i - 1] && nums[i - 1] == nums[i]) {
                continue;
            }
            path.add(nums[i]);
            isVisited[i] = true;
            ans.add(new ArrayList<>(path));
            backtracking(i + 1, nums);
            isVisited[i] = false;
            path.remove(path.size() - 1);
        }
    }
}
