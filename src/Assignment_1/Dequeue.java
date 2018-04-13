package Assignment_1;

class ListCell<T> {
    T data;
    ListCell<T> next;

    public ListCell(T x, ListCell<T> c) {
        data = x;
        next = c;
    }
}

class DequeueException extends RuntimeException {
    public DequeueException(String s) {
        super(s);
    }
}
public class Dequeue<T> {
    private ListCell<T> front;

    public Dequeue(){
        front = null;
    }

     public T left(){
         ListCell<T> c = front;
        if(c == null){
            throw new DequeueException("left applied to an empty list");
        }
        return c.data;
    }
     public T right(){
         ListCell<T> c = front;
         if (c == null) {
             throw new DequeueException("right applied to an empty list");
         }
         while (c.next != null) {
             c = c.next;
         }
         return c.data;
     }
    public boolean isEmpty(){
         boolean value = false;
        if (front == null){
            value = true;
        }
        return value;
    }
    public void addLeft (T x){
        front = new ListCell<T>(x, front);
    }
    public void addRight (T x){
        if (front == null) {
            front = new ListCell<T>(x, front);
        } else {
            ListCell<T> c = front;
            while (c.next != null) {
                c = c.next;
            }
            c.next = new ListCell<T>(x, null);
        }
    }
    public void removeLeft(){
        if (front==null) {
            throw new DequeueException("removeLeft applied to empty list");
        }
        front = front.next;
    }
    public void removeRight(){
        if (front==null) {
            throw new DequeueException("removeRight applied to empty list");
        }
        if (front.next==null) {
            front = null;
        }
        else {
            ListCell c = front;
            while (c.next.next!=null)
                c = c.next;
            c.next = null;
        }
    }
    public String toString() {
        StringBuffer sb = new StringBuffer("<");
        ListCell<T> c = front;
        while (c != null) {
            sb.append(c.data + ",");
            c = c.next;
        }
        if (sb.length() > 1) {
            sb.setLength(sb.length() - 1);
        }
        return (sb + ">");
    }
}
