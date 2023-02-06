package FirstExercise.array.slidingWindow;

import java.util.HashMap;

@SuppressWarnings({"all"})
public class T76 {
    public String minWindow(String s, String t) {

        HashMap<Character, Integer> need = new HashMap<>(), window = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            need.put(t.charAt(i), need.getOrDefault(t.charAt(i),0) + 1);
        }

        int left = 0, right = 0;
        int valid = 0; //窗口中满足条件的字母个数
        int start = 0, len = Integer.MAX_VALUE;

        while (right < s.length()) {
            char c = s.charAt(right);
            //扩大窗口
            right++;
            //更新window数据
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }

            //判断是否收缩窗口
            while (valid == need.size()) {
                //更新最小覆盖字串
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }

                //取元素 + 收缩
                char out = s.charAt(left);
                left++;
                //更新window数据
                if (need.containsKey(out)) {
                    if (need.get(out).equals(window.get(out))) {
                        valid--;
                    }
                    window.put(out, window.get(out) - 1);
                }
            }
        }
        // 返回最小覆盖子串
        return len == Integer.MAX_VALUE ?
                "" : s.substring(start, len);
    }
}
