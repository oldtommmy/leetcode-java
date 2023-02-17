package FirstExercise.someTips;

import java.util.ArrayList;
import java.util.List;

public class ListAndArray {
    public static void main(String[] args) {
        List<int[]> list = new ArrayList<>();
        int[][] a1 = list.toArray(new int[0][]); // list 转二维数组

        int[][] a2 = {{1,2,4},{1,2},{2,4,2,3}};

    }
}
