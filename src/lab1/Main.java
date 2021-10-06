package lab1;

import lab1.*;

public class Main {
    public static void main(String []args) {
        MyList list = new MyList();
        list.add(null);
        list.add(1);
        list.add(null);
        list.add(2);
        list.add(null);
        list.add(3);
        System.out.println(list);

        System.out.println(list.get(2));
        System.out.println(list.get(null));

        list.remove(1);
        System.out.println(list);

        list.set(1, 1);
        System.out.println(list);

        System.out.println(list.contains(1));
        System.out.println(list.contains(null));

        System.out.println(list.indexOf(1));

        System.out.println(list.size());

        System.out.println(list.isEmpty());


        MyMap map = new MyMap();
        map.put(1,"1");
        map.put(null, null);
        map.put(2,"2");
        map.put(3,"3");

        System.out.println(map.get(2));
        System.out.println(map.get(10));

        System.out.println(map.get(1, "0"));
        System.out.println(map.get(4, "4"));

        System.out.println(map.remove(2));

        System.out.println(map.keyContains(2));
        System.out.println(map.keyContains(1));

        System.out.println(map.getKeys());

        System.out.println(map.getValues());

        System.out.println(map.getEntries());

        System.out.println(map.size());

        System.out.println(map.isEmpty());
    }
}
