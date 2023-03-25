package secondExercise.hash;

import java.util.HashSet;

public class T202 {
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        while (true) {
            int sum = count(n);
            if (sum == 1) {
                return true;
            }
            if (!set.contains(sum)) {
                set.add(sum);
            } else {
                return false;
            }
            n = sum;
        }
    }

    public int count(int n) {
        int sum = 0;
        while (n > 0) {
            sum += (n % 10) * (n % 10);
            n /= 10;
        }
        return sum;
    }
}
