package secondExercise.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class T216 {

    List<List<Integer>> ans = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    int sum = 0;

    public List<List<Integer>> combinationSum3(int k, int n) {
        backtracking(k, n, 1);
        return ans;
    }

    private void backtracking(int k, int n, int startIndex) {

        if (path.size() == k) {
            if (sum == n) {
                ans.add(new ArrayList<>(path));
                return;
            }
            return;
        }

        for (int i = startIndex; i <= 9; i++) {
            sum += i;
            path.add(i);
            backtracking(k, n, i + 1);
            sum -= i;
            path.removeLast();
        }
    }
}
