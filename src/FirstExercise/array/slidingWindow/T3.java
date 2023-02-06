package FirstExercise.array.slidingWindow;

@SuppressWarnings({"all"})
public class T3 {
    public int lengthOfLongestSubstring(String s) {

        if (s.length() == 0) {
            return 0;
        }
        int left = 0, right = 0;
        boolean isRepeated = false;
        int len = Integer.MIN_VALUE;
        int[] num = new int[200];

        while (right < s.length()) {

            num[s.charAt(right)]++;
            if (num[s.charAt(right)] > 1) {
                isRepeated = true;
            }
            right++;

            while (isRepeated) {
                if (num[s.charAt(left)] > 1) {
                    isRepeated = false;
                }
                num[s.charAt(left)]--;
                left++;
            }
            len = len > right - left ? len : right - left;
        }
        return len;
    }

}
