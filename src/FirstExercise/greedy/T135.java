package FirstExercise.greedy;

public class T135 {
    public int candy(int[] ratings) {

        int length = ratings.length;
        int[] candies = new int[length];
        candies[0] = 1;
        for (int i = 1; i < length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            } else {
                candies[i] = 1;
            }
        }

        for (int i = length - 2; i >= 0 ; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i + 1] + 1, candies[i]);
            }
        }

        int count = 0;
        for (int i = 0; i < length; i++) {
            count += candies[i];
        }
        return count;
    }
}
