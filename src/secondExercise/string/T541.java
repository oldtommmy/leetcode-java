package secondExercise.string;

public class T541 {
    public String reverseStr(String s, int k) {
        //如果剩余字符少于 k 个，则将剩余字符全部反转。
        //如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
        char[] ch = s.toCharArray();
        for (int i = 0; i < ch.length; i += (2 * k)) {
            int start = i;
            int end = Math.min(ch.length - 1, start + k - 1);
            while (start < end) {
                char c = ch[start];
                ch[start] = ch[end];
                ch[end] = c;
                start++;
                end--;
            }
        }
        return new String(ch);
    }
}
