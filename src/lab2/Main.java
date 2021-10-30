package lab2;

import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, Integer> tab = Seminar.getStats("aa aaa ccc vvv bb a aa aaa");
        Seminar.printMap(tab);

        MyList lst1 = new MyList(), lst2 = new MyList();
        lst1.add(0);
        lst1.add(2);
        lst1.add(4);
        lst1.add(6);

        lst2.add(1);
        lst2.add(3);
        lst2.add(5);
        lst2.add(7);

        System.out.println(lst1);
        System.out.println(lst2);
        System.out.println(MyList.merge(lst1, lst2));

    }
}
