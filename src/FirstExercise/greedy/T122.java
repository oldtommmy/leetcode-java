package FirstExercise.greedy;

public class T122 {

    public int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            profit += Math.max((prices[i + 1] - prices[i]), 0);
        }
        return profit;
    }
}
