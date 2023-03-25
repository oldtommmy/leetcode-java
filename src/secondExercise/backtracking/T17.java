package secondExercise.backtracking;

import java.util.ArrayList;
import java.util.List;

public class T17 {

    String[] dic = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    StringBuilder path = new StringBuilder();
    List<String> ans = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return ans;
        }
        char[] ch = digits.toCharArray();
        backtracking(0, ch);
        return ans;
    }

    public void backtracking(int startIndex, char[] ch) {

        if (startIndex == ch.length) {
            ans.add(path.toString());
            return;
        }

        String s = dic[ch[startIndex] - '0'];
        for (int i = 0; i < s.length(); i++) {
            path.append(s.charAt(i));
            backtracking(startIndex + 1, ch);
            path.deleteCharAt(path.length() - 1);
        }
    }
}
