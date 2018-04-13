package Lab3.Ex1;

/**
 * Created by petri on 2/3/2018.
 */
public class TestArrayQueue {
    public static void main(String[] args) {
        ArrayQueue<Integer> myArrayQueue = new ArrayQueue();
        myArrayQueue.add(9);
        myArrayQueue.add(1);
        myArrayQueue.add(3);
        myArrayQueue.add(7);
        myArrayQueue.add(8);
        myArrayQueue.add(4);
        System.out.println(myArrayQueue);
        myArrayQueue.removeFront();
        myArrayQueue.removeFront();
        myArrayQueue.add(9);
        System.out.println(myArrayQueue);

    }
}
