package Pr2;

//LUCATERO FARIAS BRANDON MIGUEL
//GOMEZ DUARTE ALVARO
//RIOS CERVANTES ZABDIEL
public class Main {
    public static void main(String[] args) {
        int aux = 0, option, aux2 = 0, aux5 = 0;
        String pass = "contra";
        Cine cine = new Cine();
        while (aux == 0) {
            System.out.println("Bienvenido \nElige tu modo \n1.Administrador \n2.Usuario \n3.Salir");
            option = cine.key.nextInt();
            switch (option) {
                case 1:
                    aux2 = 0;
                    System.out.println("Ingrese la contraseña");
                    String contra = cine.key.next();
                    if (contra.equals(pass)) {
                        while (aux2 == 0) {
                            System.out.println(
                                    "¿Qué desea realizar? \n1.Agregar pelicula \n2.Agregar funcion \n3.Ver peliculas \n4.Salir");
                            int aux3 = cine.key.nextInt();
                            switch (aux3) {
                                case 1:
                                    cine.agregar();
                                    break;
                                case 2:
                                    cine.calcular();
                                    break;
                                case 3:
                                    cine.verPeliculas();
                                    break;
                                case 4:
                                    aux2++;
                                    break;
                                default:
                                    System.out.println("Opcion no valida");
                                    break;
                            }
                        }
                    } else {
                        System.out.println("Contraseña incorrecta");
                    }

                    break;
                case 2:
                    aux5 = 0;
                    while (aux5 == 0) {
                        System.out.println(
                                "-------BIENVENIDO------- \n¿Qué desea realizar? \n1.Ver cartelera \n2.Comprar boleto \n3.Salir");
                        int aux6 = cine.key.nextInt();
                        switch (aux6) {
                            case 1:
                                cine.verPeliculas();
                                break;
                            case 2:
                                cine.ComprarBoletos();
                                break;
                            case 3:
                                aux5++;
                                break;
                            default:
                                System.out.println("Opción no valida");
                                break;
                        }
                    }
                    break;
                case 3:
                    System.out.println("Hasta la proxima");
                    aux++;
                    break;
                default:
                    System.out.println("Seleccion no valida");
                    break;
            }
        }
    }
}
