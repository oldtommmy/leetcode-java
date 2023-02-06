package FirstExercise.array.slidingWindow;

@SuppressWarnings({"all"})
public class T904 {
    public int totalFruit(int[] fruits) {

        int sum = 0; //种类
        int begin = 0, end = 0;
        int len = 0;
        int[] window = new int[fruits.length];

        while (end < fruits.length) { //遍历数组

            if (window[fruits[end]] == 0) { //更新窗口
                sum++;
            }
            window[fruits[end]]++;
            end++;

            while (sum > 2) { //种类数大于2时 开始收缩窗口
                window[fruits[begin]]--;
                if (window[fruits[begin]] == 0) {
                    sum--;
                }
                begin++;
            }
            len = len > end - begin  ? len : end - begin;
        }
        return len;
    }
}
