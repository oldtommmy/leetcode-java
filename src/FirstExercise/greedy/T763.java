package FirstExercise.greedy;

import java.util.ArrayList;
import java.util.List;

public class T763 {

    public List<Integer> partitionLabels(String s) {

        ArrayList<Integer> result = new ArrayList<>();
        char[] ch = s.toCharArray();
        int[] position = new int[27];
        int start = 0;
        int end = 0;
        for (int i = 0; i < ch.length; i++) {
            position[ch[i] - 'a'] = i;
        }

        for (int i = 0; i < ch.length; i++) {
            end = Math.max(position[ch[i] - 'a'], end);
            if (i == end) {
                result.add(end - start + 1);
                start = i + 1;
            }
        }
        return result;
    }
}
