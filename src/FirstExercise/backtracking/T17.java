package FirstExercise.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 17. 电话号码的字母组合
 *
 */
public class T17 {

    ArrayList<String> result = new ArrayList<>();
    StringBuilder tmp = new StringBuilder();
    String[] dic = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};


    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return result;
        }
        backtracking(digits, 0);
        return result;
    }

    private void backtracking(String digits, int index) {
        if (index == digits.length()) {
            result.add(tmp.toString());
            return;
        }

        String letters = dic[digits.charAt(index)-'0'];
        for (int i = 0; i < letters.length(); i++) {
            tmp.append(letters.charAt(i));
            backtracking(digits, index + 1);
            tmp.deleteCharAt(tmp.length() - 1);
        }
    }
}
