package Pruebagrafo2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Grafo 
{
    List<Nodo> nodes;

    public Grafo() {
        this.nodes = new ArrayList<>();
    }

    public void AddNode(Nodo node) {
        nodes.add(node);
    }

    public List<Nodo> LongestPath(List<Nodo> start, Nodo end) {
        List<Nodo> result = new ArrayList<>();
        Set<Nodo> visited = new HashSet<>();
        List<Nodo> ActualPath = new ArrayList<>();

        for (Nodo StartNode : start) {
            dfs(StartNode, end, visited, ActualPath, result);
        }

        return result;
    }

    private void dfs(Nodo actual, Nodo end, Set<Nodo> visited, List<Nodo> ActualPath, List<Nodo> result) {
        visited.add(actual);
        ActualPath.add(actual);

        if (actual == end) {
            if (ActualPath.size() > result.size()) {
                result.clear();
                result.addAll(ActualPath);

            }
        } else {
            for (Awn awn : actual.OutgoingAwn) {
                Nodo next = awn.destiny;
                if (!visited.contains(next)) {
                    dfs(next, end, visited, ActualPath, result);
                }
                System.out.print(actual.value + " -----> ");
            }
        }

        visited.remove(actual);
        ActualPath.remove(ActualPath.size() - 1);
    }
}
