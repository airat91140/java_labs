package lab2;

import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, Integer> tab = Seminar.getStats("aa aaa ccc vvv bb a aa aaa");
        Seminar.printMap(tab);
    }
}
