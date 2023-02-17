package FirstExercise.greedy;

public class T738 {
    public int monotoneIncreasingDigits(int n) {

        char[] ch = String.valueOf(n).toCharArray();
        int start = ch.length;
        for (int i = ch.length - 2; i >= 0; i--) {
            if (ch[i] > ch[i + 1]) {
                ch[i]--;
                start = i + 1;
            }
        }
        for (int i = start; i < ch.length; i++) {
            ch[i] = '9';
        }
        return Integer.parseInt(String.valueOf(ch));
    }
}
