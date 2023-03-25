package secondExercise.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T39 {

    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    int sum = 0;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtracking(candidates, target, 0);
        return ans;
    }

    public void backtracking(int[] candidates, int target, int startIndex) {

        if (sum == target) {
            ans.add(new ArrayList<>(path));
            return;
        }

        for (int i = startIndex; i < candidates.length && sum + candidates[i] <= target; i++){
            path.add(candidates[i]);
            sum += candidates[i];
            backtracking(candidates, target, i);
            sum -= candidates[i];
            path.remove(path.size() - 1);
        }
    }
}
