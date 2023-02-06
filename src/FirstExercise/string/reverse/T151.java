package FirstExercise.string.reverse;

/**
 *  151 翻转字符串里的单词
 */
@SuppressWarnings({"all"})
public class T151 {
    public String reverseWords(String s) {

        char[] ch = s.toCharArray();

        //1.去除空格
        ch = removeExtraSpaces(ch);
        //2.反转整个字符串
        reverse(ch, 0 ,ch.length);
        //3.将每个单词反转
        reverseEachWord(ch);
        return new String(ch);
    }


    public char[] removeExtraSpaces(char[] ch) {

        int slow = 0;
        for (int fast = 0; fast < ch.length; fast++) {

            if (ch[fast] != ' ') {
                if (slow > 0) {
                    ch[slow++] = ' ';
                }
                while (fast < ch.length && ch[fast] != ' ') {
                    ch[slow++] = ch[fast++];
                }
            }
        }
        char[] newCh = new char[slow];
        System.arraycopy(ch,0,newCh,0,slow);
        return newCh;
    }

    public void reverseEachWord(char[] ch) {
        int start = 0;
        for (int i = 0; i <= ch.length; i++) {
            if (i == ch.length || ch[i] == ' '){
                reverse(ch, start, i);
                start = i + 1;
            }
        }
    }


    public void reverse(char[] ch, int begin, int end) {
        for (int i = begin, j = end - 1; i < j; i++, j--) {
            char tmp = ch[i];
            ch[i] = ch[j];
            ch[j] = tmp;
        }
    }

    public static void main(String[] args) {
        System.out.println(new T151().reverseWords("the sky is blue"));
    }
}
