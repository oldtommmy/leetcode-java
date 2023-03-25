package secondExercise.array;

public class T904 {
    public int totalFruit(int[] fruits) {
        int length = fruits.length;
        int[] cnt = new int[length];
        int fast = 0, slow = 0, sum = 0, kind = 0;
        int ans = -1;
        while (fast < length) {
            cnt[fruits[fast]]++;
            sum++;
            if (cnt[fruits[fast]] == 1) {
                kind++;
            }
            while (kind > 2) {
                cnt[fruits[slow]]--;
                sum--;
                if (cnt[fruits[slow]] == 0) {
                    kind--;
                }
                slow++;
            }
            ans = Math.max(ans, sum);
        }
        return ans;
    }
}
