package secondExercise.array;

public class T69 {
    public int mySqrt(int x) {
        if (x == 1 || x == 0) {
            return x;
        }
        int left = 0;
        int right = x;
        int mid = 0;
        while (left <= right) {
            mid = (right - left) / 2 + left;
            if (x / mid < mid) {
                right = mid - 1;
            } else if (x / mid < mid) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return left - 1;
    }
}
