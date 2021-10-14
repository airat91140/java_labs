package lab2;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Seminar {
    public static Map<String, Integer> getStats(String str) {
        if (str == null)
            return null;
        Map<String, Integer> table = new HashMap<>();
        String[] words = str.split(" ");
        for (String iter : words) {
            Integer val = table.putIfAbsent(iter, 1);
            if (val != null)
                table.put(iter, val + 1);
        }
        return table;
    }

    public static void printMap(Map<String, Integer> table) {
        if (table == null)
            return;
        Set<String> keys = table.keySet();
        for (String iter : keys) {
            System.out.println(iter + " " + table.get(iter));
        }
    }
}
