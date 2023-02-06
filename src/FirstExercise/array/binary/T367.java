package FirstExercise.array.binary;

public class T367 {
    public boolean isPerfectSquare(int num) {
        if(num == 0 || num == 1) {
            return true;
        }

        int left = 1, right = num / 2;
        while (left <= right) {
            int mid =  left + (right - left) / 2;
            long temp = (long) mid * mid;
            if (num > temp) {
                left = mid + 1;
            } else if (num < temp) {
                right = mid - 1;
            } else {
                return  num == temp;
            }
        }
        return false;
    }

}
