package FirstExercise.dp.easy;

public class T392 {
    public boolean isSubsequence(String s, String t) {

    }


    /**
     * 使用动态规划
     * @param s s
     * @param t t
     * @return boolean
     */
    private boolean byDp(String s, String t) {

    }


    /**
     * 使用双指针
     * @param s s
     * @param t t
     * @return boolean
     */
    private boolean byTwoPoint(String s, String t) {
        int i, j;
        for (i = 0, j = 0; i < s.length() && j < t.length(); ) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
                j++;
            } else {
                j++;
            }
        }
        if (i == s.length() - 1) {
            return true;
        }
        return false;
    }
}
