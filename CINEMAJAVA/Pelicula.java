package Pr2;


public class Pelicula {
    String nombre;
        int sala;
        public Pelicula(String nombre, int sala) {
            this.nombre = nombre;
            this.sala = sala;
           // this.asientos = new boolean[5][6]; 
        }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getSala() {
        return this.sala;
    }

    public void setSala(int sala) {
        this.sala = sala;
    }

    

}
