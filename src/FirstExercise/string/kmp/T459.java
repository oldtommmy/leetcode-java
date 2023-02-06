package FirstExercise.string.kmp;

@SuppressWarnings({"all"})
public class T459 {
    public boolean repeatedSubstringPattern(String s) {

        char[] ch = s.toCharArray();
        int len = ch.length;
        int[] next = new int[len];


        int j = 0;
        next[0] = 0;
        for (int i = 1; i < len; i++) {
            while (j > 0 && ch[j] != ch[i]) {
                j = next[j - 1];
            }
            if (ch[j] == ch[i]) {
                j++;
            }
            next[i] = j;
        }

        if (next[len - 1] != 0 && len % (len - next[len - 1]) == 0) {
            return true;
        }
        return false;
    }
}
