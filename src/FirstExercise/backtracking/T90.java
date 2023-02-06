package FirstExercise.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class T90 {

    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    boolean[] used;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        used = new boolean[nums.length];
        Arrays.sort(nums);
        result.add(new ArrayList<>());
        backtracking(nums, 0);
        return result;
    }

    private void backtracking(int[] nums, int beginIndex) {

        if (beginIndex == nums.length) {
            return;
        }

        for (int i = beginIndex; i < nums.length; i++) {

            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }

            used[i] = true;
            path.add(nums[i]);
            result.add(new ArrayList<>(path));
            backtracking(nums, i + 1);
            used[i] = false;
            path.removeLast();
        }
    }

}
