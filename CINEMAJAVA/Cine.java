package Pr2;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Cine {

    Scanner key = new Scanner(System.in);
    ArrayList<Pelicula> movie = new ArrayList<>();
    ArrayList<Funciones> funciones = new ArrayList<>();

    int aux = 0, aux2 = 1, aux3 = 0, aux4 = 0;
    int auxfunci = 0;

    public void verPeliculas() {
        int i = 0;
        ArrayList<Funciones> funciones = getFunciones();
        if (aux == 0) {
            System.out.println("Aun no hay peliculas");
        } else {
            System.out.println("Lista de películas:");
            for (Pelicula pelicula : movie) {
                System.out.println(pelicula.nombre + " - Sala " + pelicula.sala);
                // ESTO ES PARA VER LAS FUNCIONES DE CADA SALA EN ESPECIFICO, IGUALMENTE SI UNA
                // SALA TIENE MISMO NOMBRE GRACIAS AL NUMERO SOLO MUESTRA LOS HORARIOS
                // CORRESPONDIENTES

                for (int o = 0; o < funciones.size(); o++) {
                    Funciones funcion = funciones.get(i);
                    if (pelicula.sala == funcion.getSala()) {
                        System.out.println(funcion.getInicio());
                    }
                    i++;
                }
                i = 0;
            }
        }
    }

    public void agregar() {
        System.out.println("Ingrese el nombre de la película:");
        String nombre = key.next();
        Pelicula newPelicula = new Pelicula(nombre, aux2);
        movie.add(newPelicula);
        aux2++;
        aux++;
        System.out.println("Se añadio pelicula");

    }

    public void ComprarBoletos() {
        if (aux == 0 && auxfunci == 0) {
            System.out.println("Aun no hay peliculas, ni funciones");
        }
        if (aux == 0) {
            System.out.println("Aun no hay peliculas");
        } else {

            System.out.println("Seleccione una película:");
            String seleccion = key.next();
            Pelicula temp = null;
            for (Pelicula pelicula : movie) {
                if (pelicula.nombre.equals(seleccion)) {
                    temp = pelicula;
                    break;
                }
            }
            System.out.println("Seleccione el horario");
            String hora = key.next();
            Funciones temp1 = null;
            for (Funciones funcion : funciones) {
                if (funcion.Inicio.equals(hora)) {
                    temp1 = funcion;
                    break;
                }
            }
            if (temp1 != null && temp != null) {
                mostrarAsientos(temp.getNombre(), temp.getSala(), temp1);
            } else {
                System.out.println("Funcion no encontrada o pelicula no encontrada");
            }
        }
    }

    public void mostrarAsientos(String nombre, int sala, Funciones funcion) { // ,Funciones Funcion
        if (aux4 == 0) {
            System.out.println("NO HAY FUNCIONES");
        } else {
            Pelicula pelicula = new Pelicula(nombre, sala);
            boolean[][] ol = funcion.getAsientos();
            System.out.println("Asientos disponibles para " + pelicula.nombre + " - Sala " + pelicula.sala);
            System.out.println("Cuantos asientos desea comprar:");
            int lugar = key.nextInt();
            int aux2 = 0, suma = 0, costo = 70;
            suma = costo * lugar;

            String[] Letras = new String[5];
            Letras[0] = "A";
            Letras[1] = "B";
            Letras[2] = "C";
            Letras[3] = "D";
            Letras[4] = "E";
            System.out.print("    ");
            for (int i = 1; i <= 6; i++) {
                System.out.print(" " + i + " ");
            }
            System.out.println();

            while (aux2 < lugar) {
                for (int i = 0; i < 5; i++) {
                    System.out.print(((i + 1) + ".-" + Letras[i]) + " ");
                    for (int j = 0; j < 6; j++) {
                        char estado = ol[i][j] ? 'X' : ' ';
                        System.out.print(estado + "| ");
                    }
                    System.out.println();
                }

                System.out.println("Seleccione una fila:");
                int fila = (key.nextInt() - 1);
                if (fila > 4) {
                    while (fila > 4) {
                        System.out.println("Tiene que ser un numero menor a 5");
                        fila = (key.nextInt() - 1);
                    }
                }
                System.out.println("Seleccione un asiento:");
                int asiento = (key.nextInt() - 1);
                if (asiento > 5) {
                    while (fila > 4) {
                        System.out.println("Tiene que ser un numero menor a 6");
                        asiento = (key.nextInt() - 1);
                    }
                }
                if (ol[fila][asiento]) {
                    System.out.println("Este asiento ya está ocupado");
                } else {
                    suma = costo * lugar;
                    ol[fila][asiento] = true;
                    System.out.println("Se han comprado los boletos" + " el precio a pagar es:" + suma);
                    funcion.setAsientos(ol);
                }
                aux2++;
            }
        }
    }

    public void calcular() {
        // ingrese el nombre de la pelicula
        if (aux == 0) {
            System.out.println("No hay peliculas a las cuales agregar");
        } else {

            System.out.println("Cual es la pelicula a la que desea añadirle la funcion");
            String esta = key.next();
            Pelicula temp = null;
            for (Pelicula ol : movie) {
                if (ol.nombre.equals(esta)) {
                    temp = ol;
                    break;
                }
            }
            if (temp != null) {
                calcular2(temp);
                auxfunci++;
            } else {
                System.out.println("Película no encontrada.");
            }
        }

    }

    private static LocalTime calcularHoraFinal(LocalTime horaInicio, LocalTime duracion) {
        return horaInicio.plusHours(duracion.getHour())
                .plusMinutes(duracion.getMinute());

    }

    public void calcular2(Pelicula pelicula) {
        aux4++;
        ArrayList<Funciones> funciones = getFunciones();

        // El recuerdame la sala es para si dos salas tienen mismo nombre puedan
        // diferenciarse por el numero de sala y cada una tenga sus propias funciones
        System.out.println("Recuerdame la sala");
        int sala = key.nextInt();
        // Ingreso de la hora de inicio
        System.out.print("Ingrese la hora de inicio: ");
        String horaInicioStr = key.next();
        LocalTime horaInicio = LocalTime.parse(horaInicioStr, DateTimeFormatter.ofPattern("HH:mm"));

        // Ingreso de la duración
        System.out.print("Ingrese la duración: ");
        String duracionStr = key.next();
        LocalTime duracion = LocalTime.parse(duracionStr, DateTimeFormatter.ofPattern("HH:mm"));

        // Calcular la hora final
        LocalTime horaFinal = calcularHoraFinal(horaInicio, duracion);
        String fin = horaFinal.format(DateTimeFormatter.ofPattern("HH:mm"));
        // Mostrar el resultado
        System.out.println("La hora final es: " + fin);

        Funciones funcioni = new Funciones(horaInicioStr, fin, pelicula, sala);
        funciones.add(funcioni);
        setFunciones(funciones);
    }

    public ArrayList<Pelicula> getMovie() {
        return movie;
    }

    public void setMovie(ArrayList<Pelicula> movie) {
        this.movie = movie;
    }

    public ArrayList<Funciones> getFunciones() {
        return funciones;
    }

    public void setFunciones(ArrayList<Funciones> funciones) {
        this.funciones = funciones;
    }
}
