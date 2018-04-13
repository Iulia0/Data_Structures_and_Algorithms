package Assignment_2;

import java.util.Scanner;

/**
 * Created by petri on 3/18/2018.
 */
public class Ass2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Iulia Petria, 1601159");
        System.out.println("Welcome to tge expression evaluation program. Please type\n" +
                "an expression:");
        Parser p = new Parser();
        String s;
        do {
            ExpTree myTree = p.parseLine();
            System.out.print("Post order: " );
            myTree.printPostorder(myTree);
            System.out.println();
            System.out.print("In order: ");
            try{
                System.out.println(myTree.toString());
            }
            catch (Error e){
                System.out.println("Error " + e.getMessage());
            }
            try{
                System.out.print("Evalute: ");
                System.out.println(myTree.evaluate(myTree));
            }
            catch (Exception e){
                System.out.println("Exception " + e.getMessage());
            }

            System.out.println("Another expression(y/n)");
            s = scan.next();
        }while( s.equals("y"));
        scan.close();
    }
}
