package FirstExercise.string.replace;

/**
 * 剑指 Offer 05. 替换空格
 */
@SuppressWarnings("all")
public class Offer05 {
    public String replaceSpace(String s) {

        if (s == null || s.length() == 0){
            return s;
        }

        StringBuilder str = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' '){
                str.append("  ");
            }
        }

        if (str.length() == 0) {
            return s;
        }

        int left = s.length() - 1;
        s += str.toString();
        int right = s.length() - 1;
        char[] ch = s.toCharArray();
        while (left >= 0) { //%20
            if (ch[left] == ' ') {
                ch[right--] = '0';
                ch[right--] = '2';
                ch[right] = '%';
            } else {
                ch[right] = ch[left];
            }
            left--;
            right--;
        }
        return new String(ch);
    }

    public static void main(String[] args) {
        new Offer05().replaceSpace("We are happy.");
    }
}
