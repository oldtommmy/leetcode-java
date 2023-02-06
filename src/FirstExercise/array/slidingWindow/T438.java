package FirstExercise.array.slidingWindow;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@SuppressWarnings({"all"})
public class T438 {
    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> list = new ArrayList<>();
        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();

        for (int i = 0; i < p.length(); i++) {
            need.put(p.charAt(i), need.getOrDefault(p.charAt(i), 0) + 1);
        }
        int left = 0, right = 0;
        int valid = 0;

        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            if (need.containsKey(c)) {
                window.put(c,window.getOrDefault(c,0) + 1);
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }

            while (right - left >= p.length()) {
                if (valid == need.size()) {
                    list.add(left);
                }
                char a = s.charAt(left);
                left++;

                if (need.containsKey(a)) {
                    if (window.getOrDefault(a,0).equals(need.get(a))) {
                        valid--;
                    }
                    window.put(a, window.getOrDefault(a,0) - 1);
                }
            }
        }
        return list;
    }
}
