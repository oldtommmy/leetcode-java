package FirstExercise.hashtable.anagram;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *      438. 找到字符串中所有字母异位词
 *      https://leetcode.cn/problems/find-all-anagrams-in-a-string/
 *      -- sliding window --
 */

@SuppressWarnings({"all"})
public class T438 {
    public List<Integer> findAnagrams(String s, String p) {

        ArrayList<Integer> ans = new ArrayList<>();
        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();

        int valid = 0;
        int left = 0, right = 0;
        for (char c : p.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        while (right < s.length()) {
            char c = s.charAt(right);
            right++;

            //增大window
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }

            //缩小window
            while (right - left >= p.length()) {
                if (valid == need.size()) {
                    ans.add(left);
                }
                char a = s.charAt(left);
                left++;

                if (need.containsKey(a)) {
                    if (need.get(a).equals(window.get(a))) {
                        valid--;
                    }
                    window.put(a, window.getOrDefault(a, 0) - 1);
                }
            }
        }
        return ans;
    }
}
