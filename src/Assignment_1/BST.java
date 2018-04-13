package Assignment_1;


public class BST {
    private BTNode<Integer> root;

    public BST() {
        root = null;
    }

    public boolean find(Integer i) {
        BTNode<Integer> n = root;
        boolean found = false;

        while (n != null && !found) {
            int comp = i.compareTo(n.data);
            if (comp == 0)
                found = true;
            else if (comp < 0)
                n = n.left;
            else
                n = n.right;
        }

        return found;
    }


    public boolean insert(Integer i) {
        BTNode<Integer> parent = root, child = root;
        boolean goneLeft = false;

        while (child != null && i.compareTo(child.data) != 0) {
            parent = child;
            if (i.compareTo(child.data) < 0) {
                child = child.left;
                goneLeft = true;
            } else {
                child = child.right;
                goneLeft = false;
            }
        }

        if (child != null)
            return false;  // number already present
        else {
            BTNode<Integer> leaf = new BTNode<Integer>(i);
            if (parent == null) // tree was empty
                root = leaf;
            else if (goneLeft)
                parent.left = leaf;
            else
                parent.right = leaf;
            return true;
        }
    }

    public int nonleaves() {
        if (root == null)
            return 0;
        else
            return root.calcNonleaves();
    }

    public int depth() {
        int answear = 0;
        try{
            answear = root.maxDepth(root);
        }
        catch (Exception e){

        }
        return answear;
    }

    public int range(int min, int max) {
        if (max < min){
            throw new IllegalArgumentException("max(second parameter) cannot be less than min(first parameter)");
//            throw new TreeException("max(second parameter) cannot be less than min(first parameter)");
        }
        int elements = 0;
        BTNode<Integer> node= root;
        if(root == null){
            return 0;
        }
        else {
            for (int i = min; i <= max; i++) {
                boolean found = node.findElem(node, i);
                if (found) {
                    elements++;
                }
            }
        }
        return elements;
    }


    class BTNode<T> {
        T data;
        BTNode<T> left, right;

        BTNode(T o) {
            data = o;
            left = right = null;
        }

        private int calcNonleaves() {
            int leftNodes = 0;
            int isLeaf = 1;
            if (left != null) {
                leftNodes = left.calcNonleaves();
            }
            int rightNodes = 0;
            if (right != null) {
                rightNodes = right.calcNonleaves();
            }
            if (left == null && right == null) {
                isLeaf = 0;
            }
            return leftNodes + rightNodes + isLeaf;
        }

        private int maxDepth(BTNode node) {
            if (node == null) {
                return 0;
            }
            else {
                int lDepth = maxDepth(node.left);
                int rDepth = maxDepth(node.right);
                if (lDepth > rDepth) {
                    return (lDepth + 1);
                }
                else {
                    return (rDepth + 1);
                }
            }
        }

        private boolean findElem(BTNode root, T x) {
            if (root != null) {
                if (root.data == x) {
                    return true;
                } else {
                    return findElem(root.left, x) || findElem(root.right, x);
                }
            }
            return false;
        }
    }
}
//class TreeException extends IllegalArgumentException {
 //   public TreeException(String s) {super("Tried to apply "+s+" to empty tree");}
//}




