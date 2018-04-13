package Lab3.Ex1;

import Lab3.Ex1.Queue;
import Lab3.Ex1.QueueException;

// incomplete array-based implementation of queues
public class ArrayQueue<T> implements Queue<T> {
    private T[] arr;
    private int frontPos;
    private int backPos;

    public ArrayQueue() {
        arr = (T[])new Object[5];
        backPos = -1;
        frontPos = 0;
    }

    public boolean isEmpty() {
        return frontPos==(backPos+1)%arr.length;
    }

    public T front() {
        if (frontPos==(backPos+1)%arr.length)
        throw new QueueException("front");
        return arr[frontPos];
    }

    public void removeFront() {
        if (frontPos==(backPos+1)%arr.length)
        throw new QueueException("removeFront");
        frontPos = (frontPos+1)%arr.length;
    }

    public String toString() {
        if (frontPos==(backPos+1)%arr.length)
        return "<>";

        StringBuffer sb = new StringBuffer();

        sb.append('<');

        int pos = frontPos;
        while (pos!=backPos) {
            sb.append(arr[pos]);
            sb.append(',');
            pos = (pos+1)%arr.length;
        }

        sb.append(arr[backPos]);
        sb.append('>');

        return(sb.toString());
    }

    public void add(T x) {
        backPos++;

        if(backPos == arr.length){
            backPos = 0;
        }
        arr[backPos] = x;
        if ((backPos+1)%arr.length==frontPos){
            int i;
            T[] temp = (T[]) new Object[arr.length * 2];
            temp[0] =  arr[frontPos];
            for ( i = 1; i < arr.length; i++) {
                temp[i] = arr[(frontPos + i % arr.length)];
            }
            backPos = arr.length-1;
            arr = temp;
            frontPos = 0;
            backPos = i-1;
            System.out.println("Array size increased to " + arr.length);
        }

    }
}