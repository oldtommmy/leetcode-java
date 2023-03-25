package secondExercise.array;

public class T367 {
    public boolean isPerfectSquare(int num) {

        if (num == 0 || num == 1) {
            return true;
        }

        int left = 0;
        int right = num;
        int mid = 1;
        while (left <= right) {
            mid = (right - left) / 2 + left;
            if (num / mid > mid) {
                left = mid + 1;
            } else if (num / mid < mid) {
                right = mid - 1;
            } else {
                if ((long) mid * mid == num) {
                    return true;
                }
                return false;
            }
        }
        return false;
    }
}
