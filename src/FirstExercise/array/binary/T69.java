package FirstExercise.array.binary;

@SuppressWarnings({"all"})
public class T69 {
    public int mySqrt(int x) {

        if(x == 0 || x == 1) {
            return x;
        }

        int left = 1, right = x / 2;
        while (left <= right) {
            int mid =  left + (right - left) / 2;
            if (x / mid > mid) {
                left = mid + 1;
            } else if (x / mid < mid) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return right;
    }
}
