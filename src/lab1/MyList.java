package lab1;

import java.util.Objects;
import java.util.function.Consumer;

public class MyList {
    private Node first, last;
    private int size;

    public Iterator iterator() {
        return new Iterator(first);
    }

    private static class Node {
        public Object current;
        public Node next, previous;

        Node(Object cur, Node nex, Node prev) {
            current = cur;
            next = nex;
            previous = prev;
        }
    }

    public class Iterator implements java.util.Iterator<Object> {
        private Node node;

        public Iterator(Node node) {
            this.node = node;
        }

        @Override
        public boolean hasNext() {
            return node != null;
        }

        @Override
        public Object next() {
            if (node == null)
                return null;
            Object elem = node.current;
            node = node.next;
            return elem;
        }

        @Override
        public void remove() {
            delete(node);
        }
    }

    private static boolean compare(Object obj1, Object obj2) {
        if (obj1 == null && obj2 == null)
            return true;
        else if (obj1 == null ^ obj2 == null)
            return false;
        else
            return Objects.equals(obj1, obj2);
    }

    public MyList() {
        first = last = null;
        size = 0;
    }

    public void add(Object obj) {
        if (last == null) {//size = 0
            first = last = new Node(obj, null, null);
            size = 1;
        } else {
            last.next = new Node(obj, null, last);
            last = last.next;
            ++size;
        }
    }

    public void add(Object obj, int index) {
        ++size;
        if (index <= 0) {
            first.previous = new Node(obj, first, null);
            first = first.previous;
        } else if (index >= size) {
            last.next = new Node(obj, null, last);
            last = last.next;
        } else {
            Node it = first;
            for (int i = 0; i < index; ++i)
                it = it.next;
            it.previous = new Node(obj, it.previous, it.next);
        }
    }

    public Object get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        Node it = first;
        for (int i = 0; i < index; ++i)
            it = it.next;
        return it.current;
    }

    public Object get(Object object) {
        Node it = first;
        if (it == null) return null;
        while (it != null) {
            if (compare(it.current, object))
                return it.current;
            it = it.next;
        }
        return null;
    }

    public Object remove(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        Node it = first;
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

    public Object set(Object obj, int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        Node it = first;
        for (int i = 0; i < index; ++i)
            it = it.next;
        Object deleted = it.current;
        it.current = obj;
        return deleted;
    }

    public boolean contains(Object obj) {
        if (size == 0) {
            return false;
        }
        Node it = first;
        for (int i = 0; i < size; ++i) {
            if (compare(it.current, obj))
                return true;
            it = it.next;
        }
        return false;
    }

    public int indexOf(Object obj) {
        Node it = first;
        for (int i = 0; i < size; ++i) {
            if (compare(it.current, obj))
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
        Node it = first;
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
}
