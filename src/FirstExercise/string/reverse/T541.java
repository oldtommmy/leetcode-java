package FirstExercise.string.reverse;

/**
 *  541 翻转字符串 II
 *  给定一个字符串 s 和一个整数 k，从字符串开头算起，每计数至 2k 个字符，就反转这 2k 字符中的前 k 个字符。
 *  如果剩余字符少于 k 个，则将剩余字符全部反转。
 *  如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
 */
@SuppressWarnings({"all"})
public class T541 {
    public String reverseStr(String s, int k) {

        int len = s.length();
        if (len == 1) {
            return s;
        }

        char[] ch = s.toCharArray();
        for (int i = 0,j = k - 1; i < ch.length; i += (2 * k)) {

            int start = i;
            int end = Math.min(start + k - 1, len - 1); //判断剩余的字串个数是否大于k个

            while (start < end) {
                char tmp = ch[start];
                ch[start] = ch[end];
                ch[end] = tmp;
                start++;
                end--;
            }
        }
        return new String(ch);
    }
}
