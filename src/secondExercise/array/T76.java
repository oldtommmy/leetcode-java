package secondExercise.array;

public class T76 {
    public String minWindow(String s, String t) {

        if (t.length() > s.length()) {
            return "";
        }

        int[] need = new int[128];
        for (int i = 0; i < t.length(); i++) {
            need[t.charAt(i)]++;
        }

        int fast = 0, slow = 0, start = 0;
        int count = t.length();
        int len = Integer.MAX_VALUE;
        while (fast < s.length()) {
            int i = need[s.charAt(fast)];
            if (i > 0) {
                count--;
            }
            need[s.charAt(fast)]--;
            if (count == 0) {
                while (need[s.charAt(slow)] < 0) {
                    need[s.charAt(slow)]++;
                    slow++;
                }

                if (len > fast - slow + 1) {
                    start = slow;
                    len = fast - slow + 1;
                }
            }
            fast++;
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }
}
