package Assignment_1;

public class TestDequeue {
    public static void main(String[] args) {
        Dequeue<Integer> myDequeue = new Dequeue<>();

        System.out.println("Queue contents: " + myDequeue);
        System.out.println("Calling isEmpty: " + myDequeue.isEmpty());

        try {
            System.out.println( myDequeue.right());
        } catch (DequeueException e) {
            System.out.println("ERROR: " + e);
        }
        try {
            System.out.println( myDequeue.left());
        } catch (DequeueException e) {
            System.out.println("ERROR: " + e);
        }
        try {
            myDequeue.removeLeft();
            System.out.println("removeLeft called");
        } catch (DequeueException e) {
            System.out.println("ERROR: " + e);
        }
        try {
            myDequeue.removeRight();
            System.out.println("removeRight called");
        }
        catch(DequeueException e){
            System.out.println("ERROR: " + e);
        }

        myDequeue.addLeft(33);
        System.out.println("Adding 33 to left");
        myDequeue.addLeft(4);
        System.out.println("Adding 4 to left");
        myDequeue.addLeft(9);
        System.out.println("Adding 9 to left");
        myDequeue.addLeft(3);
        System.out.println("Adding 3 to left");

        System.out.println("Queue contents: " + myDequeue);

        myDequeue.addRight(8);
        System.out.println("Adding 8 to right");
        myDequeue.addRight(58);
        System.out.println("Adding 58 to right");
        myDequeue.addRight(5);
        System.out.println("Adding 5 to right");

        System.out.println("Queue contents: " + myDequeue);
        System.out.println("Calling isEmpty: " + myDequeue.isEmpty());

        System.out.println("Calling right: " + myDequeue.right() + " returned");
        System.out.println("Calling left: " + myDequeue.left()+ " returned");

        myDequeue.removeLeft();
        System.out.println("removeLeft called");
        System.out.println("Queue contents: " + myDequeue);
        myDequeue.removeRight();
        System.out.println("removeRight called");
        System.out.println("Queue contents: " + myDequeue);
    }
}
