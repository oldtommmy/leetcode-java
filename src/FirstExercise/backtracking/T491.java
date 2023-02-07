package FirstExercise.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


public class T491 {

    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();


    public List<List<Integer>> findSubsequences(int[] nums) {
        backtracking(nums, 0);
        return result;
    }

    private void backtracking(int[] nums, int beginIndex) {

        if (path.size() > 1) {
            result.add(new ArrayList<>(path));
        }

        boolean[] used = new boolean[201];
        Arrays.fill(used, false);
        for (int i = beginIndex; i < nums.length; i++) {

            if (!path.isEmpty() && nums[i] < path.getLast() || used[nums[i] + 100]) {
                continue;
            }
            path.add(nums[i]);
            used[nums[i] + 100] = true;
            backtracking(nums, i + 1);
            path.removeLast();
        }
    }
}
