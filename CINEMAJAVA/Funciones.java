package Pr2;

public class Funciones {
    String Inicio;
    int sala;
    String Fin;
    Pelicula pelicula;
    boolean[][] asientos;

    public Funciones(String inicio, String fin, Pelicula pelicula, int sala) {
        this.Inicio = inicio;
        this.Fin = fin;
        this.pelicula = pelicula;
        this.sala = sala;
        this.asientos = new boolean[5][6];
    }

    public int getSala() {
        return this.sala;
    }

    public void setSala(int sala) {
        this.sala = sala;
    }

    public String getInicio() {
        return this.Inicio;
    }

    public void setInicio(String Inicio) {
        this.Inicio = Inicio;
    }

    public String getFin() {
        return this.Fin;
    }

    public void setFin(String Fin) {
        this.Fin = Fin;
    }

    public Pelicula getPelicula() {
        return this.pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    public boolean[][] getAsientos() {
        return this.asientos;
    }

    public void setAsientos(boolean[][] asientos) {
        this.asientos = asientos;
    }

}
