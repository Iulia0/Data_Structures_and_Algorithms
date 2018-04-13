package Lab4;

/**
 * Created by petri on 2/28/2018.
 */
public class TestBST {
    public static void main(String[] args) {
        BST<Integer> myBST = new BST<>();
        myBST.insert(3);
        myBST.insert(43);
        myBST.insert(33);
        myBST.insert(23);
        myBST.insert(13);
        myBST.insert(63);
        myBST.insert(73);
        myBST.insert(54);
        System.out.println(myBST.find(54));
        System.out.println(myBST.find(73));
        System.out.println(myBST);

    }

}
