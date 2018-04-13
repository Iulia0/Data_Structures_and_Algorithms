package Lab2;
class ListCell<T> {
    T data;
    ListCell<T> next;

    public ListCell(T x, ListCell<T> c) {
        data = x;
        next = c;
    }
}

class ListException extends RuntimeException {
    public ListException(String s) {
        super(s);
    }
}

public class LList<T> {
    private ListCell<T> front;

    public LList() {
        front = null;
    }

    public void addToFront(T x) {
        front = new ListCell<T>(x, front);
    }

    public void addToBack(T x) {
        if (front == null) front = new ListCell<T>(x, front);
        else {
            ListCell<T> c = front;
            while (c.next != null) {
                c = c.next;
            }
            c.next = new ListCell<T>(x, null);
        }
    }

    public T elementAt(int n) {
        ListCell<T> c = front;
        for (int i = 0; i < n; i++) {
            if (c == null)
                throw new ListException("no element at position " + n);
            c = c.next;
        }
        if (c == null)
            throw new ListException("no element at position " + n);
        return c.data;
    }

    public int length() {
        ListCell<T> c = front;
        int result = 0;
        while (c != null) {
            result++;
            c = c.next;
        }
        return result;
    }

    // exercise 1
    public String toString() {
        StringBuffer sb = new StringBuffer("<");
        ListCell<T> c = front;
        while (c != null) {
            sb.append(c.data + ",");
            c = c.next;
        }
        if (sb.length() > 1) {
            sb.setLength(sb.length() - 1);   // remove trailing comma}
        }
        return (sb + ">");
    }
// exercise 2
    public int find(T x) {
        ListCell<T> list = front;
        boolean found = false;
        int location = 0;
        while (list != null) {
            if (list.data.equals(x)) {
                found = true;
                break;
            }
            list = list.next;
            location++;
        }
        if (!found) {
            location = -1;
        }
        return location;
    }
// exercise 4 not done
    public boolean removeAll(T x) {
        ListCell<T> c = front;
        ListCell<T> prev = null;
        boolean removedOne = false;
        while (c != null) {
            if (c.data.equals(x)) {
                if (prev == null) {
                    front = c.next;
                }
                else {
                    prev.next = c.next;
                    removedOne = true;
                }
            }
            else {
                prev = c;
            }
            c = c.next;
        }
        return removedOne;
    }
}


