package secondExercise.backtracking;

import java.util.ArrayList;
import java.util.List;

public class T93 {

    List<String> ans = new ArrayList<>();
    StringBuilder builder = new StringBuilder();
    int cnt = 0; //记录ip段
    public List<String> restoreIpAddresses(String s) {
        backtracking(0, s);
        return ans;
    }

    public void backtracking(int startIndex, String s) {

        if (cnt == 4 && startIndex == s.length()) {
            ans.add(builder.toString());
            return;
        }

        if (cnt == 4 || startIndex == s.length()) {
            return;
        }

        for (int i = startIndex; i < s.length() && i - startIndex < 3
                && Integer.parseInt(s.substring(startIndex, i + 1)) <= 255
                && Integer.parseInt(s.substring(startIndex, i + 1)) >= 0; i++) {

            if (i - startIndex + 1 > 1 && s.charAt(startIndex) == '0') {
                continue;
            }

            builder.append(s.substring(startIndex, i + 1));
            if (cnt < 3) {
                builder.append('.');
            }
            cnt++;
            backtracking(i + 1, s);
            cnt--;
            builder.delete(startIndex + cnt, i + cnt + 2);
        }

    }

}
