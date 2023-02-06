package FirstExercise.backtracking;

import java.util.ArrayList;
import java.util.List;

public class T93 {

    List<String> result = new ArrayList<>();
    StringBuilder builder = new StringBuilder();
    int ipCount = 0;

    public List<String> restoreIpAddresses(String s) {
        backtracking(s, 0);
        return result;
    }

    private void backtracking(String s, int index) {

        if (index == s.length() && ipCount == 4) {
            result.add(builder.toString());
            return;
        }

        if (index == s.length() || ipCount == 4) {
            return;
        }


        //剪枝：限制ip段位数 ip段大小限制在[0,255]
        for (int i = index; i < s.length() && i - index < 3
                && Integer.parseInt(s.substring(index, i + 1)) >= 0
                && Integer.parseInt(s.substring(index, i + 1)) <= 255; i++) {
            if (i - index + 1 > 1 && s.charAt(index) == '0') {
                continue;
            }

            builder.append(s.substring(index, i + 1));
            if (ipCount < 3) {
                builder.append('.');
            }
            ipCount++;
            backtracking(s, i + 1);
            ipCount--;
            builder.delete(index + ipCount, builder.length());
        }
    }

}
