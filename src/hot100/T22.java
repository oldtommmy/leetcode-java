package hot100;

import java.util.*;

public class T22 {

    List<String> ans = new ArrayList<>();
    StringBuilder path = new StringBuilder();
    public List<String> generateParenthesis(int n) {
        int[] nums = new int[2];
        nums[0] = n; //left
        nums[1] = n; //right
        backtracking(nums, n);
        return ans;
    }

    public void backtracking(int[] nums, int n) {

        if (path.length() == n * 2) {
            ans.add(path.toString());
            return;
        }

        for (int i = 0; i < 2; i++) {
            if (nums[i] == 0 || (i == 1 && nums[1] == nums[0])){
                continue;
            }
            nums[i]--;
            path.append(i == 0 ? '(' : ')');
            backtracking(nums, n);
            nums[i]++;
            path.deleteCharAt(path.length() - 1);
        }
    }

}
