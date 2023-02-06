package FirstExercise.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class T39 {

    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    int sum = 0;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtracking(candidates, target, 0);
        return result;
    }

    private void backtracking(int[] candidates, int target, int startIndex) {

        if (sum == target) {
            result.add(new ArrayList<>(path));
        }

        for (int i = startIndex; i < candidates.length && sum + candidates[i] <= target; i++) {
            sum += candidates[i];
            path.add(candidates[i]);
            backtracking(candidates, target, i);
            sum -= candidates[i];
            path.removeLast();
        }
    }
}
