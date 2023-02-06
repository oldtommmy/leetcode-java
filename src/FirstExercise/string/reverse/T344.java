package FirstExercise.string.reverse;

/**
 *  344 翻转字符串
 *  https://leetcode.cn/problems/reverse-string/
 */
@SuppressWarnings({"all"})
public class T344 {
    public void reverseString(char[] s) {

        if (s.length == 1) {
            return;
        }

        for (int i = 0,j = s.length - 1; i < j; i++,j--) {
            char tmp = s[i];
            s[i] = s[j];
            s[j] = tmp;
        }
        return;
    }
}
