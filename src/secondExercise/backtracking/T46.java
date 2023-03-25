package secondExercise.backtracking;

import java.util.ArrayList;
import java.util.List;

public class T46 {

    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    boolean[] isVisited;

    public List<List<Integer>> permute(int[] nums) {
        isVisited = new boolean[nums.length];
        backtracking(nums);
        return ans;
    }

    public void backtracking(int[] nums) {

        if (path.size() == nums.length) {
            ans.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (isVisited[i]) {
                continue;
            }
            path.add(nums[i]);
            isVisited[i] = true;
            backtracking(nums);
            isVisited[i] = false;
            path.remove(path.size() - 1);
        }
    }

//    public static void main(String[] args) {
//        System.out.println(new T46().permute(new int[]{1,2,3}));
//    }

}
