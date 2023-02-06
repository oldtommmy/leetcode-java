package FirstExercise.array.removeElements;

@SuppressWarnings({"all"})
public class T844 {
    public boolean backspaceCompare(String s, String t) {

        int skipS = 0, skipT = 0;
        int i = s.length() - 1, j = t.length() - 1;

        while (i >= 0 || j >= 0) {

            while (i >= 0) {
                if (s.charAt(i) == '#') {
                    skipS++;
                    i--;
                } else if (skipS > 0) {
                    i--;
                    skipS--;
                } else {
                    break;
                }
            }

            while (j >= 0) {
                if (t.charAt(j) == '#') {
                    skipT++;
                    j--;
                } else if (skipT > 0) {
                    j--;
                    skipT--;
                } else {
                    break;
                }
            }

            if (i >=0 && j >= 0) {
                if (s.charAt(i) != t.charAt(j)) {
                    return false;
                }
                i--;
                j--;
            } else if (i < 0 && j < 0) {
                return true;
            }else {
                return false;
            }
        }
        return true;
    }
}
