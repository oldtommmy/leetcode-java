package hot100;

public class T9 {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int y = 0;
        int tmp = x;
        while (tmp != 0) {
            y = y * 10 + tmp % 10;
            tmp = tmp / 10;
        }
        if (y != x) {
            return false;
        }
        return true;
    }
}
