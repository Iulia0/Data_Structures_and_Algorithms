package Assignment_1;
// if you've used IntelliJ you'll probably need a line like the following one

// package ex2;

import java.util.*;

public class TestBST {
    private static void testrange(BST t, int i1, int i2) {
        try {
            System.out.println(t.range(i1, i2));
        }
        catch (IllegalArgumentException e) {
            System.out.println("*** IllegalArgumentException thrown");
        }
        catch (Exception e) {
            System.out.println("*** Exception thrown: " + e);
        }
    }
    private static void testnl(BST t) {
        try {
            System.out.println(t.nonleaves());
        }
        catch (Exception e) {
            System.out.println("*** Exception thrown: " + e);
        }
    }
    private static void testdep(BST t) {
        try {
            System.out.println(t.depth());
        }
        catch (Exception e) {
            System.out.println("*** Exception thrown: " + e);
        }
    }

    public static void main(String args[]) {
        BST leaf = new BST();
        leaf.insert(5);
        BST t1 = new BST();
        t1.insert(2);
        t1.insert(1);
        t1.insert(3);
        BST t2 = new BST();
        t2.insert(1);
        t2.insert(10);
        t2.insert(2);
        t2.insert(9);
        t2.insert(3);
        t2.insert(8);
        t2.insert(5);
        t2.insert(4);
        t2.insert(6);
        t2.insert(7);
        BST t3 = new BST();
        t3.insert(4);
        t3.insert(2);
        t3.insert(6);
        t3.insert(1);
        t3.insert(3);
        t3.insert(5);
        t3.insert(7);
        t3.insert(9);
        t3.insert(8);

        System.out.println();
        System.out.println("Testing nonleaves");
        System.out.print("leaf.nonleaves() (expect 0): ");
        testnl(leaf);
        System.out.print("t1.nonleaves() (expect 1): ");
        testnl(t1);
        System.out.print("t2.nonleaves() (expect 8): ");
        testnl(t2);
        System.out.print("t3.nonleaves() (expect 5): ");
        testnl(t3);

        System.out.println();
        System.out.println("Testing  depth");
        System.out.print("leaf.depth() (expect 1): ");
        testdep(leaf);
        System.out.print("t1.depth() (expect 2): ");
        testdep(t1);
        System.out.print("t2.depth() (expect 9): ");
        testdep(t2);
        System.out.print("t3.depth() (expect 5): ");
        testdep(t3);

        System.out.println();
        System.out.println("Testing range");
        System.out.print("leaf.range(1,6) (expect 1): ");
        testrange(leaf,1,5);
        System.out.print("leaf.range(7,9) (expect 0): ");
        testrange(leaf,7,9);
        System.out.print("t1.range(0,2) (expect 2): ");
        testrange(t1,0,2);
        System.out.print("t2.range(3,8) (expect 6): ");
        testrange(t2,3,8);
        System.out.print("t3.range(2,7) (expect 6): ");
        testrange(t3,2,7);
        System.out.print("t3.range(3,3) (expect 1): ");
        testrange(t3,3,3);

        System.out.println();
        System.out.println("Testing invalid range (expect IllegalArgumentException)");
        testrange(t2,5,2);

        System.out.println();
        System.out.println("Testing with empty tree");
        System.out.print("nonleaves (expect 0): ");
        testnl(new BST());
        System.out.print("depth (expect 0): ");
        testdep(new BST());
        System.out.print("range (expect 0): ");
        testrange(new BST(),1,5);

    }
}
