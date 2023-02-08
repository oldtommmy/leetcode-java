package FirstExercise.backtracking;

import java.util.*;

@SuppressWarnings({"all"})
public class T332 {

    List<String> result = new ArrayList<>();
    HashMap<String, Map<String, Integer>> map = new HashMap<>();

    public List<String> findItinerary(List<List<String>> tickets) {

        for (List<String> ticket : tickets) {
            Map<String, Integer> temp;
            if (map.containsKey(ticket.get(0))) {
                temp = map.get(ticket.get(0));
                temp.put(ticket.get(1), temp.getOrDefault(ticket.get(1), 0) + 1);
            } else {
                temp = new TreeMap<>(); //默认升序 Map
                temp.put(ticket.get(1), 1);
            }
            map.put(ticket.get(0), temp);
        }
        result.add("JFK");
        backtracking(tickets.size());
        return result;
    }

    private boolean backtracking(int ticketNum) {

        if (ticketNum + 1 == result.size()) {
            return true;
        }



        return false;
    }
}
