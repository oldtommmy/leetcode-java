package FirstExercise.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *  216. 组合总和 III
 *  找出所有相加之和为 n 的 k 个数的组合，且满足下列条件：
 *  - 只使用数字1到9
 *  - 每个数字 最多使用一次
 */
public class T216 {

    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    int sum = 0;
    public List<List<Integer>> combinationSum3(int k, int n) {
        backtracking(k, n, 1);
        return result;
    }

    private void backtracking(int k, int n, int startIndex) {
        if (path.size() == k) {
            if (sum == n) {
                result.add(new ArrayList<>(path));
            }
            return;
        }

        for (int i = startIndex; i <= 9; i++) {
            path.add(i);
            sum += i;
            backtracking(k, n, i + 1);
            path.removeLast();
            sum -= i;
        }
    }
}
