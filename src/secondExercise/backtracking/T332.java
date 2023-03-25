package secondExercise.backtracking;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class T332 {

    List<String> ans = new LinkedList<>();
    LinkedList<String> path = new LinkedList<>();
    boolean[] isVisited;

    public List<String> findItinerary(List<List<String>> tickets) {
        Collections.sort(tickets, (a, b) -> a.get(1).compareTo(b.get(1)));
        isVisited = new boolean[tickets.size()];
        path.add("JFK");
        backtracking(tickets);
        return ans;
    }

    public boolean backtracking(List<List<String>> tickets) {
        if (path.size() == tickets.size() + 1) {
            ans = new LinkedList<>(path);
            return true;
        }

        for (int i = 0; i < tickets.size(); i++) {
            List<String> ticket = tickets.get(i);
            if (!ticket.get(0).equals(path.getLast()) || isVisited[i]) {
                continue;
            }

            isVisited[i] = true;
            path.add(ticket.get(1));
            if (backtracking(tickets)) {
                return true;
            }
            isVisited[i] = false;
            path.removeLast();
        }
        return false;
    }
}
