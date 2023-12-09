package Pruebagrafo2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Main {
    //ZABDIEL RIOS CERVANTES
    //ALVARO GOMEZ DUARTE
    //BRANDON MIGUEL LUCATERO FARIAS

    
     public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, Integer> addition = new HashMap<>();

        Grafo grafo = new Grafo();
        System.out.println("what are your units? EX: min, hrs, $, days. ");
        String unit = scanner.next();

        System.out.print("Input the amount of nodes: ");
        int numNodos = scanner.nextInt();

        for (int i = 0; i < numNodos; i++) {
            System.out.print("Input the name of the node " + (i + 1) + " and the value: ");
            String valor = scanner.next();
            int peso = scanner.nextInt();
            grafo.AddNode(new Nodo(valor));
            addition.put(valor, peso);
        }

        System.out.println("Input the awn (origin, destiny, weight) One per line. Input 'finish' to finish.");

        while (true) {
            System.out.print("Origin: ");
            String origen = scanner.next();

            if (origen.equals("finish")) {
                break;
            }

            System.out.print("Destiny: ");
            String destino = scanner.next();
            System.out.print("Weight: ");
            int weight = scanner.nextInt();

            Nodo OriginNode = SearchNode(grafo.nodes, origen);
            Nodo DestinyNode = SearchNode(grafo.nodes, destino);

            if (OriginNode != null && DestinyNode != null) {
                OriginNode.AddAwn(DestinyNode, weight);
            } else {
                System.out.println("Invalid Node. Try again");
            }
        }

        System.out.print("Input the number of starting nodes: ");
        int numNodosInicio = scanner.nextInt();
        List<Nodo> nodosInicio = new ArrayList<>();

        for (int i = 0; i < numNodosInicio; i++) {
            System.out.print("Input the name of the starting node  " + (i + 1) + ": ");
            String valorInicio = scanner.next();
            nodosInicio.add(SearchNode(grafo.nodes, valorInicio));
        }

        System.out.print("Input the name of the final node: ");
        String valorFin = scanner.next();

        scanner.close();

        Nodo end = SearchNode(grafo.nodes, valorFin);

        List<Nodo> longestpath = grafo.LongestPath(nodosInicio, end);
        Object[] keys = addition.keySet().toArray();
        int suma = 0;

        System.out.println("Longest path " + end.value + ": ");
         for (Nodo node : longestpath) {

            System.out.print(node.value + " ");
            addition.keySet();
            for(int i = 0; i < keys.length; i++)
            {
                if(keys[i].equals(node.value))
                {
                    suma = addition.get(keys[i]) + suma;
                }
            }
        }
        System.out.println("Addition = " + suma + " " + unit);
    }

    private static Nodo SearchNode(List<Nodo> node, String value) {
        for (Nodo nodo : node) {
            if (nodo.value.equals(value)) {
                return nodo;
            }
        }
        return null;
    }
}
