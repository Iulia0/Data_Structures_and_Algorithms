package Lab2;

public class StackTest {
    public static void main(String[] args) {
        Stack<Integer> myStack = new ArrayStack<Integer>();
        System.out.println("Stack contents:" + myStack);
        try {
            System.out.println("top is "+myStack.top());
        }
        catch (StackException e) {
            System.out.println("EXCEPTION: " + e.toString());
        }
        myStack.push(5);
        System.out.println("Stack contents:" + myStack);
        try {
            System.out.println("top is "+myStack.top());
        }
        catch (StackException e) {
            System.out.println("EXCEPTION: " + e.toString());
        }
        myStack.push(8);
        System.out.println(myStack);
        myStack.push(7);
        myStack.push(3);
        myStack.push(1);
        myStack.push(5);
        myStack.push(2);
        myStack.push(9);
        System.out.println(myStack);
    }
}