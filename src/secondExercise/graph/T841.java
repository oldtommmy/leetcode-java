package secondExercise.graph;

import java.util.List;
import java.util.Scanner;

public class T841 {

    boolean[] isVisited;
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Scanner scanner = new Scanner(System.in);
        isVisited = new boolean[rooms.size()];
        dfs(rooms, 0);
        for (int i = 0; i < isVisited.length; i++) {
            if (!isVisited[i]){
                return false;
            }
        }
        return true;
    }

    public void dfs(List<List<Integer>> rooms, int index) {
        if (isVisited[index]) {
            return;
        }

        isVisited[index] = true;
        List<Integer> list = rooms.get(index);
        for (int i = 0; i < list.size(); i++) {
            dfs(rooms, list.get(i));
        }
    }
}
