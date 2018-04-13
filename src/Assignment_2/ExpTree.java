package Assignment_2;


/**
 * Created by petri on 3/18/2018.
 */
public class ExpTree {
    private int kind; // number, identifier or operator
    private Object value; // value of ExpTree
    private ExpTree lChild, rChild;
    private static final int numNode = 0, idNode = 1, opNode = 2; // type of node

    public ExpTree(int kind, Object value, ExpTree lChild, ExpTree rChild) {
        this.kind = kind;
        this.value = value;
        this.lChild = lChild;
        this.rChild = rChild;
    }
    /**
     * @print the elements in the tree post order
     */
    public void printPostorder(ExpTree node) {
        if (node == null)
            return;
        /* first recur on left child */
        printPostorder(node.lChild);
        /* then recur on left child */
        printPostorder(node.rChild);
        // now print the data of node
        System.out.print(node.value + " ");
    }

    void printInorder(ExpTree node) {
        if (node == null)
            return;
        /* first recur on left child */
        printInorder(node.lChild);

        /* then print the data of node */
        System.out.print(node.value + " ");

        /* now recur on right child */
        printInorder(node.rChild);
    }

    /**
     * traverses the tree recursively and evaluates it;
     * @param node the root of the tree
     * @return the final result (int) of the evaluation
     */
    public int evaluate(ExpTree node) throws Exception {
        int identifier = 0;
        if (node == null)
            return 0;
        if (node.kind == 2) {
            switch ((Character) node.value) {
                case '+':
                    identifier += evaluate(node.lChild) + evaluate(node.rChild);
                    break;
                case '-':
                    identifier += evaluate(node.lChild) - evaluate(node.rChild);
                    break;
                case '*':
                    identifier += evaluate(node.lChild) * evaluate(node.rChild);
                    break;
                case '/':
                    identifier += evaluate(node.lChild) / evaluate(node.rChild);
                    break;
                case '%':
                    identifier += evaluate(node.lChild) % evaluate(node.rChild);
                    break;
                case '^':
                    if (node.rChild.kind != 2) {
                        identifier +=Math.pow(evaluate(node.lChild), evaluate(node.rChild));
                        break;
                    }
                    else{
                        if (node.rChild.rChild.value.equals("-")){
                            throw new Exception();
                        }
                    }
            }
        } else if (node.kind == 0) { // get the value of the number leaf
            return identifier + (Integer) node.value;

        } else if (node.kind == 1) { // get the value of the identifier leaf
            Character[] myAlphabet = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
            int value = 26;
            for(int i = 0; i < myAlphabet.length;  i++){
                if (node.value.equals(myAlphabet[i])){
                    identifier += value;
                }
                value -= 1;
            }
        }
        return identifier;
    }
    /**
     * takes an ExpTree as an argument, it check its operator
     * and returns an int stating the precedence
     * @param node the root of the tree
     * @return the precedence(int) of he node
     */
    public int precedence (ExpTree node) {
        int pr = 0;
        if (node.value.equals("+") || node.value.equals("-")) { // adds precedence 1 for '+' and '-'
            pr = 1;
        } else if (node.value.equals("*") || node.value.equals("/") || node.value.equals("%") ) {
            pr = 2;
        }
        else if(node.value.equals("^")){
            pr = 3;
        }
        return pr;

    }
    /**
     * traverses the tree in order, recursively, and adds parentheses where,
     * the node  has lower precedence than its parent,
     * the right child  has the same precedence as its parent
     * @return a string with the node with or without parentheses
     */
    public String toString() {
        String output = "";

        // LEFT SIDE
        // if not not null
        if(lChild != null){
            // if the node is either a number or an identifier, add the node to the output
            if (lChild.kind == 0 || lChild.kind == 1) {
                output += lChild.toString();
            }
            // if the left child is an operator
            else if (lChild.kind == 2) {
                // if the precedence of the node is higher than the child, then put parentheses
                if (precedence(lChild) > precedence(lChild.lChild)) {
                    output += "(" + lChild.toString() + ")";
                }
                // if they are the same precedence, then don't put parentheses
                else if (precedence(lChild) == precedence(lChild.lChild)) {
                    output += lChild.toString();
                }
                // if the precedence of this node is lower, no parentheses
                else if (precedence(lChild) < precedence(lChild.lChild)) {
                    output += lChild.toString();
                }
                // if it's the left child of another ^ node, add parentheses
                else if (precedence(lChild) == 3 && precedence(lChild.lChild)== 3){
                    output += "(" + lChild.toString() + ")";
                }
            }
        }

        // add the operator
        output += value;

        // RIGHT SIDE
        // if not null
        if (rChild != null){
            // if the node is either a number or an identifier, add the node
            if (rChild.kind == 0 || rChild.kind == 1) {
                output += rChild.toString();
            }
            // if the right child is an operator
            else if (rChild.kind == 2) {
                // if the precedence of the node is higher than the child, then put parentheses
                if ((precedence(rChild) > precedence(rChild.rChild))) {
                    output += "(" + rChild.toString() + ")";
                }
                // if the precedence of this node is equal with the on of the child, put parentheses
                else if (precedence(rChild) == precedence(rChild.rChild)) {
                    output += "(" + rChild.toString() + ")";
                }
                // if the precedence of the node is lower, no parentheses
                else if (precedence(rChild) < precedence(rChild.rChild)) {
                    output += rChild.toString();
                }
                // if it's the left child of another ^ node, add parentheses
                else if (precedence(rChild) == 3 && precedence(rChild.lChild)== 3){
                    output += "(" + rChild.toString() + ")";
                }
            }
        }
        return output;
    }
}

