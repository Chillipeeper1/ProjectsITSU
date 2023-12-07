package Pruebagrafo2;

import java.util.ArrayList;
import java.util.List;

public class Nodo 
{
    String value;
    int weight;
    List<Awn> IncomingAwn;
    List<Awn> OutgoingAwn;

    public Nodo(String value) {
        this.value = value;
        this.IncomingAwn = new ArrayList<>();
        this.OutgoingAwn = new ArrayList<>();
    }

    public void AddAwn(Nodo destiny, int weight) 
    {
        this.weight = weight;
        Awn arista = new Awn(this, destiny, weight);
        OutgoingAwn.add(arista);
        destiny.IncomingAwn.add(arista);
    }
}
