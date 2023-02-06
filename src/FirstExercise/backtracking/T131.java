package FirstExercise.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class T131 {

    List<List<String>> result = new ArrayList<>();
    LinkedList<String> path = new LinkedList<>();


    public List<List<String>> partition(String s) {
        backtracking(s, 0);
        return result;
    }

    private void backtracking(String s, int startIndex) {

        //终止条件
        if (startIndex >= s.length()) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = startIndex; i < s.length(); i++) {
            String substring = s.substring(startIndex, i + 1);
            if (!isPalindrome(substring)) {
                continue;
            }
            path.add(substring);
            backtracking(s, i + 1);
            path.removeLast();
        }
    }

    private boolean isPalindrome(String s) {
        char[] ch = s.toCharArray();
        for (int i = 0, j = ch.length - 1; i < j; i++, j--) {
            if (ch[i] != ch[j]) {
                return false;
            }
        }
        return true;
    }
}
