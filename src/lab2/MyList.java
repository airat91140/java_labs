package lab2;
//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!merge function is on 160 line
import java.util.Objects;

public class MyList {
    private MyList.Node first, last;
    private int size;

    private static class Node {
        public int current;
        public MyList.Node next, previous;

        Node(int cur, MyList.Node nex, MyList.Node prev) {
            current = cur;
            next = nex;
            previous = prev;
        }
    }

    public MyList() {
        last = null;
        first = null;
        size = 0;
    }

    public MyList(MyList other) {
        this.size = other.size;
        if (size == 0) {
            first = null;
            last = null;
            return;
        }
        first = new Node(other.first.current, null, null);
        last = first;
        Node it = other.first.next;
        for (int i = 1; i < size; ++i) {
            last.next = new MyList.Node(it.current, null, last);
            last = last.next;
        }
    }

    public void add(int obj) {
        if (last == null) {//size = 0
            last = new MyList.Node(obj, null, null);
            first = last;
            size = 1;
        } else {
            last.next = new MyList.Node(obj, null, last);
            last = last.next;
            ++size;
        }
    }

    public void add(int obj, int index) {
        ++size;
        if (index <= 0) {
            first.previous = new MyList.Node(obj, first, null);
            first = first.previous;
        } else if (index >= size) {
            last.next = new MyList.Node(obj, null, last);
            last = last.next;
        } else {
            MyList.Node it = first;
            for (int i = 0; i < index; ++i)
                it = it.next;
            it.previous = new MyList.Node(obj, it.previous, it.next);
        }
    }

    public int get(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of range");
        }
        MyList.Node it = first;
        for (int i = 0; i < index; ++i)
            it = it.next;
        return it.current;
    }

    public int remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of range");
        }
        MyList.Node it = first;
        for (int i = 0; i < index; ++i)
            it = it.next;
        delete(it);
        return it.current;
    }

    private void delete(Node it) {
        if (it.previous != null)
            it.previous.next = it.next;
        if (it.next != null)
            it.next.previous = it.previous;
        if (it.previous == null && it.next == null)
            first = last = null;
        --size;
    }

    public int set(int obj, int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of range");
        }
        MyList.Node it = first;
        for (int i = 0; i < index; ++i)
            it = it.next;
        int deleted = it.current;
        it.current = obj;
        return deleted;
    }

    public boolean contains(int obj) {
        if (size == 0) {
            return false;
        }
        MyList.Node it = first;
        for (int i = 0; i < size; ++i) {
            if (obj == it.current)
                return true;
            it = it.next;
        }
        return false;
    }

    public int indexOf(int obj) {
        MyList.Node it = first;
        for (int i = 0; i < size; ++i) {
            if (obj == it.current)
                return i;
            it = it.next;
        }
        return -1;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public String toString() {
        MyList.Node it = first;
        StringBuilder str = new StringBuilder("{");
        if (!isEmpty()) {
            str.append(it.current);
            it = it.next;
        }
        for (int i = 1; i < size; ++i) {
            str.append(",");
            str.append(it.current);
            it = it.next;
        }
        str.append("}");
        return str.toString();
    }

    public static MyList merge(MyList list1, MyList list2) {
        if (list1 == null || list2 == null)
            throw new NullPointerException();

        MyList result = new MyList();
        Node it1 = list1.first, it2 = list2.first;
        while (it1 != null && it2 != null) {
            if (it1.current < it2.current) {
                result.add(it1.current);
                it1 = it1.next;
            }
            else {
                result.add(it2.current);
                it2 = it2.next;
            }
        }
        Node tmpIt = it1 == null ? it2 : it1; //choosing the list, which will be copied at the end.
        while (tmpIt != null) {
            result.add(tmpIt.current);
            tmpIt = tmpIt.next;
        }
        return result;
    }
}

