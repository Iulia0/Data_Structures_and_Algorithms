package Lab1;

import java.util.NoSuchElementException;

class ListCell {
    char data;
    ListCell next;

    public ListCell(char x, ListCell c) {
        data = x;
        next = c;
    }
}

class ListException extends RuntimeException {
    public ListException(String s) {
        super(s);
    }
}

// interface for exercise 6
interface LListIterator {
    public boolean hasNext();

    public char next();

    public void remove();
}

public class LList {
    private ListCell front;

    public LList() {
        front = null;
    }

    public void addToFront(char x) {
        front = new ListCell(x, front);
    }

    public void addToBack(char x) {
        if (front == null)
            front = new ListCell(x, front);
        else {
            ListCell c = front;
            while (c.next != null)
                c = c.next;
            c.next = new ListCell(x, null);
        }
    }

    public char elementAt(int n) {
        ListCell c = front;
        if (n < 0)
            throw new ListException("elementAt called with negative argument");
        for (int i = 0; i < n; i++) {
            if (c == null)
                throw new ListException("no element at position " + n);
            c = c.next;
        }
        if (c == null)
            throw new ListException("no element at position " + n);
        return c.data;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer("<");
        ListCell c = front;
        while (c != null) {
            sb.append(c.data);
            c = c.next;
        }
        return (sb + ">");
    }
    // exercise 1
    public int length() {
        int count = 0;
        ListCell c = front;
        while (c != null) {
            c = c.next;
            count++;
        }
        return count;
    }
    // exercise 2
    public int occs(char c) {
        int count = 0;
        ListCell list = front;
        while (list != null) {
            if (list.data == c) {
                count++;
            }
            list = list.next;
        }
        return count;
    }
// exercise 3
    public void removeFront() {
         if (front==null)
            throw new ListException("removeFront applied to empty list");
        front = front.next;
    }
// exercise 4 note done
    public void removeBack() {
        if (front==null)
            throw new ListException("removeBack applied to empty list");
        if (front.next==null)
            front = null;
        else
        { ListCell c = front;
            while (c.next.next!=null)
                c = c.next;
            c.next = null;
        }
    }
// exercise 5 not done
    public boolean remove(char c) {
        if (front==null)
            return false;
        else if (front.data==c)
        { front = front.next;
            return true;
        }
        ListCell ce = front;
        while (ce.next!=null && ce.next.data!=c)
            ce = ce.next;
        if (ce.next==null)
            return false;
        else
        { ce.next = ce.next.next;
            return true;
        }
    }
// exercise 6 not done
    class MyIterator implements LListIterator {
        private ListCell previous, before, after;
        private boolean canRemove;

        public MyIterator() {
            previous = before = null;
            after = front;
            canRemove = false;
        }

        public boolean hasNext() {
            return after!=null;
        }

        public char next() {
            if (after==null)
            throw new NoSuchElementException();
            if (before!=null)
                previous = before;  // don't change previous if we've just done a remove
            before = after;
            after = after.next;
            canRemove = true;
            return before.data;
        }

        public void remove() {
            if (!canRemove)
            throw new IllegalArgumentException();
            before = null;
            canRemove = false;  // don't allow another remove
            if (previous==null) {
                front = after;
            }
            else
                previous.next = after;
        }
    }
    public LListIterator iterator()
    { return new MyIterator();
    }
    // main method to test the class - expected list contents shown as comments

    public static void main(String args[]) {
        LList myList = new LList(); // <>
        System.out.println(myList);
        myList.addToFront('c');     // <c>
        myList.addToFront('b');     // <bc>
        myList.addToFront('a');     // <abc>
        System.out.println(myList);
        System.out.println("length = " + myList.length());
        myList.addToBack('d');      // <abcd>
        myList.addToBack('d');      // <abcdd>
        System.out.println(myList);
        System.out.println("length = " + myList.length());
        System.out.println("Number of occurrences of a: " + myList.occs('a'));
        System.out.println("Number of occurrences of d: " + myList.occs('d'));
        System.out.println("Number of occurrences of x: " + myList.occs('x'));
        for (int i = -1; i<7; i++)
            try
            { System.out.println(myList.elementAt(i));
            }
            catch (ListException e)
            { System.out.println("ERROR: "+e);
            }
        myList.removeFront();       // <bcdd>
        myList.removeBack();        // <bcd>
        System.out.println(myList);
        if (myList.remove('c'))
            System.out.println("removed c");  // expect this output
        else
            System.out.println("could not remove c");
        // <bd>
        if (myList.remove('e'))
            System.out.println("removed e");
        else
            System.out.println("could not remove e");  // expect this output
        myList.addToFront('b');     // <bbd>
        myList.addToBack('d');      // <bbdd>
        myList.addToBack('e');      // <bbdde>
        myList.addToBack('f');      // <bbddef>
        myList.addToBack('g');      // <bbddefg>
        System.out.println(myList);
        LListIterator it = myList.iterator();
        while (it.hasNext())
        { char c = it.next();
            System.out.println("next is "+c);
            if (c=='b' || c=='e' || c=='g')
                it.remove();
        }                           // <ddf>
        System.out.println(myList);
    }
}
