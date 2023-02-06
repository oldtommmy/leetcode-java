package FirstExercise.string.reverse;

/**
 *  剑指 Offer 58 - II. 左旋转字符串
 */
@SuppressWarnings({"all"})
public class Offer58 {
    /**
     * 不使用 substring()
     * @param s
     * @param n
     * @return
     */
    public String reverseLeftWords(String s, int n) {
        char[] ch = s.toCharArray();
        reverse(ch,0,n);
        reverse(ch,n,ch.length);
        reverse(ch,0,ch.length);
        return new String(ch);
    }

    public void reverse(char[] ch, int begin, int end) {
        for (int i = begin, j = end - 1; i < j; i++, j--) {
            char tmp = ch[i];
            ch[i] = ch[j];
            ch[j] = tmp;
        }
    }


    /** 空间复杂度 O(n)
     * public String reverseLeftWords(String s, int n) {
     *         char[] ch = new char[s.length() + n];
     *         System.arraycopy(s.toCharArray(),0,ch,0,s.length());
     *         for (int i = 0, j = s.length(); i < n; i++,j++) {
     *             ch[j] = ch[i];
     *         }
     *         return new String(ch).substring(n);
     *     }
     */
}
