package FirstExercise.string.kmp;

@SuppressWarnings({"all"})
public class T28 {
    public int strStr(String haystack, String needle) {

        int[] next = new int[needle.length()];
        getNext(needle,next);
        int j = 0;

        for (int i = 0; i < haystack.length(); i++) {
            while (j > 0 && haystack.charAt(i) != needle.charAt(j)) {
                j = next[j - 1];
            }
            if (haystack.charAt(i) == needle.charAt(j)) {
                j++;
            }
            if (j == needle.length()) {
                return i - j + 1;
            }
        }
        return -1;
    }

    /**
     * 求前缀表(不减一)
     * @param s
     * @param next
     */
    void getNext(String s, int[] next) {

        //初始化
        next[0] = 0;
        int j = 0;
        for (int i = 1; i < s.length(); i++) {

            //不相等的情况
            while (j > 0 && s.charAt(j) != s.charAt(i)) {
                j = next[j - 1];
            }
            //相等时
            if (s.charAt(j) == s.charAt(i)) {
                j++;
            }
            next[i] = j;
        }
    }
}
