package FirstExercise.greedy;

public class T860 {
    public boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;
        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {
                five++;
            } else if (bills[i] == 10) {
                if (five == 0) {
                    return false;
                }
                five--;
                ten++;
            } else {
                if (ten > 0 && five >0) {
                    ten--;
                    five--;
                } else if (ten > 0) {
                    return false;
                } else {
                    five -= 3;
                }
            }
        }
        return true;
    }
}
