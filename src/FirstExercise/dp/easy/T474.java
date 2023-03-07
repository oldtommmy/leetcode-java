package FirstExercise.dp.easy;

class T474 {
    public int findMaxForm(String[] strs, int m, int n) {

        //dp[i][j]表示在i个0 j个1的容量情况下最大子集个数
        int[][] dp = new int[m + 1][n + 1];
        int zeroCnt = 0;
        int oneCnt = 0;

        for (String str : strs) {
            zeroCnt = 0;
            oneCnt = 0;
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '0') {
                    zeroCnt++;
                } else {
                    oneCnt++;
                }
            }
            for (int i = m; i >= zeroCnt; i--) {
                for(int j = n; j >= oneCnt; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - zeroCnt][j - oneCnt] + 1);
                }
            }
        }
        return dp[m][n];
    }
}