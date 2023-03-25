package secondExercise.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class T131 {

    List<List<String>> ans = new ArrayList<>();
    List<String> path = new ArrayList<>();

    public List<List<String>> partition(String s) {
        backtracking(0, s);
        return ans;
    }

    public void backtracking(int startIndex, String s) {

        if (startIndex == s.length()) {
            ans.add(new ArrayList<>(path));
            return;
        }

        for (int i = startIndex; i < s.length(); i++) {
            String substring = s.substring(startIndex, i + 1);
            if (check(substring)) {
                path.add(substring);
            } else {
                continue;
            }
            backtracking(i + 1, s);
            path.remove(path.size() - 1);
        }
    }

    public boolean check(String s) {
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}
