package secondExercise.twoPointers;

public class T844 {
    public boolean backspaceCompare(String s, String t) {

        int sp = s.length() - 1;
        int skipS = 0;
        int tp = t.length() - 1;
        int skipT = 0;
        while (sp >= 0 || tp >= 0) {

            while (sp >= 0) {
                if (s.charAt(sp) == '#') {
                    skipS++;
                    sp--;
                } else if (skipS != 0) {
                    skipS--;
                    sp--;
                } else {
                    break;
                }
            }

            while (tp >= 0) {
                if (t.charAt(tp) == '#') {
                    tp--;
                    skipT++;
                } else if (skipT != 0) {
                    skipT--;
                    tp--;
                } else {
                    break;
                }
            }

            if (tp >= 0 && sp >= 0) {
                if (s.charAt(sp) != t.charAt(tp)) {
                    return false;
                }
                tp--;
                sp--;
            } else if (tp < 0 && sp < 0) {
                return true;
            } else {
                return false;
            }

        }
        return true;
    }
}
