package Lab3;

import Lab3.*;

import java.util.*;

public class LLQueue<T> implements Lab3.Queue<T> {
    private LinkedList<T> ll;

    public LLQueue() {
        ll = new LinkedList<T>();
    }

    public boolean isEmpty() {
        return ll.isEmpty();
    }

    public void add(T x) {
        ll.addLast(x);
    }

    public T front() {
        if (ll.isEmpty())
        throw new QueueException("front");
        return ll.getFirst();
    }

    public void removeFront() {
        if (ll.isEmpty())
        throw new QueueException("removeFront");
        ll.removeFirst();
    }
    public String toString(){
        if (ll.isEmpty()) {
            return "<>";
        }
        StringBuffer sb = new StringBuffer();
        sb.append('<');
        Iterator itr = ll.iterator();

        while (itr.hasNext()){
            sb.append(itr.next());
            sb.append(",");
        }
        sb.setLength(sb.length()-1); //remove the last comma
        sb.append('>');
        return(sb.toString());
    }

}
