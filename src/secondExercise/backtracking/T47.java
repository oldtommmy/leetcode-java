package secondExercise.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T47 {

    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    boolean[] isVisited;

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        isVisited = new boolean[nums.length];
        backtracking(nums);
        return ans;
    }

    public void backtracking(int[] nums) {

        if (path.size() == nums.length) {
            ans.add(new ArrayList<>(path));
            return;
        }

        boolean[] hash = new boolean[21];
        for (int i = 0; i < nums.length; i++) {
            if (isVisited[i] || hash[nums[i] + 10]) {
                continue;
            }
            path.add(nums[i]);
            hash[nums[i] + 10] = true;
            isVisited[i] = true;
            backtracking(nums);
            isVisited[i] = false;
            path.remove(path.size() - 1);
        }
    }

//    public static void main(String[] args) {
//        System.out.println(new T47().permuteUnique(new int[]{1,1,4,2}));
//    }
}
