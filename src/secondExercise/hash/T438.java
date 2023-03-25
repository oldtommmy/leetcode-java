package secondExercise.hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T438 {
    public List<Integer> findAnagrams(String s, String p) {

        ArrayList<Integer> ans = new ArrayList<>();
        int[] cnt = new int[26];
        for (int i = 0; i < p.length(); i++) {
            cnt[p.charAt(i) - 'a']++;
        }
        int[] window = new int[26];
        int start = 0;
        int end = 0;
        while (end < s.length()) {
            window[s.charAt(end) - 'a']++;
            if (end - start + 1 == p.length()){
                if (Arrays.equals(window, cnt)){
                    ans.add(start);
                }
                window[s.charAt(start) - 'a']--;
                start++;
            }
            end++;
        }
        return ans;
    }
}
