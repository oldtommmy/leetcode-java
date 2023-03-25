package secondExercise.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T40 {

    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    int sum = 0;
    boolean[] isUsed;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        isUsed = new boolean[candidates.length];
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

            if (i > 0 && !isUsed[i - 1] && candidates[i - 1] == candidates[i]) {
                continue;
            }
            isUsed[i] = true;
            path.add(candidates[i]);
            sum += candidates[i];
            backtracking(candidates, target, i + 1);
            isUsed[i] = false;
            sum -= candidates[i];
            path.remove(path.size() - 1);
        }
    }
}
