package FirstExercise.hashtable.happynumber;

import java.util.HashSet;

/**
 *  202. 快乐数
 */
@SuppressWarnings({"all"})
public class T202 {
    public boolean isHappy(int n) {

        HashSet<Integer> set = new HashSet<>();

        while (n != 1 && !set.contains(n)) {
            set.add(n);
            n = getNextNum(n);
        }

        return n == 1;
    }

    public int getNextNum(int n) {
        int next = 0;
        while (n > 0) {
            next += (n % 10) * (n % 10);
            n = (n - n % 10) / 10;
        }
        return next;
    }
}
