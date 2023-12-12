package EXAMENRECUPERACION;

import java.util.Scanner;
import java.util.Stack;

public class Main 
{
     public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese números enteros (0 para finalizar):");

        int input;
        do {
            input = scanner.nextInt();
            if (input != 0) {
                stack.push(input);
            }
        } while (input != 0);

        BinaryTree binaryTree = new BinaryTree();

        while (!stack.isEmpty()) {
            int top = stack.pop();
            binaryTree.insert(top);
        }

        SimpleLinkedList sortedList = new SimpleLinkedList();
        binaryTree.inOrderTraversal(binaryTree.root, sortedList);

        System.out.println("Ordered list:");
        sortedList.display();
    }
}
