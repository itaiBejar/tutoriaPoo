package mainFulbito;

import java.util.Scanner;
import servicio.JugadorServicio;

public class FulbitoMain {

    public static void main(String[] args) {

        
        JugadorServicio jugadorServicio = new JugadorServicio();

        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        boolean bucle = true;

        do {
            System.out.println("Seleccione una opción:\n"
                    + "1.- Crear lista de Jugadores\n"
                    + "2.- Ocupar la lista PreCreada\n"
                    + "3.- Mostrar datos completos de los equipos\n"
                    + "4.- Salir");

            switch (leer.next()) {

                case "1":
                    jugadorServicio.crearlistaJugadores();
                    jugadorServicio.sortearEquipos();
                    jugadorServicio.mostrarEquipos();
                    break;

                case "2":
                    jugadorServicio.listaPreCreada();
                    jugadorServicio.sortearEquipos();
                    jugadorServicio.mostrarEquipos();
                    break;

                case "3":
                    jugadorServicio.mostrarEquiposCompletos();
                    break;

                case "4":
                    bucle = false;
                    break;

                default:
                    System.out.println("Ingrese una opción válida!!");
            }
        } while (bucle);
    }

}
