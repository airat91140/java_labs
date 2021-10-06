package lab1;

import java.util.Objects;

public class MyMap {
    private final int arraySize;
    private MyList[] array;

    private static int hash(Object obj) {
        if (obj == null)
            return 0;
        else return obj.hashCode();
    }

    public class Elem { // element of map
        public Object key, value;
        public Elem(Object key, Object value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Elem elem = (Elem) o;
            return Objects.equals(key, elem.key);
        }

        @Override
        public int hashCode() {
            return Objects.hash(key);
        }
    }

    public MyMap() {
        this(100);
    }

    public MyMap(int arraySize) {
        this.arraySize = arraySize;
        array = new MyList[arraySize];
        for (int i = 0; i < arraySize; ++i) {
            array[i] = new MyList();
        }
    }

    public void put(Object key, Object value) {
        int pos = hash(key) % arraySize;
        int index = array[pos].indexOf(new Elem(key, value));
        if (index != -1)
            array[pos].set(new Elem(key, value), index);
        else
            array[pos].add(new Elem(key, value));
    }

    public Object get(Object key) {
        Elem tmp = (Elem) array[hash(key) % arraySize].get(new Elem(key, 0));
        if (tmp == null)
            return null;
        return tmp.value;
    }

    public Object get(Object key, Object bydefault) {
        Object val = get(key);
        put(key, bydefault);
        return val != null ? val : bydefault;
    }

    public Object remove(Object key) {
        MyList list = array[hash(key) % arraySize];
        int index = list.indexOf(new Elem(key, 0));
        if (index == -1)
            return null;
        return ((Elem) list.remove(index)).value;
    }

    public boolean keyContains(Object key) {
        return array[hash(key) % arraySize].contains(new Elem(key, 0));
    }

    public MyList getKeys() {
        MyList result = new MyList();
        for (int i = 0; i < arraySize; ++i) {
            MyList.Iterator it = array[i].iterator();
            while (it.hasNext()) {
                result.add(((Elem) it.next()).key);
            }
        }
        return result;
    }

    public MyList getValues() {
        MyList result = new MyList();
        for (int i = 0; i < arraySize; ++i) {
            MyList.Iterator it = array[i].iterator();
            while (it.hasNext()) {
                result.add(((Elem) it.next()).value);
            }
        }
        return result;
    }

    public MyList getEntries() {
        MyList result = new MyList();
        Elem tmp;
        for (int i = 0; i < arraySize; ++i) {
            MyList.Iterator it = array[i].iterator();
            while (it.hasNext()) {
                result.add((Elem) it.next());
            }
        }
        return result;
    }

    public int size() {
        int totalSize = 0;
        for (int i = 0; i < arraySize; ++i) {
            totalSize += array[i].size();
        }
        return totalSize;
    }

    public boolean isEmpty() {
        return size() == 0;
    }
}


