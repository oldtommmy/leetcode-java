package secondExercise.string;

public class T151 {
    public String reverseWords(String s) {
        StringBuilder stringBuilder = new StringBuilder(deleteSpace(s));
        reverseEveryWord(stringBuilder);
        return stringBuilder.reverse().toString();
    }

    public String deleteSpace(String s) {
        StringBuilder builder = new StringBuilder();
        int start = 0;
        int end = s.length() - 1;
        while (s.charAt(start) == ' ') start++;
        while (s.charAt(end) == ' ') end--;
        while (start <= end) {
            if (s.charAt(start) != ' ' || builder.charAt(builder.length() - 1) != ' ') {
                builder.append(s.charAt(start));
            }
        }
        return builder.toString();

    }

    public StringBuilder reverseEveryWord(StringBuilder builder) {
        StringBuilder stringBuilder = new StringBuilder();
        String[] split = builder.toString().split(" ");
        for (String s : split) {
            stringBuilder.append(new StringBuilder(s).reverse());
        }
        return stringBuilder;
    }
}
