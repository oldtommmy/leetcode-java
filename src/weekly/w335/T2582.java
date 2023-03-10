package weekly.w335;

public class T2582 {
    public int passThePillow(int n, int time) {
        if (n == 1) {
            return 1;
        }
        int turn = time / (n - 1);
        int left = time % (n - 1);
        if (turn % 2 == 0) {
            return 1 + left;
        }
        return n - left;
    }
}
