package FirstExercise.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class T78 {

    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> subsets(int[] nums) {
        backtracking(nums, 0);
        return result;
    }

    private void backtracking(int[] nums, int startIndex) {

        if (startIndex > nums.length - 1) {

        }
    }
}
