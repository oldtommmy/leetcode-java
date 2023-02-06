package FirstExercise.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class T40 {

    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    boolean[] used;
    int sum = 0;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        used = new boolean[candidates.length];
        Arrays.fill(used, false);
        Arrays.sort(candidates);
        backtracking(candidates, target, 0);
        return result;
    }

    private void backtracking(int[] candidates, int target, int startIndex) {
        if (sum == target) {
            result.add(new ArrayList(path));
            return;
        }

        for (int i = startIndex; i < candidates.length && sum + candidates[i] <= target; i++) {

            if (i > 0 && candidates[i] == candidates[i - 1] && !used[i - 1]) {
                continue;
            }
            sum += candidates[i];
            used[i] = true;
            path.add(candidates[i]);
            backtracking(candidates, target, i + 1);
            sum -= candidates[i];
            used[i] = false;
            path.removeLast();
        }
    }
}
